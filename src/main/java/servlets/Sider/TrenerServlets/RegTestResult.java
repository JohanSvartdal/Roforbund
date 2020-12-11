package servlets.Sider.TrenerServlets;

import servlets.AbstractAppServlet;
import tools.database.DatabaseReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "RegTestResult", urlPatterns = {"/TrenerDash/HentOvelse/RegTestResult/"})
public class RegTestResult extends AbstractAppServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String people = (String) request.getParameter("brukereTilStede");
        String ovelser = (String) request.getParameter("ovelserValgt");

        String[] ovelsesIds = ovelser.split(",");
        String[] brukerIds = people.split(",");
        String[] brukerNavn = new String[brukerIds.length];

        for (int i = 0; i < brukerIds.length; i++) {
            String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", Integer.parseInt(brukerIds[i]), "Fornavn");
            String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", Integer.parseInt(brukerIds[i]), "Etternavn");
            brukerNavn[i] = fornavn + " " + etternavn;
        }


        String currentOvelseIndexString = request.getParameter("currentOvelseIndex");
        int currentOvelseIndex = 0;
        if (currentOvelseIndexString != null) {
            currentOvelseIndex = Integer.parseInt(currentOvelseIndexString);
        }

        String currentOvelsesNavn = DatabaseReader.getString("roforbund.ovelser", "Ovelse_id", ovelsesIds[currentOvelseIndex],"Navn");

        request.setAttribute("brukerIDs", brukerIds);
        request.setAttribute("brukerNavn", brukerNavn);
        request.setAttribute("currentOvelsesNavn", currentOvelsesNavn);
        request.setAttribute("currentOvelseIndex", currentOvelseIndex);
        request.getRequestDispatcher("../RegTestResult/index.jsp").forward(request, response);

    }
}
