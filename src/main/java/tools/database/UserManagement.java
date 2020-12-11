package tools.database;

import tools.pools.HikariCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {
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
