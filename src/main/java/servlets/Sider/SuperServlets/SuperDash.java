package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name= "SuperDash", urlPatterns = "/SuperDash/")
public class SuperDash extends AbstractAppServlet {

    int UID = 1;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        writeResponse(request, response, "Dashboard!");
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Cookie cookies[] = request.getCookies();
        int UID = -1;
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("UID")) {
                String uidString = cookie.getValue();
                UID = Integer.parseInt(uidString);
            }
        }
        if (UID == -1) {
            request.setAttribute("title", "Fant ikke UID");
            request.setAttribute("description", "Vennligst kontakt IT avdelingen for hjelp");
            request.setAttribute("backlink", "../");

            RequestDispatcher rq = request.getRequestDispatcher("../Error/index.jsp");
            rq.forward(request, response);
            return;
        }

        String name = DatabaseReader.getString("roforbund.bruker","Bruker_id", UID, "Fornavn");

        request.setAttribute("WelcomeMessage", "Velkommen, " + name + "!");
        RequestDispatcher rq = request.getRequestDispatcher("../SuperDash/index.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
