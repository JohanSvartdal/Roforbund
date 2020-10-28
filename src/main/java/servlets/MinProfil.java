package servlets;

import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name= "MinProfil")

public class MinProfil extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Integer> utoverId = DatabaseReader.getAllEntries("roforbund.tester", "Test_id");
        ArrayList<Test> TestListe = new ArrayList<>();

        for (int i = 0; i < utoverId.size(); i++ ) {
            Test current = new Test();

            Integer test_id = DatabaseReader.getInt("roforbund.tester", "Utover_id", utoverId.get(i), "Test_id");
            Integer klubb_id = DatabaseReader.getInt("roforbund.tester", "Utover_id", utoverId.get(i), "Klubb_id");
            String dato = DatabaseReader.getString("roforbund.tester", "Utover_id", utoverId.get(i), "Dato");
            Integer utover_id = DatabaseReader.getInt("roforbund.tester", "Utover_id", utoverId.get(i), "Trener_id");
            Integer godkjent = DatabaseReader.getInt("roforbund.tester", "Utover_id", utoverId.get(i), "Godkjent");

            current.setTestListe(test_id + " " + klubb_id + " " + dato + " " + utover_id + " " + godkjent);

            ArrayList<Integer> testIds = DatabaseReader.getListOfIds("roforbund.tester", "utover_id", utoverId.get(i), "Test_id");
            current.setAntallOvelser(testIds.size());


            TestListe.add(current);
        }
        request.setAttribute("TestListe", TestListe);
        RequestDispatcher rq = request.getRequestDispatcher("../Utoverdash/index.jsp");
        rq.forward(request, response);
    }
}
