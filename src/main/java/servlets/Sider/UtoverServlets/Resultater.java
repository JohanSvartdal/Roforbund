package servlets.Sider.UtoverServlets;

import servlets.AbstractAppServlet;
import servlets.StaticValues;
import servlets.Test;
import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name= "Resultater", urlPatterns = {"/UtoverDash/Resultater/"})

public class Resultater extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie cklist[] = request.getCookies();
        int UID = -1;
        for (Cookie currentCookie:cklist) {
            if(currentCookie.getName().equals("UID")) {
                System.out.println(UID);
                UID = Integer.parseInt(currentCookie.getValue());
            }
        }

        if (UID == -1) {
            System.out.println("User not found");
        }

        ResultSet resultSet = DatabaseReader.getResultSet("roforbund.resultater", "Bruker_id", UID);
        ArrayList<Test> testListe = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Test test = new Test();
                test.setTest_id(resultSet.getInt("Test_id"));
                ResultSet testSet = DatabaseReader.getResultSet("roforbund.tester", "Test_id", test.getTest_id());
                testSet.next();
                test.setDato(testSet.getDate("Dato").toString());
                test.setKlubb_id(testSet.getInt("Klubb_id"));
                test.setAntallOvelser(testSet.getInt("Antall_ovelser"));
                test.setGodkjent(testSet.getInt("Godkjent"));
                test.setKommentar(testSet.getString("Kommentar"));
                if (test.getKommentar() == null) {
                    test.setKommentar("");
                }

                String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", UID, "Fornavn");
                String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", UID, "Etternavn");
                test.setTrenerNavn(fornavn + " " + etternavn);

                testListe.add(test);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("testliste", testListe);
        RequestDispatcher rq = request.getRequestDispatcher("../../UtoverDash/Resultater/index.jsp");
        rq.forward(request, response);
    }
}
