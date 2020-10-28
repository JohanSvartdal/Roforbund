package servlets;

import tools.repository.DatabaseReader;
import tools.repository.DatabaseValue;
import tools.repository.DatabaseWriter;
import tools.repository.UserManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name= "OpprettTest", urlPatterns = {"/TrenerDash/OpprettTest/"})
public class OpprettTest extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> brukerIds = DatabaseReader.getListOfIds("roforbund.bruker", "Klubb_id",1, "Bruker_id");

        ArrayList<Utover> utoverList = new ArrayList<>();
        for (int i = 0; i < brukerIds.size(); i++) {
            Utover utover = new Utover();
            String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", brukerIds.get(i), "Fornavn");
            String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", brukerIds.get(i), "Etternavn");
            utover.setFornavn(fornavn);
            utover.setEtternavn(etternavn);
            utoverList.add(utover);
        }

        request.setAttribute("utoverListe", utoverList);
        RequestDispatcher rq = request.getRequestDispatcher("../OpprettTest/index.jsp");
        rq.forward(request, response);

    }
}
