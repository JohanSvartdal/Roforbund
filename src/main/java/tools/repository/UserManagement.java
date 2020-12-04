package tools.repository;

import models.UserModel;
import tools.DbTool;
import tools.pools.HikariCPDataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManagement {
    public static void addUser(UserModel user) {
        Connection db = null;
        PreparedStatement insertNewUser = null;
        try {
            db = HikariCPDataSource.getConnection();
            String query =
                    "INSERT INTO `user` (User_firstName, User_lastName,User_Email, User_password ) values (?,?,?,?)";

            insertNewUser = db.prepareStatement(query);
            insertNewUser.setString(1, user.getFirstName());
            insertNewUser.setString(2, user.getLastName());
            insertNewUser.setString(3, user.getUserName());
            insertNewUser.setString(4, user.getPassword());
            insertNewUser.execute();
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

    public static ArrayList<ArrayList<String>> getAllMembers(Integer klubbID, PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<ArrayList<String>> userProfiles = new ArrayList<>();
        try {
            db = HikariCPDataSource.getConnection();
            ResultSet rs = null;
            String query = "SELECT * FROM roforbund.bruker where Klubb_id = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setInt(1, klubbID);
            rs = prepareStatement.executeQuery();
            String alreadyAdded = "";

            while (rs.next()) {
                ArrayList<String> profileInfo = new ArrayList<>();
                int currentAdd = rs.getInt("User_id");

                profileInfo.add(String.valueOf(currentAdd));
                profileInfo.add(rs.getString("User_firstName"));
                profileInfo.add(rs.getString("User_lastName"));
                userProfiles.add(profileInfo);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userProfiles;
    }

    //Tenkte å endre denne til 'isUserAuthenticated', hvor programmet sjekker om brukeren er authenticated
    public static String getUserPassword(String username) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        String toReturn = null;

        try {
            db = HikariCPDataSource.getConnection();
            ResultSet rs = null;
            String query = "SELECT * FROM roforbund.bruker where Epost = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setString(1, username);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getString("Passord");
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }
}
