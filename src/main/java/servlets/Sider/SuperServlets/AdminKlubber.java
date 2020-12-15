package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import models.Klubb;
import tools.databaseTools.DatabaseReader;
import tools.databaseTools.DatabaseValue;
import tools.databaseTools.DatabaseWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//Servlet for å administrere klubber under /SuperServlets

@WebServlet(name= "AdminKlubber", urlPatterns = {"/SuperDash/AdminKlubber/"})
public class AdminKlubber extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }
    // Denne metoden
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String removeKlubbIDString = request.getParameter("fjernKlubb");

        if (removeKlubbIDString != null) {
            int removeKlubbID = Integer.parseInt(removeKlubbIDString);
            DatabaseWriter.changeCellValue("roforbund", "klubber", "Klubb_id", removeKlubbID, "Deaktivert", new DatabaseValue(true));
        }

        ArrayList<Integer> klubbIds = DatabaseReader.getAllEntries("roforbund.klubber", "Klubb_id");
        ArrayList<Klubb> klubbListe = new ArrayList<>();

        for (int i = 0; i < klubbIds.size(); i++) {
            String navn = DatabaseReader.getString("roforbund.klubber", "Klubb_id", klubbIds.get(i), "Navn");
            Klubb current = new Klubb(klubbIds.get(i), navn);

            String adresseID = DatabaseReader.getString("roforbund.klubber", "Klubb_id", klubbIds.get(i), "Adresse_id");
            Boolean deaktivert = DatabaseReader.getBoolean("roforbund.klubber", "Klubb_id", klubbIds.get(i), "Deaktivert");

            String gatenavn = DatabaseReader.getString("roforbund.adresser", "Adresse_id", adresseID, "Gatenavn");
            Integer husnummer = DatabaseReader.getInt("roforbund.adresser", "Adresse_id", adresseID, "Husnummer");
            Integer postnummer = DatabaseReader.getInt("roforbund.adresser", "Adresse_id", adresseID, "Postnummer");
            String poststed = DatabaseReader.getString("roforbund.postnummere", "Postnummer", postnummer, "Poststed");

            current.setAdresse(gatenavn + " " + husnummer + ", " + postnummer + " " + poststed);

            ArrayList<Integer> klubbMedlemIds = DatabaseReader.getListOfIds("roforbund.bruker", "Klubb_id", klubbIds.get(i), "Bruker_id");
            current.setAntallMedlemmer(klubbMedlemIds.size());


            Integer tlf = DatabaseReader.getInt("roforbund.klubber", "Klubb_id", klubbIds.get(i), "Tlf");
            current.setTlf(tlf);

            if (!deaktivert) {
                klubbListe.add(current);
            }
        }

        request.setAttribute("klubbListe", klubbListe);
        RequestDispatcher rq = request.getRequestDispatcher("../AdminKlubber/index.jsp");
        rq.forward(request, response);
    }
}
