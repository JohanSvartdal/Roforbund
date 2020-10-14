package servlets;

import tools.repository.DatabaseReader;
import tools.repository.DatabaseValue;
import tools.repository.DatabaseWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name= "FullscreenMessage", urlPatterns = {"/SuperDash/FullscreenMessage/"})
public class OpprettKlubb extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gatenavn = request.getParameter("Gatenavn");
        String husnummerString = request.getParameter("Husnummer");
        int husnummer = Integer.parseInt(husnummerString);
        String postnummerString = request.getParameter("Postnummer");
        int postnummer = Integer.parseInt(postnummerString);
        String poststed = request.getParameter("Poststed");

        String adresseId = DatabaseWriter.createAdress(gatenavn, husnummer, postnummer, poststed);

        String klubbKolonner = "Navn, Adresse_id, Tlf";
        String tlfString = request.getParameter("Tlf");
        int tlf = Integer.parseInt(tlfString);

        DatabaseValue[] klubbVerdier = {new DatabaseValue(request.getParameter("Navn")), new DatabaseValue(adresseId), new DatabaseValue(tlf)};
        DatabaseWriter.addRowToTable("klubber", klubbKolonner, klubbVerdier);

        request.setAttribute("doneMessage", "Ferdig, klubb opprettet!");
        RequestDispatcher rq = request.getRequestDispatcher("../FullscreenMessage/index.jsp");
        rq.forward(request, response);

    }
}
