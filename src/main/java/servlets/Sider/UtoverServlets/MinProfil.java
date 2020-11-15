package servlets.Sider.UtoverServlets;

import servlets.AbstractAppServlet;
import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name= "MinProfil", urlPatterns = {"/UtoverDash/MinProfil/"})

public class MinProfil extends AbstractAppServlet {
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

        Date fodseldato = DatabaseReader.getDate("roforbund.bruker", "Bruker_id", UID, "Fodseldato");
        String epost = DatabaseReader.getString("roforbund.bruker", "Bruker_id", UID, "Epost");
        Integer tlf = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", UID, "Tlf");

        String adresseID = DatabaseReader.getString("roforbund.bruker", "Bruker_id", UID, "Adresse_id");
        String gatenavn = DatabaseReader.getString("roforbund.adresser", "Adresse_id", adresseID, "Gatenavn");
        String husnummer = DatabaseReader.getString("roforbund.adresser", "Adresse_id", adresseID, "Husnummer");

        Integer postnummer = DatabaseReader.getInt("roforbund.adresser", "Adresser_id", adresseID, "Postnummer");
        String poststed = DatabaseReader.getString("roforbund.postnummer", "Postnummer", postnummer, "Poststed");


        Integer hoyde = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", UID, "Hoyde");
        Integer vekt = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", UID, "Fodseldato");
        Integer rolle = DatabaseReader.getInt("roforbund.bruker", "Bruker_id", UID, "Rolle");


        System.out.println(String.valueOf(fodseldato));
        request.setAttribute("fodseldato", fodseldato);
        request.setAttribute("epost", epost);
        request.setAttribute("tlf", tlf);
        request.setAttribute("gatenavn", gatenavn);
        request.setAttribute("husnummer", husnummer);
        request.setAttribute("poststed", poststed);
        request.setAttribute("hoyde", hoyde);
        request.setAttribute("vekt", vekt);
        request.setAttribute("rolle", rolle);




        RequestDispatcher rq = request.getRequestDispatcher("../MinProfil/index.jsp");
        rq.forward(request, response);
    }
}
