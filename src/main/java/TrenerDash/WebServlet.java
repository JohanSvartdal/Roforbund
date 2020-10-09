import TrenerDash.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Trenerdash/index")
public class LoginRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TrenerDash() {
        // TODO kommentere
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Test HentTest = new Test();
        String brukerNavn = request.getParameter("brukernavn");
        System.out.println("brukerNavn = " + brukerNavn);
        String passord = request.getParameter("passord");
        System.out.println("passord = " + passord);
        String navn = request.getParameter("navn");
        String submitType = request.getParameter("submit");





        if (submitType.equals("Resultater")){

            request.getRequestDispatcher("velkommen.jsp").forward(request, response);

        } else if (submitType.equals("register")) {
            Bruker toBeInserted = new Bruker(brukerNavn,navn,passord);
            System.out.println("c.getNavn() = " + toBeInserted.getNavn());
            cd.insertBruker(toBeInserted);
            request.setAttribute("successMessage", "Registrering fullført, vennligst logg inn");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            request.setAttribute("message", "Ingen bruker funnet");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }