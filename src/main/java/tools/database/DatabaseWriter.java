package tools.database;

import tools.pools.HikariCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWriter {

    public static String createAdress(String gatenavn, int husnummer, int postnummer, String poststed) {
        String compKey = postnummer + gatenavn + husnummer;
        compKey = compKey.toLowerCase();
        boolean adresseExist = DatabaseReader.getString("roforbund.adresser", "Adresse_id", compKey, "Husnummer") != null;

        if (adresseExist) {
            System.out.println("Adressen eksisterer allerede. Lager ingen ny");
            return compKey;
        }

        System.out.println("Her er det: " + poststed+postnummer+gatenavn+husnummer);

        boolean postnummerExists = DatabaseReader.getString("roforbund.postnummere", "Postnummer", postnummer, "Poststed") != null;

        if (!postnummerExists) {
            System.out.println("Postnummer eksisterer ikke. Legger til " + postnummer);
            DatabaseValue[] postnummerTableVerdier = {new DatabaseValue(postnummer), new DatabaseValue(poststed)};
            DatabaseWriter.addRowToTable("postnummere", DatabaseInfo.POSTNUMMERE_KOLONNER, postnummerTableVerdier);
        }

        DatabaseValue[] adresseTableVerdier = {new DatabaseValue(compKey),new DatabaseValue(gatenavn), new DatabaseValue(husnummer), new DatabaseValue(postnummer)};
        DatabaseWriter.addRowToTable("adresser", DatabaseInfo.ADRESSER_KOLONNER, adresseTableVerdier);

        return compKey;
    }

    /*
    EKSEMPEL PÅ BRUK:

        DatabaseValue navn = new DatabaseValue("Hei");
        DatabaseValue adresseId = new DatabaseValue(1);
        DatabaseValue tlf = new DatabaseValue(40640382);
        DatabaseWriter.addRowToTable("klubber", "Navn, Adresse_id, Tlf", new DatabaseValue[]{navn,adresseId,tlf});
     */

    public static void addRowToTable(String tableName, String columnNames, DatabaseValue[] columnValues) {
        Connection db = null;
        PreparedStatement preparedStatement = null;
        try {
            db = HikariCPDataSource.getConnection();
            PreparedStatement dbUse = db.prepareStatement("USE roforbund");
            dbUse.executeQuery();

            String query = "INSERT INTO `" + tableName + "` ("+ columnNames + ") values (";
            for (int i = 0; i < columnValues.length; i++) {
                if (i != 0) {
                    query = query + ", ";
                }
                query = query + "?";
            }
            query = query + ")";

            preparedStatement = db.prepareStatement(query);
            for (int i = 0; i < columnValues.length; i++) {
                if (columnValues[i].text != null) {
                    preparedStatement.setString(i+1, columnValues[i].text);
                }else if (columnValues[i].date != null) {
                    preparedStatement.setDate(i+1, columnValues[i].date);
                }else if (columnValues[i].aBoolean != null) {
                    preparedStatement.setBoolean(i+1, columnValues[i].aBoolean);
                }else {
                    preparedStatement.setInt(i+1, columnValues[i].number);
                }
            }

            System.out.println("PrepState:" + preparedStatement.toString());
            preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            System.out.println("Feil");
            throwables.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void changeCellValue(String tableName, String searchKey, String searchString, String columnToChange, DatabaseValue newValue) {
        changeCellValue(tableName, searchKey, searchString, 0, columnToChange, newValue);
    }

    public static void changeCellValue(String tableName, String searchKey, int searchInt, String columnToChange, DatabaseValue newValue) {
        changeCellValue(tableName, searchKey, null, searchInt, columnToChange, newValue);
    }

    public static void changeCellValue(String tableName, String searchKey, String searchString, int searchInt, String columnToChange, DatabaseValue newValue) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        String toReturn = null;
        try {
            db = HikariCPDataSource.getConnection();
            PreparedStatement dbUse = db.prepareStatement("USE roforbund");
            dbUse.executeQuery();

            String query = "UPDATE " + tableName + " SET " + columnToChange + "=?" + " WHERE " + searchKey + "=?";

            PreparedStatement preparedStatement = db.prepareStatement(query);
            if (newValue.text != null) {
                preparedStatement.setString(1, newValue.text);
            }else if (newValue.date != null) {
                preparedStatement.setDate(1, newValue.date);
            }else if (newValue.aBoolean != null) {
                preparedStatement.setBoolean(1, newValue.aBoolean);
            }else {
                preparedStatement.setInt(1, newValue.number);
            }

            if (searchString != null) {
                preparedStatement.setString(2, searchString);
            }else {
                preparedStatement.setInt(2, searchInt);
            }

            preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            System.out.println("Feil");
            throwables.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void removeRow(String tableName, String searchKey, String searchString) {
        removeRow(tableName, searchKey, searchString, -1);
    }


    public static void removeRow(String tableName, String searchKey, int searchInt) {
        removeRow(tableName, searchKey, null, searchInt);

    }

    public static void removeRow(String tableName, String searchKey, String searchString, int searchInt) {
        Connection db = null;
        PreparedStatement preparedStatement = null;
        try {
            db = HikariCPDataSource.getConnection();
            PreparedStatement dbUse = db.prepareStatement("USE roforbund");
            dbUse.executeQuery();

            String query = "DELETE FROM `" + tableName + "` WHERE " + searchKey + "=?";

            preparedStatement = db.prepareStatement(query);
            if (searchString != null) {
                preparedStatement.setString(1, searchString);
            }else {
                preparedStatement.setInt(1, searchInt);
            }

            System.out.println("PrepState:" + preparedStatement.toString());
            preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            System.out.println("Feil");
            throwables.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
