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
        request.setAttribute("doneMessage", "Ferdig, klubb opprettet!");
        RequestDispatcher rq = request.getRequestDispatcher("../FullscreenMessage/index.jsp");
        rq.forward(request, response);
    }
}
