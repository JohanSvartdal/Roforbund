package tools;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocalStorage {

    public static int getUID(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookies[] = request.getCookies();
        int UID = -1;
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("UID")) {
                String uidString = cookie.getValue();
                UID = Integer.parseInt(uidString);
            }
        }
        if (UID == -1) {
            request.setAttribute("title", "Fant ikke UID");
            request.setAttribute("description", "Vennligst kontakt IT avdelingen for hjelp");
            request.setAttribute("backlink", "../");

            RequestDispatcher rq = request.getRequestDispatcher("../Error/index.jsp");
            try {
                rq.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return UID;
    }
}
