package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.config.StaticValues;
import tools.databaseTools.DatabaseValue;
import tools.databaseTools.DatabaseWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Servlet for å avvise innsendte resultater fra trener
// Formål: Sikre korrekt testdata ved å sende resultater tilbake til trener.

@WebServlet(name= "AvvisGodkjenning", urlPatterns = {"/SuperDash/Resultater/Resultat/AvvisGodkjenning/"})
public class AvvisGodkjenning extends AbstractAppServlet {

    int testID = 0;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }
    //Denne metoden henter testID på test
    //Formål: Sikre at man avviser riktig test
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String testIDString = request.getParameter("testID");
        testID = Integer.parseInt(testIDString);

        request.setAttribute("testID", testID);
        RequestDispatcher rq = request.getRequestDispatcher("../../../../SuperDash/Resultater/Resultat/AvvisGodkjenning/index.jsp");
        rq.forward(request, response);
    }
    //Denne metoden setter status på test til ikke godkjent og tar superbruker tilbake til BekreftGodkjenning
    // dersom
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

        String comment = request.getParameter("comment");
        if (comment != null && !comment.isEmpty()) {
            request.setAttribute("GodkjentStatus", "ikke godkjent");

            DatabaseWriter.changeCellValue("roforbund", "roforbund.tester", "Test_id", testID, "Kommentar", new DatabaseValue(comment));
            DatabaseWriter.changeCellValue("roforbund","roforbund.tester", "Test_id", testID, "Godkjent", new DatabaseValue(StaticValues.RESULTAT_AVVIST));

            RequestDispatcher rq = request.getRequestDispatcher("../BekreftGodkjenning/index.jsp");
            rq.forward(request, response);
        }
    }
}
