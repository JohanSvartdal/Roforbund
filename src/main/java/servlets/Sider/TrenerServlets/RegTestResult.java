package servlets.Sider.TrenerServlets;

import servlets.AbstractAppServlet;
import servlets.Ovelse;
import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name= "RegTestResult", urlPatterns = {"/TrenerDash/RegTestResult/"})
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
        System.out.println("Det er her det viktigeskjer");
        //Runs when a test is about to start. Saves all parameters as attributes
        if (request.getAttribute("currentOvelseIndex") == null) {
            request.setAttribute("currentOvelseIndex", 0);

            request.setAttribute("ovelserValgt", request.getParameter("ovelserValgt"));
            request.setAttribute("brukereTilStede", request.getParameter("brukereTilStede"));
        }

        String people = (String) request.getAttribute("brukereTilStede");
        String ovelser = (String) request.getAttribute("ovelserValgt");

        String[] ovelsesNavn = ovelser.split(",");

        int currentOvelseIndex = (int) request.getAttribute("currentOvelseIndex");

        request.setAttribute("currentOvelsesNavn", ovelsesNavn[currentOvelseIndex]);
        request.setAttribute("currentOvelseIndex", currentOvelseIndex);
        request.getRequestDispatcher("../RegTestResult/index.jsp").forward(request, response);

    }
}
