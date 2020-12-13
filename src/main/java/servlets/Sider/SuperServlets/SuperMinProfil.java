package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.databaseTools.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "SuperMinProfil", urlPatterns = {"/SuperDash/MinProfil/"})

public class SuperMinProfil extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
            request.setAttribute("backlink", "../SuperDash");

            RequestDispatcher rq = request.getRequestDispatcher("../Error/index.jsp");
            rq.forward(request, response);
            return;
        }

        String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", UID, "Fornavn");
        request.setAttribute("fornavn", fornavn);

        Integer tlf = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", UID, "Tlf");
        request.setAttribute("tlf", tlf);

        String epost = DatabaseReader.getString("roforbund.bruker", "Bruker_id", UID, "Epost");
        request.setAttribute("epost", epost);

        RequestDispatcher rq = request.getRequestDispatcher("../../SuperDash/MinProfil/index.jsp");
        rq.forward(request, response);
    }
}
