package tools.repository;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tools.DbTool;

public class DatabaseReader {

    public static Integer getInt(String database, String searchKey, int searchInt, String whatData) {
        return getInt(database, searchKey, null, String.valueOf(searchInt), whatData);
    }

    public static Integer getInt(String database, String searchKey, String searchString, String whatData) {
        return getInt(database, searchKey, searchString, null, whatData);
    }

    public static Integer getInt(String database, String searchKey, String searchString, String searchInter, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        Connection db = null;
        PreparedStatement prepareStatement = null;

        int toReturn = 0;
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM " + database + " where " + searchKey + " = ?";
            prepareStatement = db.prepareStatement(query);
            if (searchInter == null) {
                prepareStatement.setString(1, searchString);
            }else {
                prepareStatement.setInt(1, searchInt);
            }

            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getInt(whatData);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }

    public static String getString(String database, String searchKey, int searchInt, String whatData) {
        return getString(database, searchKey, null, String.valueOf(searchInt), whatData);
    }

    public static String getString(String database, String searchKey, String searchString, String whatData) {
        return getString(database, searchKey, searchString, null, whatData);
    }

    public static String getString(String database, String searchKey, String searchString, String searchInter, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        Connection db = null;
        PreparedStatement prepareStatement = null;

        String toReturn = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM " + database + " where " + searchKey + " = ?";
            prepareStatement = db.prepareStatement(query);
            if (searchInter == null) {
                prepareStatement.setString(1, searchString);
            }else {
                prepareStatement.setInt(1, searchInt);
            }

            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getString(whatData);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }

    public static ArrayList<Integer> getListOfIds(String databaseNavn, String searchKey, String searchString, String returnColumn) {
        return getListOfIds(databaseNavn, searchKey, 0, searchString, returnColumn);
    }

    public static ArrayList<Integer> getListOfIds(String databaseNavn, String searchKey, int searchInt, String returnColumn) {
        return getListOfIds(databaseNavn, searchKey, searchInt, null, returnColumn);
    }

    //DENNE ER IKKE TESTET OM FUNKER ENDA
    public static ArrayList<Integer> getListOfIds(String databaseNavn, String searchKey,int searchInt, String searchString, String returnColumn) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<Integer> returnList = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM " + databaseNavn + " where " + searchKey + " = ?";
            prepareStatement = db.prepareStatement(query);
            if (searchString == null) {
                prepareStatement.setInt(1, searchInt);
            }else {
                prepareStatement.setString(1, searchString);
            }

            System.out.println(prepareStatement.toString());
            rs = prepareStatement.executeQuery();

            while (rs.next()) {
                returnList.add(rs.getInt(returnColumn));
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return returnList;
    }

    //DENNE ER IKKE TESTET OM FUNKER ENDA
    public static ArrayList<Integer> getAllEntries(String databaseNavn, String returnColumn) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<Integer> returnList = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM " + databaseNavn;
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                returnList.add(rs.getInt(returnColumn));
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return returnList;
    }
}