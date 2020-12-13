package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import models.bruker.Trener;
import tools.databaseTools.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name= "LeggTilTrenere", urlPatterns = {"/SuperDash/LeggTilTrenere/"})
public class LeggTilTrenere extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> trenerIds = DatabaseReader.getListOfIds("roforbund.bruker", "Rolle", 2, "Bruker_id");
        ArrayList<Trener> trenerListe = new ArrayList<>();

        for (int i = 0; i < trenerIds.size(); i++) {
            String fornavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", trenerIds.get(i), "Fornavn");
            String etternavn = DatabaseReader.getString("roforbund.bruker", "Bruker_id", trenerIds.get(i), "Etternavn");

            String adresseID = DatabaseReader.getString("roforbund.bruker", "Bruker_id", trenerIds.get(i), "Adresse_id");
            String gatenavn = DatabaseReader.getString("roforbund.adresser", "Adresse_id", adresseID, "Gatenavn");
            Integer husnummer = DatabaseReader.getInt("roforbund.adresser", "Adresse_id", adresseID, "Husnummer");
            Integer postnummer = DatabaseReader.getInt("roforbund.adresser", "Adresse_id", adresseID, "Postnummer");
            String poststed = DatabaseReader.getString("roforbund.postnummere", "Postnummer", postnummer, "Poststed");

            String adresse = gatenavn + " " + husnummer + ", " + postnummer + " " + poststed;


            Integer tlf = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", trenerIds.get(i), "Tlf");

            Trener current = new Trener(fornavn, etternavn, tlf, adresse, trenerIds.get(i));

            trenerListe.add(current);
        }

        request.setAttribute("trenerListe", trenerListe);
        RequestDispatcher rq = request.getRequestDispatcher("../LeggTilTrenere/index.jsp");
        rq.forward(request, response);
    }
}
