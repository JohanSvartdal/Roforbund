package tools.repository;

import tools.DbTool;

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

        System.out.println("HEr er det: " + poststed+postnummer+gatenavn+husnummer);

        boolean postnummerExists = DatabaseReader.getString("roforbund.postnummere", "Postnummer", postnummer, "Poststed") != null;

        if (!postnummerExists) {
            System.out.println("Postnummer eksisterer ikke. Legger til " + postnummer);
            DatabaseValue[] postnummerTableVerdier = {new DatabaseValue(postnummer), new DatabaseValue(poststed)};
            DatabaseWriter.addRowToTable("postnummere", "Postnummer, Poststed", postnummerTableVerdier);
        }

        DatabaseValue[] adresseTableVerdier = {new DatabaseValue(compKey),new DatabaseValue(gatenavn), new DatabaseValue(husnummer), new DatabaseValue(postnummer)};
        DatabaseWriter.addRowToTable("adresser", "Adresse_id, Gatenavn, Husnummer, Postnummer", adresseTableVerdier);

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
            db = DbTool.getINSTANCE().dbLoggIn();
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
}
