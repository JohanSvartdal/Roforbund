package servlets;

import models.UserModel;
import tools.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name= "UtoverDash", urlPatterns = {"/UtoverDash"})
public class UtoverDash extends AbstractAppServlet {

    int UID = 1;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        writeResponse(request, response, "Dashboard!");
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
        out.println("<html>");
        out.println("<head><title>Mine resultater</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");


        out.println("<div id = 'loginBox'>");
        out.println("<h1>Velg kategori</h1>");


        Cookie[] ck = req.getCookies();
        for(int i=0;i<ck.length;i++) {
            if (ck[i].getName().equals("UID")) {
                UID = Integer.parseInt(ck[i].getValue());
            }
        }

        String[] cats = UserRepository.getAllCats(UID, out);

        for (int i = 0; i < cats.length; i++) {
            out.println("<div id = 'loginButton'>" + cats[i] + "</div>");
        }

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
