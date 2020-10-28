package servlets;

import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name= "AdminKlubber", urlPatterns = {"/SuperDash/AdminKlubber/"})
public class AdminKlubber extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> klubbIds = DatabaseReader.getAllEntries("roforbund.klubber", "Klubb_id");
        ArrayList<Klubb> klubbListe = new ArrayList<>();



        for (int i = 0; i < klubbIds.size(); i++) {
            Klubb current = new Klubb();

            String navn = DatabaseReader.getString("roforbund.klubber", "Klubb_id", klubbIds.get(i), "Navn");
            current.setNavn(navn);

            String adresseID = DatabaseReader.getString("roforbund.klubber", "Klubb_id", klubbIds.get(i), "Adresse_id");
            String gatenavn = DatabaseReader.getString("roforbund.adresser", "Adresse_id", adresseID, "Gatenavn");
            Integer husnummer = DatabaseReader.getInt("roforbund.adresser", "Adresse_id", adresseID, "Husnummer");
            Integer postnummer = DatabaseReader.getInt("roforbund.adresser", "Adresse_id", adresseID, "Postnummer");
            String poststed = DatabaseReader.getString("roforbund.postnummere", "Postnummer", postnummer, "Poststed");

            current.setAdresse(gatenavn + " " + husnummer + ", " + postnummer + " " + poststed);


            ArrayList<Integer> klubbMedlemIds = DatabaseReader.getListOfIds("roforbund.bruker", "Klubb_id", klubbIds.get(i), "Bruker_id");
            current.setAntallMedlemmer(klubbMedlemIds.size());


            Integer tlf = DatabaseReader.getInt("roforbund.klubber", "Klubb_id", klubbIds.get(i), "Tlf");
            current.setTlf(tlf);

            klubbListe.add(current);
        }

        request.setAttribute("klubbListe", klubbListe);
        RequestDispatcher rq = request.getRequestDispatcher("../AdminKlubber/index.jsp");
        rq.forward(request, response);
    }
}
