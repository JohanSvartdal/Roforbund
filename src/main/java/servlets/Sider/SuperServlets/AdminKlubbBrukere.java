package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.config.StaticValues;
import models.bruker.Utover;
import tools.databaseTools.DatabaseReader;

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

@WebServlet(name= "AdminKlubbBrukere", urlPatterns = {"/SuperDash/AdminKlubber/KlubbInnstillinger/AdminBrukere/"})
public class AdminKlubbBrukere extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wantedUserRoleString = request.getParameter("role");
        int wantedUserRole = Integer.parseInt(wantedUserRoleString);

        if (wantedUserRole == StaticValues.UTOVER) {
            request.setAttribute("rolestring", "utøver");
        }else if (wantedUserRole == StaticValues.TRENER) {
            request.setAttribute("rolestring", "trener");
        }

        System.out.println("DO get");
        String klubbIDString = request.getParameter("klubbID");
        int klubbID = 0;
        if (klubbIDString != null) {
            klubbID = Integer.parseInt(klubbIDString);
        }

        System.out.println("KlubbidL: " + klubbID);

        ResultSet resultSet = DatabaseReader.getResultSet("roforbund.bruker", "Klubb_id", klubbID);
        ArrayList<Utover> utoverList = new ArrayList<>();

        try {
            System.out.println("Trying: ");
            while (resultSet.next()) {
                System.out.println("While: ");
                if (resultSet.getInt("Rolle") == wantedUserRole) {
                    Utover utover = new Utover(resultSet.getString("Fornavn"), resultSet.getString("Etternavn"), resultSet.getInt("Tlf"), resultSet.getInt("Bruker_id"),resultSet.getString("Epost"));
                    utover.setKlasseNavn("Junior");
                    utoverList.add(utover);
                }
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("utoverListe", utoverList);
        RequestDispatcher rq = request.getRequestDispatcher("../AdminBrukere/index.jsp");
        rq.forward(request, response);
    }
}
