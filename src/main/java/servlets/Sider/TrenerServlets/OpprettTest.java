package servlets.Sider.TrenerServlets;

import servlets.AbstractAppServlet;
import tools.LocalStorage;
import tools.config.StaticValues;
import models.bruker.Utover;
import tools.databaseTools.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// Servlet for å opprette test. Finnes under trenerdashboard /OpprettTest/
// Formål: La trener opprette en ny test med valgte utovere, tester og resultater.

@WebServlet(name= "OpprettTest", urlPatterns = {"/TrenerDash/OpprettTest/"})
public class OpprettTest extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }
    //Denne metoden henter en liste med utovere som tilhører samme klubb som trener som skal opprette test.
    //formål: Henter ikke unødvendige utøvere, kun de som har lik klubb som trener.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int UID = LocalStorage.getUID(request, response);

        int klubbID = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", UID, "Klubb_id");
        // Lager en arraylist med alle utøverene.
        ArrayList<Integer> brukerIds = DatabaseReader.getListOfIds("roforbund.bruker", "Klubb_id", klubbID, "Bruker_id");

        ArrayList<Utover> utoverList = new ArrayList<>();
        for (int i = 0; i < brukerIds.size(); i++) {
            int rolle = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", brukerIds.get(i), "Rolle");
            if (rolle != StaticValues.UTOVER) {
                continue;
            }

            String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", brukerIds.get(i), "Fornavn");
            String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", brukerIds.get(i), "Etternavn");

            Utover utover = new Utover(fornavn, etternavn, brukerIds.get(i));

            utoverList.add(utover);
        }
        // Sender deg videre med utøverlisten
        request.setAttribute("utoverListe", utoverList);
        RequestDispatcher rq = request.getRequestDispatcher("../OpprettTest/index.jsp");
        rq.forward(request, response);

    }
}
