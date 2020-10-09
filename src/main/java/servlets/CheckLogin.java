package servlets;

import tools.repository.DatabaseReader;
import tools.repository.UserManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name= "CheckLogin", urlPatterns = {"/login/CheckLogin"})
public class CheckLogin extends AbstractAppServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String email = request.getParameter("uname");
        String password = request.getParameter("password");

        String passwordFromDB = UserManagement.getUserPassword(email);

        if (password.equals(passwordFromDB)) {
            int userID = DatabaseReader.getInt("roforbund.bruker", "Epost", email, "Bruker_id");
            Cookie ck=new Cookie("UID",String.valueOf(userID));//deleting value of cookie
            ck.setMaxAge(2700000);//changing the maximum age to 0 seconds
            ck.setPath("/");
            response.addCookie(ck);

            System.out.println("Searhcing for: " + email);

            Integer userRole = DatabaseReader.getInt("roforbund.bruker", "Epost", email, "Rolle");
            String welcomeName = DatabaseReader.getString("roforbund.bruker", "Epost", email, "Fornavn");

            if (userRole == 1) {
                request.setAttribute("WelcomeMessage", "Velkommen " + welcomeName);
                request.getRequestDispatcher("../UtoverDash/index.jsp").forward(request, response);
            }else if (userRole == 2) {
                request.setAttribute("WelcomeMessage", "Velkommen " + welcomeName);
                request.getRequestDispatcher("../TrenerDash/index.jsp").forward(request, response);
            }else if (userRole == 3) {
                request.setAttribute("WelcomeMessage", "Velkommen " + welcomeName);
                request.getRequestDispatcher("../SuperDash/index.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void writeBody(HttpServletRequest request, PrintWriter out) {

    }
}
