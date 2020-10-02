package servlets;

import tools.repository.DatabaseReader;
import tools.repository.OvelseManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name= "SokEtterOvelse", urlPatterns = {"/SokEtterOvelse"})
public class SokEtterOvelse extends AbstractAppServlet {

    int UID = 1;

    ArrayList<Ovelse> ovelsesList = new ArrayList<>();

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        writeResponse(request, response, "Legg til ovelser");
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
        ovelsesList = OvelseManagement.getAllOvelser();
        out.println("<html>");
        out.println("<head><title>Hvem er her?</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");


        out.println("<div id = 'loginBox'>");
        out.println("<h1>Søk etter øvelse</h1>");
        out.println("<form action = 'RegistrerResultater' method = 'POST'>");
        out.println("<input type = 'text' name = 'ovelsesName' class = 'textField' placeholder = 'Søk etter øvelse'/>");
        out.println("</form>");
        out.println("</br>");
        out.println("</br>");
        out.println("<button class = 'smallButton'>Gå videre</button>");

        out.println("</div>");


    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Alle get forespørsler til denne servleten blir håndert av doGEt.
     * får servleten en Get request vil den svare med doGet som kaller på metoden process Request.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String ovelsesListString = "Test";
        for (Ovelse ovelse: ovelsesList) {
            ovelsesListString = ovelsesListString + "," + ovelse.getOvelseNavn();
        }
        Cookie ck = new Cookie("allAOvelser", ovelsesListString);
        response.addCookie(ck);
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
