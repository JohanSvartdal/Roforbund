package servlets.Sider.TrenerServlets;

import servlets.AbstractAppServlet;
import models.test.Test;
import tools.databaseTools.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
// Servlet for å søke etter tester.
// Formål: Lar brukeren søke etter tidligere tester.

@WebServlet(name= "SokEtterTest")

public class SokEtterTest extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    // Denne metoden lager en arrayliste med alle testene til treneren som søker
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        ArrayList<Integer> trenerId = DatabaseReader.getAllEntries("roforbund.tester", "Test_id");
        ArrayList<Test> TestListe = new ArrayList<>();

        for (int i = 0; i < trenerId.size(); i++ ) {
            Test current = new Test();

            Integer test_id = DatabaseReader.getInt("roforbund.tester", "Trener_id", trenerId.get(i), "Test_id");
            Integer klubb_id = DatabaseReader.getInt("roforbund.tester", "Trener_id", trenerId.get(i), "Klubb_id");
            String dato = DatabaseReader.getString("roforbund.tester", "Trener_id", trenerId.get(i), "Dato");
            Integer trener_id = DatabaseReader.getInt("roforbund.tester", "Trener_id", trenerId.get(i), "Trener_id");
            Integer godkjent = DatabaseReader.getInt("roforbund.tester", "Trener_id", trenerId.get(i), "Godkjent");

            current.setTestListe(test_id + " " + klubb_id + " " + dato + " " + trener_id + " " + godkjent);

            ArrayList<Integer> testIds = DatabaseReader.getListOfIds("roforbund.tester", "trener_id", trenerId.get(i), "Test_id");
            current.setAntallOvelser(testIds.size());


            TestListe.add(current);
        }
        // Sender deg videre med testlisten
        request.setAttribute("TestListe", TestListe);
        RequestDispatcher rq = request.getRequestDispatcher("../Trenerdash/index.jsp");
        rq.forward(request, response);
    }
}
