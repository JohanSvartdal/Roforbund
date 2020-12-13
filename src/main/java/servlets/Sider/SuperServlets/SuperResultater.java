package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.config.StaticValues;
import models.test.Test;
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

@WebServlet(name= "SuperResultater", urlPatterns = {"/SuperDash/Resultater/"})

public class SuperResultater extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String modeString = request.getParameter("mode");
        int mode = 2;

        if (modeString != null) {
            try {
                mode = Integer.parseInt(modeString);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }

        ResultSet resultSet = DatabaseReader.getResultSet("roforbund.tester");

        ArrayList<Test> testListe = new ArrayList<>();
        ArrayList<Test> tilGodkjenning = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Test test = new Test();
                test.setTest_id(resultSet.getInt("Test_id"));
                test.setDato(resultSet.getDate("Dato").toString());
                test.setKlubb_id(resultSet.getInt("Klubb_id"));
                test.setTrener_id(resultSet.getInt("Trener_id"));
                test.setAntallOvelser(resultSet.getInt("Antall_ovelser"));
                test.setGodkjent(resultSet.getInt("Godkjent"));

                String klubbNavn = DatabaseReader.getString("roforbund.klubber", "Klubb_id", test.getKlubb_id(), "Navn");
                test.setKlubbNavn(klubbNavn);

                String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", test.getTrener_id(), "Fornavn");
                String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", test.getTrener_id(), "Etternavn");
                test.setTrenerNavn(fornavn + " " + etternavn);

                if (test.getGodkjent() == mode) {
                    testListe.add(test);
                }else if (test.getGodkjent() == StaticValues.RESULTAT_KLAR && mode == 2) {
                    tilGodkjenning.add(test);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("antallklare", tilGodkjenning.size());
        request.setAttribute("testliste", testListe);
        RequestDispatcher rq = request.getRequestDispatcher("../../SuperDash/Resultater/index.jsp");
        rq.forward(request, response);
    }
}
