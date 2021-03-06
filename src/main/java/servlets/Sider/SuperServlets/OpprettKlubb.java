package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
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

// Denne servleten lar superbruker opprette en ny klubb og sender denne til databasen
// Formål: Opprette nye roklubber i databasen

@WebServlet(name= "FullscreenMessage", urlPatterns = {"/SuperDash/FullscreenMessage/"})
public class OpprettKlubb extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }
    // Denne metoden Get'er klubbinformasjonen fra .JSP-en OpprettKlubb, og skriver dette til
    // databasen, så gir den brukeren en ferdigmelding og sender brukeren tilbake til index.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gatenavn = request.getParameter("Gatenavn");
        String husnummerString = request.getParameter("Husnummer");
        int husnummer = Integer.parseInt(husnummerString);
        String postnummerString = request.getParameter("Postnummer");
        int postnummer = Integer.parseInt(postnummerString);
        String poststed = request.getParameter("Poststed");

        String trenere = request.getParameter("TrenereToAdd");
        String[] trenerListe = trenere.split(",");

        String adresseId = DatabaseWriter.createAdress(gatenavn, husnummer, postnummer, poststed);

        String klubbKolonner = "Navn, Adresse_id, Tlf";
        String tlfString = request.getParameter("Tlf");
        int tlf = Integer.parseInt(tlfString);

        String klubbNavn = request.getParameter("Navn");

        DatabaseValue[] klubbVerdier = {new DatabaseValue(klubbNavn), new DatabaseValue(adresseId), new DatabaseValue(tlf)};
        DatabaseWriter.addRowToTable("roforbund", "klubber", klubbKolonner, klubbVerdier);

        int klubbId = DatabaseReader.getInt("roforbund.klubber","Navn", klubbNavn, "Klubb_id");

        for (int i = 0; i < trenerListe.length; i++) {
            //TODO lag en metode for å endre en celle i databasen
            DatabaseWriter.changeCellValue("roforbund", "bruker", "Bruker_id", trenerListe[i], "Klubb_id", new DatabaseValue(klubbId));
        }


        //Ferdigmelding
        request.setAttribute("doneMessage", "Ferdig, klubb opprettet!");
        RequestDispatcher rq = request.getRequestDispatcher("../FullscreenMessage/index.jsp");
        rq.forward(request, response);

    }
}
