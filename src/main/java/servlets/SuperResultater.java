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

@WebServlet(name= "SuperResultater", urlPatterns = {"/SuperDash/Resultater/"})

public class SuperResultater extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Test> testListe = new ArrayList<>();
        ArrayList<Integer> testIds = DatabaseReader.getAllEntries("roforbund.tester", "Test_id");

        System.out.println("Lastet elementer: " + testIds.size());

        for (Integer id: testIds) {
            Test currentTest = new Test();
            currentTest.setTest_id(id);

            System.out.println("CurrentID: " + id);

            Timestamp date = DatabaseReader.getTimestamp("roforbund.tester", "Test_id", id, "Dato");
            String dateString = date.toString();
            System.out.println("Timestamp: " + dateString);
            currentTest.setDato(dateString);

            Integer antallOvelser = DatabaseReader.getInt("roforbund.tester", "Test_id", id, "Antall_ovelser");
            System.out.println("AntallOvelser: " + antallOvelser);
            currentTest.setAntallOvelser(antallOvelser);

            Integer trenerID = DatabaseReader.getInt("roforbund.tester", "Test_id", id, "Trener_id");
            System.out.println("TrenerID: " + trenerID);
            currentTest.setTrener_id(trenerID);
            String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", trenerID, "Fornavn");
            String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", trenerID, "Etternavn");
            System.out.println("Trener: " + fornavn + etternavn);
            currentTest.setTrenerNavn(fornavn + " " + etternavn);

            Integer klubbID = DatabaseReader.getInt("roforbund.tester", "Test_id", id, "Klubb_id");
            System.out.println("KlubbID: " + klubbID);
            currentTest.setKlubb_id(klubbID);
            String klubbNavn = DatabaseReader.getString("roforbund.klubber", "Klubb_id", klubbID, "Navn");
            System.out.println("TrenerID: " + klubbNavn);
            currentTest.setKlubbNavn(klubbNavn);

            testListe.add(currentTest);
        }

        System.out.println("Antall tester: " + testListe.size());

        request.setAttribute("testliste", testListe);
        RequestDispatcher rq = request.getRequestDispatcher("../../SuperDash/Resultater/index.jsp");
        rq.forward(request, response);
    }
}
