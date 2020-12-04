package tools.repository;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import tools.DbTool;
import tools.pools.HikariCPDataSource;

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

        Integer toReturn = null;
        try {
            db = HikariCPDataSource.getConnection();
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
                System.out.println(searchKey + "= " + searchInter + ". Her lastet jeg tallet: " + toReturn);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
            db = HikariCPDataSource.getConnection();
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
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return toReturn;
    }

    public static Timestamp getTimestamp(String database, String searchKey, int searchInt, String whatData) {
        return getTimestamp(database, searchKey, null, String.valueOf(searchInt), whatData);
    }

    public static Timestamp getTimestamp(String database, String searchKey, String searchString, String whatData) {
        return getTimestamp(database, searchKey, searchString, null, whatData);
    }

    public static Timestamp getTimestamp(String database, String searchKey, String searchString, String searchInter, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        Connection db = null;
        PreparedStatement prepareStatement = null;

        Timestamp toReturn = null;
        try {
            db = HikariCPDataSource.getConnection();
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
                toReturn = rs.getTimestamp(whatData);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return toReturn;
    }

    public static Date getDate(String database, String searchKey, int searchInt, String whatData) {
        return getDate(database, searchKey, null, String.valueOf(searchInt), whatData);
    }

    public static Date getDate(String database, String searchKey, String searchString, String whatData) {
        return getDate(database, searchKey, searchString, null, whatData);
    }

    public static Date getDate(String database, String searchKey, String searchString, String searchInter, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        Connection db = null;
        PreparedStatement prepareStatement = null;

        Date toReturn = null;
        try {
            db = HikariCPDataSource.getConnection();
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
                toReturn = rs.getDate(whatData);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
            db = HikariCPDataSource.getConnection();
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
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return returnList;
    }

    //DENNE ER IKKE TESTET OM FUNKER ENDA
    public static ArrayList<Integer> getAllEntries(String databaseNavn, String returnColumn) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<Integer> returnList = new ArrayList<>();
        try {
            db = HikariCPDataSource.getConnection();
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
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return returnList;
    }

    public static ResultSet getResultSet(String databaseNavn) {
        return getResultSet(databaseNavn, null, null, 0);
    }

    public static ResultSet getResultSet(String databaseNavn, String searchKey, String searchString) {
        return getResultSet(databaseNavn, searchKey, searchString, 0);
    }

    public static ResultSet getResultSet(String databaseNavn, String searchKey, int searchInt) {
        return getResultSet(databaseNavn, searchKey, null, searchInt);
    }

    public static ResultSet getResultSet(String databaseNavn, String searchKey, String searchString, int searchInt) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ResultSet rs = null;
        try {
            db = HikariCPDataSource.getConnection();
            String query = null;
            if (searchKey != null) {
                query = "SELECT * FROM " + databaseNavn + " where " + searchKey + " = ?";
            }else {
                query = "SELECT * FROM " + databaseNavn;
            }
            prepareStatement = db.prepareStatement(query);

            if (searchKey != null) {
                if (searchString == null) {
                    prepareStatement.setInt(1, searchInt);
                }else {
                    prepareStatement.setString(1, searchString);
                }
            }
            rs = prepareStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return rs;
    }

    public static Boolean getBoolean(String databaseNavn, String searchKey, String searchString, String whatData) {
        return getBoolean(databaseNavn, searchKey, -1, searchString, whatData);
    }

    public static Boolean getBoolean(String databaseNavn, String searchKey, int searchInt, String whatData) {
        return getBoolean(databaseNavn, searchKey, searchInt, null, whatData);
    }

    public static Boolean getBoolean(String databaseNavn, String searchKey, int searchInt, String searchString, String whatData) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        Boolean toReturn = null;
        try {
            db = HikariCPDataSource.getConnection();
            ResultSet rs = null;
            String query = "SELECT * FROM " + databaseNavn + " where " + searchKey + " = ?";
            prepareStatement = db.prepareStatement(query);
            if (searchString != null) {
                prepareStatement.setString(1, searchString);
            }else {
                prepareStatement.setInt(1, searchInt);
            }

            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getBoolean(whatData);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return toReturn;
    }
}