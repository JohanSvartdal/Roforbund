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

@WebServlet(name= "BekreftGodkjenning", urlPatterns = {"/SuperDash/Resultater/Resultat/BekreftGodkjenning/"})
public class BekreftGodkjenning extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String testIDString = request.getParameter("testID");
        int testID = Integer.parseInt(testIDString);
        String godkjenne = request.getParameter("godkjenne");

        if (godkjenne.equals("ja")) {
            DatabaseWriter.changeCellValue("roforbund", "roforbund.tester", "Test_id", testID, "Godkjent", new DatabaseValue(StaticValues.RESULTAT_GODKJENT));
            request.setAttribute("GodkjentStatus", "godkjent");
        }else if (godkjenne.equals("nei")) {
            DatabaseWriter.changeCellValue("roforbund", "roforbund.tester", "Test_id", testID, "Godkjent", new DatabaseValue(StaticValues.RESULTAT_AVVIST));
            request.setAttribute("GodkjentStatus", "ikke godkjent");
        }


        RequestDispatcher rq = request.getRequestDispatcher("../../../../SuperDash/Resultater/Resultat/BekreftGodkjenning/index.jsp");
        rq.forward(request, response);
    }
}
