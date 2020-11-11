package servlets.Sider.UtoverServlets;

import servlets.AbstractAppServlet;
import servlets.OvelsesResultat;
import servlets.StaticValues;
import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name= "Resultat", urlPatterns = {"/UtoverDash/Resultater/Resultat/"})

public class Resultat extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String testIDString = request.getParameter("TestID");
        int testID = Integer.parseInt(testIDString);

        Date dato = DatabaseReader.getDate("roforbund.tester", "Test_id", testID, "Dato");
        int godkjentStatus = DatabaseReader.getInt("roforbund.tester", "Test_id", testID, "Godkjent");
        String datoString = dato.toString();

        ArrayList<servlets.Resultat> resultatList = new ArrayList<>();

        ResultSet resultaterITest = DatabaseReader.getResultSet("roforbund.resultater", "Test_id", testIDString);
        try {
            while (resultaterITest.next()) {
                servlets.Resultat resultat = new servlets.Resultat();
                resultat.setResultatID(resultaterITest.getInt("Resultat_id"));
                resultat.setTestID(testID);

                resultat.setBrukerID(resultaterITest.getInt("Bruker_id"));
                System.out.println("BrukerID: " + resultat.getBrukerID() + "ResultatID: " + resultat.getResultatID());

                ResultSet brukerResult = DatabaseReader.getResultSet("roforbund.bruker", "Bruker_id", resultat.getBrukerID());
                brukerResult.next();
                String brukerNavn = brukerResult.getString("Fornavn");
                brukerNavn = brukerNavn + " " + brukerResult.getString("Etternavn");
                resultat.setBrukerNavn(brukerNavn);
                brukerResult.close();

                resultat.setOvelsesID(resultaterITest.getInt("Ovelse_id"));

                resultat.setKg(resultaterITest.getInt("KG"));
                resultat.setRepetisjoner(resultaterITest.getInt("Repetisjoner"));
                resultat.setWatt(resultaterITest.getInt("Watt"));
                resultat.setTid(resultaterITest.getInt("Tid"));

                resultatList.add(resultat);
            }
            resultaterITest.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        ArrayList<OvelsesResultat> ovelsesResultatList = new ArrayList<>();

        for (servlets.Resultat currentResultat: resultatList) {
            System.out.println("Skal nå jobbe med resultat: " + currentResultat.getResultatID());
            boolean alreadyAdded = false;
            for (int i = 0; i < ovelsesResultatList.size(); i++) {
                if (currentResultat.getOvelsesID() == ovelsesResultatList.get(i).getOvelsesID()) {
                    alreadyAdded = true;
                    ovelsesResultatList.get(i).addToResultater(currentResultat);
                    break;
                }else {}
            }

            if (!alreadyAdded) {
                System.out.println("Ikke allerede lagt til: " + currentResultat.getOvelsesID());
                OvelsesResultat ovelsesResultat = new OvelsesResultat();
                ovelsesResultat.setResultater(new ArrayList<>());
                ovelsesResultat.setOvelsesID(currentResultat.getOvelsesID());
                String ovelsesNavn = DatabaseReader.getString("roforbund.ovelser", "Ovelse_id", currentResultat.getOvelsesID(), "Navn");
                ovelsesResultat.setOvelsesNavn(ovelsesNavn);
                ovelsesResultat.addToResultater(currentResultat);
                ovelsesResultatList.add(ovelsesResultat);
                System.out.println("Lagt til i liste: " + ovelsesResultat.getOvelsesNavn() + " for: " + currentResultat.getBrukerNavn());
            }
        }


        System.out.println("Ferdig Java");
        request.setAttribute("ovelsesresultatlist", ovelsesResultatList);


        if (godkjentStatus == StaticValues.RESULTAT_GODKJENT) {
            request.setAttribute("GodkjentStatus", "");
        }else if (godkjentStatus == StaticValues.RESULTAT_KLAR) {
            request.setAttribute("GodkjentStatus", "GodkjenningKlar");
        }

        request.setAttribute("TestID", testID);
        request.setAttribute("Dato", datoString);
        RequestDispatcher rq = request.getRequestDispatcher("../../../UtoverDash/Resultater/Resultat/index.jsp");
        rq.forward(request, response);
    }
}