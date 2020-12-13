package servlets.Sider.TrenerServlets;

import models.test.Test;
import servlets.AbstractAppServlet;
import tools.LocalStorage;
import tools.config.StaticValues;
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

@WebServlet(name= "TrenerResultater", urlPatterns = {"/TrenerDash/Resultater/"})

public class TrenerResultater extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        int uid = LocalStorage.getUID(request, response);
        ResultSet tester = DatabaseReader.getResultSet("roforbund.tester", "Trener_id", uid);



        ArrayList<Test> testListe = new ArrayList<>();


        try {
            while (tester.next()) {
                Test test = new Test();
                test.setTest_id(tester.getInt("Test_id"));
                test.setDato(tester.getDate("Dato").toString());
                test.setKlubb_id(tester.getInt("Klubb_id"));
                test.setTrener_id(tester.getInt("Trener_id"));
                test.setAntallOvelser(tester.getInt("Antall_ovelser"));
                test.setGodkjent(tester.getInt("Godkjent"));
                test.setKommentar(tester.getString("Kommentar"));

                String klubbNavn = DatabaseReader.getString("roforbund.klubber", "Klubb_id", test.getKlubb_id(), "Navn");
                test.setKlubbNavn(klubbNavn);

                String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", test.getTrener_id(), "Fornavn");
                String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", test.getTrener_id(), "Etternavn");
                test.setTrenerNavn(fornavn + " " + etternavn);

                if(test.getKommentar() == null) {
                    test.setKommentar("");
                }

                if (test.getGodkjent() == StaticValues.RESULTAT_GODKJENT) {
                    test.setGodkjentTekst("Godkjent");
                }else if (test.getGodkjent() == StaticValues.RESULTAT_AVVIST) {
                    test.setGodkjentTekst("Avvist");
                }else if (test.getGodkjent() == StaticValues.RESULTAT_KLAR) {
                    test.setGodkjentTekst("Venter godkjenning");
                }else if (test.getGodkjent() == StaticValues.RESULTAT_UTKAST) {
                    test.setGodkjentTekst("Utkast");
                }
                testListe.add(test);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            tester.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("testliste", testListe);
        RequestDispatcher rq = request.getRequestDispatcher("../../TrenerDash/Resultater/index.jsp");
        rq.forward(request, response);
    }
}
