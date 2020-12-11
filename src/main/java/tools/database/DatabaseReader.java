package tools.database;

import java.sql.*;
import java.util.ArrayList;

import tools.pools.HikariCPDataSource;

public class DatabaseReader {

    //TODO: abstrakt klasse "database", som handler alt med connections og errors med connections osv. Databasereader og writer skal kun lese og skrive.

    public static ResultSet getLastRecord(String database, String primaryKey) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ResultSet rs = null;
        try {
            db = HikariCPDataSource.getConnection();
            String query = "SELECT * FROM " + database + " ORDER BY " + primaryKey + " DESC LIMIT 1";

            prepareStatement = db.prepareStatement(query);
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

        ResultSet rs = null;
        int toReturn = 0;

        if (searchInter != null) {
            rs = getResultSet(database, searchKey, searchInt);;
        }else {
            rs = getResultSet(database, searchKey, searchString);
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    toReturn = rs.getInt(whatData);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println("Tried to get column: " + whatData + " for " + searchKey + ":" + searchString + "/" + searchInter + " and received: " + toReturn);
        return toReturn;
    }

    public static String getString(String databaseNavn, String searchKey, String searchString, String whatData) {
        return getString(databaseNavn, searchKey, searchString, null, whatData);
    }

    public static String getString(String database, String searchKey, int searchInt, String whatData) {
        return getString(database, searchKey, null, String.valueOf(searchInt), whatData);
    }

    public static String getString(String database, String searchKey, String searchString, String searchInter, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        ResultSet rs = null;
        String toReturn = null;

        if (searchInter != null) {
            rs = getResultSet(database, searchKey, searchInt);;
        }else {
            rs = getResultSet(database, searchKey, searchString);
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    toReturn = rs.getString(whatData);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println("Tried to get column: " + whatData + " for " + searchKey + ":" + searchString + "/" + searchInter + " and received: " + toReturn);
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

        ResultSet rs = null;
        Timestamp toReturn = null;

        if (searchInter != null) {
            rs = getResultSet(database, searchKey, searchInt);;
        }else {
            rs = getResultSet(database, searchKey, searchString);
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    toReturn = rs.getTimestamp(whatData);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println("Tried to get column: " + whatData + " for " + searchKey + ":" + searchString + "/" + searchInter + " and received: " + toReturn);
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

        ResultSet rs = null;
        Date toReturn = null;

        if (searchInter != null) {
            rs = getResultSet(database, searchKey, searchInt);;
        }else {
            rs = getResultSet(database, searchKey, searchString);
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    toReturn = rs.getDate(whatData);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println("Tried to get column: " + whatData + " for " + searchKey + ":" + searchString + "/" + searchInter + " and received: " + toReturn);
        return toReturn;
    }

    public static ArrayList<Integer> getListOfIds(String databaseNavn, String searchKey, String searchString, String returnColumn) {
        return getListOfIds(databaseNavn, searchKey, "0", searchString, returnColumn);
    }

    public static ArrayList<Integer> getListOfIds(String databaseNavn, String searchKey, int searchInt, String returnColumn) {
        return getListOfIds(databaseNavn, searchKey, String.valueOf(searchInt), null, returnColumn);
    }

    public static ArrayList<Integer> getListOfIds(String databaseNavn, String searchKey, String searchInter, String searchString, String returnColumn) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        ResultSet rs = null;
        ArrayList<Integer> returnList = new ArrayList<>();

        if (searchInter != null) {
            rs = getResultSet(databaseNavn, searchKey, searchInt);;
        }else {
            rs = getResultSet(databaseNavn, searchKey, searchString);
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    returnList.add(rs.getInt(returnColumn));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println("Tried to get data: " + returnColumn + " for " + searchKey + ":" + searchString + "/" + searchInter + " and received: " + returnList);
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
        }

        //TODO: denne closer ikke databaseconnection

        return returnList;
    }

    public static Boolean getBoolean(String databaseNavn, String searchKey, String searchString, String whatData) {
        return getBoolean(databaseNavn, searchKey, null, searchString, whatData);
    }

    public static Boolean getBoolean(String databaseNavn, String searchKey, int searchInt, String whatData) {
        return getBoolean(databaseNavn, searchKey, String.valueOf(searchInt), null, whatData);
    }

    public static Boolean getBoolean(String databaseNavn, String searchKey, String searchInter, String searchString, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        ResultSet rs = null;
        Boolean toReturn = null;

        if (searchInter != null) {
            rs = getResultSet(databaseNavn, searchKey, searchInt);;
        }else {
            rs = getResultSet(databaseNavn, searchKey, searchString);
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    toReturn = rs.getBoolean(whatData);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println("Tried to get column: " + whatData + " for " + searchKey + ":" + searchString + "/" + searchInter + " and received: " + toReturn);
        return toReturn;
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
        }

        return rs;
    }

    public static boolean loginCorrect(String email, String password) {
        String passwordFromDB = DatabaseReader.getString("roforbund.bruker", "Epost", email, "Passord");

        if (passwordFromDB != null && password != null) {
            return password.equals(passwordFromDB);
        }else {
            return false;
        }
    }
}