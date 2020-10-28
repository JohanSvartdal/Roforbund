package servlets;

import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(name= "SuperResultat", urlPatterns = {"/SuperDash/Resultater/Resultat/"})

public class SuperResultat extends AbstractAppServlet {
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

        Timestamp dato = DatabaseReader.getTimestamp("roforbund.tester", "Test_id", testID, "Dato");
        String datoString = dato.toString();

        ArrayList<Resultat> resultatList = new ArrayList<>();

        ArrayList<Integer> resultatIds = DatabaseReader.getListOfIds("roforbund.resultater", "Test_id", testID, "Resultat_id");

        for (Integer resultatID:resultatIds) {
            Resultat resultat = new Resultat();
            resultat.setResultatID(resultatID);
            resultat.setTestID(testID);

            Integer brukerID = DatabaseReader.getInt("roforbund.resultater", "Resultat_id", resultatID, "Bruker_id");
            resultat.setBrukerID(brukerID);

            String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", brukerID, "Fornavn");
            String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", brukerID, "Etternavn");
            resultat.setBrukerNavn(fornavn + " " + etternavn);

            Integer ovelsesID = DatabaseReader.getInt("roforbund.resultater", "Resultat_id", resultatID, "Ovelse_id");
            resultat.setOvelsesID(ovelsesID);

            Integer kg = DatabaseReader.getInt("roforbund.resultater", "Resultat_id", resultatID, "KG");
            if (kg != null) {
                resultat.setKg(kg);
            }

            Integer reps = DatabaseReader.getInt("roforbund.resultater", "Resultat_id", resultatID, "Repetisjoner");
            if (reps != null) {
                resultat.setRepetisjoner(reps);
            }

            Integer tid = DatabaseReader.getInt("roforbund.resultater", "Resultat_id", resultatID, "Tid");
            if (tid != null) {
                resultat.setTid(tid);
            }

            Integer watt = DatabaseReader.getInt("roforbund.resultater", "Resultat_id", resultatID, "Watt");
            if (watt != null) {
                resultat.setWatt(watt);
            }

            resultatList.add(resultat);
        }

        ArrayList<OvelsesResultat> ovelsesResultatList = new ArrayList<>();

        for (Resultat currentResultat: resultatList) {
            boolean alreadyAdded = false;
            for (int i = 0; i < ovelsesResultatList.size(); i++) {
                OvelsesResultat ovelsesResultat = ovelsesResultatList.get(i);
                if (ovelsesResultat.getOvelsesID() == currentResultat.getOvelsesID()) {
                    ArrayList<Resultat> currentOvelseResultList = ovelsesResultatList.get(i).getResultater();
                    currentOvelseResultList.add(currentResultat);
                    ovelsesResultatList.get(i).setResultater(currentOvelseResultList);
                    alreadyAdded = true;
                    break;
                }
            }

            if (!alreadyAdded) {
                OvelsesResultat ovelsesResultat = new OvelsesResultat();
                ArrayList<Resultat> currentOvelseResultat = new ArrayList<>();
                currentOvelseResultat.add(currentResultat);
                ovelsesResultat.setResultater(currentOvelseResultat);

                ovelsesResultat.setOvelsesID(currentResultat.getOvelsesID());

                String ovelsesNavn = DatabaseReader.getString("roforbund.ovelser", "Ovelse_id", currentResultat.getOvelsesID(), "Navn");
                ovelsesResultat.setOvelsesNavn(ovelsesNavn);
                ovelsesResultatList.add(ovelsesResultat);
            }
        }

        request.setAttribute("ovelsesresultatlist", ovelsesResultatList);

        request.setAttribute("Dato", datoString);
        RequestDispatcher rq = request.getRequestDispatcher("../../../SuperDash/Resultater/Resultat/index.jsp");
        rq.forward(request, response);
    }
}
