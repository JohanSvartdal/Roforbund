package servlets;

import tools.repository.DatabaseReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name= "Resultater")

public class Resultater extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       Cookie cookieList[] = request.getCookies();
       int UID = -1;
       for (Cookie currentCookie: cookieList){
           if(currentCookie.getName().equals("UID")){
               UID = Integer.parseInt(currentCookie.getValue());
           }
       }
        ArrayList<Integer> resultatIdList = DatabaseReader.getListOfIds("Roforbund.resultater", "Bruker_id", UID, "Resultat_id");
       for (int currentId: resultatIdList){
           Integer testId = DatabaseReader.getInt("Roforbund.resultater","Resultat_id", currentId, "Test_id");
           String dato =    DatabaseReader.getString("Roforbund.tester","Test_id", testId, "Dato");

       }





        //request.setAttribute("TestListe", TestListe);
        RequestDispatcher rq = request.getRequestDispatcher("../Utoverdash/index.jsp");
        rq.forward(request, response);
    }
}
