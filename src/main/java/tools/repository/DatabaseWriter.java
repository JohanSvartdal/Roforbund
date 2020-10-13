package tools.repository;

import tools.DbTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWriter {

    public static void safeAdd() {

        String query = "INSERT INTO klubber(Navn, Adresse_id, Tlf) values (?, ?, ?)";

        try {
            Connection db = DbTool.getINSTANCE().dbLoggIn();

            PreparedStatement dbUse = db.prepareStatement("USE roforbund");
            dbUse.executeQuery();

            PreparedStatement preparedStatement = db.prepareStatement(query);
            preparedStatement.setString(1, "SafeTest");
            preparedStatement.setInt(2, 2);
            preparedStatement.setInt(3, 93064217);
            System.out.println("SafePrepState: " + preparedStatement.toString());
            preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
