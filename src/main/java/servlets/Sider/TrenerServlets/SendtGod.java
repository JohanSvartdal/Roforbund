package servlets.Sider.TrenerServlets;

import models.test.Resultat;
import servlets.AbstractAppServlet;
import tools.LocalStorage;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name= "SendtGod", urlPatterns = {"/TrenerDash/HentOvelse/SendtGod/"})
public class SendtGod extends AbstractAppServlet {

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
        super.doGet(request, response);

        String testIDString = request.getParameter("testID");
        int testID = Integer.parseInt(testIDString);


        DatabaseWriter.changeCellValue("roforbund", "tester", "Test_id", testID, "Godkjent", new DatabaseValue(StaticValues.RESULTAT_KLAR));

        RequestDispatcher rq = request.getRequestDispatcher("../SendtGod/index.jsp");
        rq.forward(request, response);
    }
}
