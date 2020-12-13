package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.databaseTools.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "KlubbInnstillinger", urlPatterns = {"/SuperDash/AdminKlubber/KlubbInnstillinger/"})
public class KlubbInnstillinger extends AbstractAppServlet {

    int testID = 0;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String klubbIDString = request.getParameter("klubbID");
        int klubbID = 0;
        try {
            klubbID = Integer.parseInt(klubbIDString);
        }catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String klubbNavn = DatabaseReader.getString("roforbund.klubber", "Klubb_id", klubbID, "Navn");

        request.setAttribute("KlubbNavn", klubbNavn);
        RequestDispatcher rq = request.getRequestDispatcher("../KlubbInnstillinger/index.jsp");
        rq.forward(request, response);
    }
}
