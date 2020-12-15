package servlets.Sider.TrenerServlets;

import servlets.AbstractAppServlet;
import models.test.Ovelse;
import tools.databaseTools.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
// Servlet for å hente øvelser.
// Formål: Lager en liste med ulike øvelser fra databasen. Dette for å kun gi gyldige øvelser under en test.
// Brukes i OpprettTest
@WebServlet(name= "HentOvelse", urlPatterns = {"/TrenerDash/HentOvelse/"})
public class HentOvelse extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }
    // Denne metoden lager en arraylist med alle øvelsene fra databasen.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> ovelseIds = DatabaseReader.getAllEntries("roforbund.ovelser", "Ovelse_id");

        ArrayList<Ovelse> ovelseList = new ArrayList<>();
        for (int i = 0; i < ovelseIds.size(); i++) {
            Ovelse ovelse = new Ovelse();
            String ovelseNavn = DatabaseReader.getString("roforbund.ovelser", "Ovelse_id", ovelseIds.get(i), "Navn");
            ovelse.setOvelseNavn(ovelseNavn);
            ovelse.setOvelseID(ovelseIds.get(i));
            ovelseList.add(ovelse);
        }
        //Sender deg videre med en liste over alle ovelsene.
        request.setAttribute("ovelseList", ovelseList);
        RequestDispatcher rq = request.getRequestDispatcher("../HentOvelse/index.jsp");
        rq.forward(request, response);

    }
}
