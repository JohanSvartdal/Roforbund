package servlets.Sider.TrenerServlets;

import models.test.Resultat;
import models.test.Test;
import servlets.AbstractAppServlet;
import tools.LocalStorage;
import tools.config.StaticValues;
import tools.database.DatabaseInfo;
import tools.database.DatabaseReader;
import tools.database.DatabaseValue;
import tools.database.DatabaseWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name= "RegTestResult", urlPatterns = {"/TrenerDash/HentOvelse/RegTestResult/"})
public class RegTestResult extends AbstractAppServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String people = request.getParameter("brukereTilStede");
        String ovelser = request.getParameter("ovelserValgt");
        String[] ovelserSplit = ovelser.split(",");

        String[] ovelsesIds = ovelser.split(",");
        String[] brukerIds = people.split(",");
        String[] brukerNavn = new String[brukerIds.length];

        for (int i = 0; i < brukerIds.length; i++) {
            String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", Integer.parseInt(brukerIds[i]), "Fornavn");
            String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", Integer.parseInt(brukerIds[i]), "Etternavn");
            brukerNavn[i] = fornavn + " " + etternavn;
        }

        int currentOvelseIndex = getCurrentOvelsesIndex(request);
        currentOvelseIndex = currentOvelseIndex + 1;

        String currentOvelsesNavn = DatabaseReader.getString("roforbund.ovelser", "Ovelse_id", ovelsesIds[currentOvelseIndex],"Navn");

        if (currentOvelseIndex == ovelserSplit.length - 1) {
            request.setAttribute("nesteKnapp", "Se over");
        }else {
            request.setAttribute("nesteKnapp", "Neste øvelse");
        }

        request.setAttribute("brukerIDs", brukerIds);
        request.setAttribute("brukerNavn", brukerNavn);
        request.setAttribute("currentOvelsesNavn", currentOvelsesNavn);
        request.setAttribute("currentOvelseIndex", currentOvelseIndex);
        request.getRequestDispatcher("../RegTestResult/index.jsp").forward(request, response);
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentOvelsesIndex = getCurrentOvelsesIndex(request);

        String people = request.getParameter("brukereTilStede");
        String ovelser = request.getParameter("ovelserValgt");
        String[] peopleSplit = people.split(",");
        String[] ovelserSplit = ovelser.split(",");

        int brukerID = LocalStorage.getUID(request, response);
        int klubbID = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", brukerID, "Klubb_id");

        String testIDString = request.getParameter("testID");
        int testID = 0;
        if (testIDString != null && !testIDString.equals("")) {
            testID = Integer.parseInt(testIDString);
        }else {
            testID = createNewTestID(klubbID, brukerID, ovelserSplit);
        }

        request.setAttribute("testID", testID);

        ArrayList<Resultat> resultatListe = new ArrayList<>();
        for(String person:peopleSplit) {
            Resultat resultat = new Resultat();
            resultat.setBrukerID(Integer.parseInt(person));
            resultat.setOvelsesID(Integer.parseInt(ovelserSplit[currentOvelsesIndex]));
            resultat.setWatt(Integer.parseInt(request.getParameter(person + "Watt")));
            resultat.setTid(Integer.parseInt(request.getParameter(person + "Tid")));
            resultat.setNotat(request.getParameter(person + "Notater"));
            resultat.setTestID(testID);
            resultatListe.add(resultat);
        }

        importResultater(resultatListe);

        if (currentOvelsesIndex == ovelserSplit.length-1) {
            //Nettop sendt inn siste øvelse
            response.sendRedirect("../SeOverResult?testID=" + testID);
        }else {
            super.doPost(request, response);
        }
    }

    public int createNewTestID(int klubbID, int brukerID, String[] ovelserSplit) {
        DatabaseValue[] databaseValues = new DatabaseValue[]{new DatabaseValue(klubbID),
                new DatabaseValue(brukerID),
                new DatabaseValue(StaticValues.RESULTAT_UTKAST),
                new DatabaseValue(ovelserSplit.length),
                new DatabaseValue("")};

        DatabaseWriter.addRowToTable("tester", DatabaseInfo.TESTER_KOLONNER, databaseValues);

        ResultSet lastRecord = DatabaseReader.getLastRecord("roforbund.tester", "Test_id");
        try {
            lastRecord.next();
            return lastRecord.getInt("Test_id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    private int getCurrentOvelsesIndex(HttpServletRequest request) {
        String currentOvelseIndexParamString = request.getParameter("currentOvelseIndex");
        String currentOvelseIndexAttString = (String) request.getAttribute("currentOvelseIndex");
        int currentOvelseIndex = -1;
        if (currentOvelseIndexParamString != null && !currentOvelseIndexParamString.equals("")) {
            currentOvelseIndex = Integer.parseInt(currentOvelseIndexParamString);
        }else if (currentOvelseIndexAttString != null && !currentOvelseIndexAttString.equals("")) {
            currentOvelseIndex = (int) request.getAttribute("currentOvelseIndex");
        }
        return currentOvelseIndex;
    }

    public void importResultater(ArrayList<Resultat> resultater) {
        for (Resultat resultat:resultater) {
            DatabaseValue[] databaseValues = new DatabaseValue[]{
                    new DatabaseValue(resultat.getOvelsesID()),
                    new DatabaseValue(resultat.getTestID()),
                    new DatabaseValue(resultat.getBrukerID()),
                    new DatabaseValue(resultat.getTid()),
                    new DatabaseValue(resultat.getWatt())};
            DatabaseWriter.addRowToTable("resultater", DatabaseInfo.RESULTATER_KOLONNER, databaseValues);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
