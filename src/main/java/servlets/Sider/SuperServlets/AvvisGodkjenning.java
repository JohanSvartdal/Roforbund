package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.config.StaticValues;
import tools.database.DatabaseValue;
import tools.database.DatabaseWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "AvvisGodkjenning", urlPatterns = {"/SuperDash/Resultater/Resultat/AvvisGodkjenning/"})
public class AvvisGodkjenning extends AbstractAppServlet {

    int testID = 0;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String testIDString = request.getParameter("testID");
        testID = Integer.parseInt(testIDString);

        request.setAttribute("testID", testID);
        RequestDispatcher rq = request.getRequestDispatcher("../../../../SuperDash/Resultater/Resultat/AvvisGodkjenning/index.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

        String comment = request.getParameter("comment");
        if (comment != null && !comment.isEmpty()) {
            request.setAttribute("GodkjentStatus", "ikke godkjent");

            DatabaseWriter.changeCellValue("roforbund.tester", "Test_id", testID, "Kommentar", new DatabaseValue(comment));
            DatabaseWriter.changeCellValue("roforbund.tester", "Test_id", testID, "Godkjent", new DatabaseValue(StaticValues.RESULTAT_AVVIST));

            RequestDispatcher rq = request.getRequestDispatcher("../BekreftGodkjenning/index.jsp");
            rq.forward(request, response);
        }
    }
}
