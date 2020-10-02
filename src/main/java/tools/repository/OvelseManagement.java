package tools.repository;

import servlets.Ovelse;
import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OvelseManagement {
    public static ArrayList<Ovelse> getAllOvelser() {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<Ovelse> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM otra.ovelser";
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();

            while (rs.next()) {
                Ovelse ovelse = new Ovelse();
                ovelse.setOvelseID(rs.getInt("OvelseID"));
                ovelse.setOvelseNavn(rs.getString("OvelseNavn"));
                toReturn.add(ovelse);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }

    public static String[] getAllUserOvelser(Integer userID, PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<String> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM otra.resultater where UserID = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setInt(1, userID);
            rs = prepareStatement.executeQuery();
            String alreadyAdded = "";

            while (rs.next()) {
                int currentAdd = rs.getInt("OvelseID");
                if (!alreadyAdded.contains(String.valueOf(currentAdd))) {
                    alreadyAdded = alreadyAdded + String.valueOf(currentAdd);
                    String ovelsesNavn = DatabaseReader.getString("otra.ovelser", "Ovelse_ID", currentAdd,"Ovelse_navn");
                    toReturn.add(ovelsesNavn);
                }
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String[] arrayOfEverything = new String[toReturn.size()];
        arrayOfEverything = toReturn.toArray(arrayOfEverything);

        return arrayOfEverything;
    }
}
