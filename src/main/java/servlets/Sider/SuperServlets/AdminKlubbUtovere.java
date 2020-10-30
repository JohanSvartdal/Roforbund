package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import servlets.Klubb;
import servlets.StaticValues;
import servlets.Utover;
import tools.repository.DatabaseReader;

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

@WebServlet(name= "AdminKlubbUtovere", urlPatterns = {"/SuperDash/AdminKlubber/KlubbInnstillinger/AdminUtovere/"})
public class AdminKlubbUtovere extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                if (resultSet.getInt("Rolle") == StaticValues.UTOVER) {
                    Utover utover = new Utover();
                    utover.setFornavn(resultSet.getString("Fornavn"));
                    utover.setEtternavn(resultSet.getString("Etternavn"));
                    utover.setEpost(resultSet.getString("Epost"));
                    utover.setTlf(resultSet.getInt("Tlf"));
                    utover.setKlasseNavn("Junior");
                    utoverList.add(utover);
                }
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("utoverListe", utoverList);
        RequestDispatcher rq = request.getRequestDispatcher("../AdminUtovere/index.jsp");
        rq.forward(request, response);
    }
}
