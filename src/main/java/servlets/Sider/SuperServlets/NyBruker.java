package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import servlets.Klubb;
import servlets.StaticValues;
import tools.repository.DatabaseInfo;
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
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name= "NyBruker", urlPatterns = {"/SuperDash/AdminKlubber/KlubbInnstillinger/AdminBrukere/NyBruker/"})
public class NyBruker extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wantedUserRoleString = request.getParameter("role");
        if (wantedUserRoleString == null) {
            wantedUserRoleString = (String) request.getAttribute("role");
        }else {
            request.setAttribute("role", wantedUserRoleString);
        }
        int wantedUserRole = Integer.parseInt(wantedUserRoleString);

        if (wantedUserRole == StaticValues.UTOVER) {
            request.setAttribute("rolestring", "utøver");
        }else if (wantedUserRole == StaticValues.TRENER) {
            request.setAttribute("rolestring", "trener");
        }

        String klubbIDString = request.getParameter("klubbID");
        int klubbID = 0;
        if (klubbIDString != null) {
            klubbID = Integer.parseInt(klubbIDString);
        }

        RequestDispatcher rq = request.getRequestDispatcher("../NyBruker/index.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        String wantedUserRoleString = request.getParameter("role");

        int wantedUserRole = Integer.parseInt(wantedUserRoleString);

        if (wantedUserRole == StaticValues.UTOVER) {
            request.setAttribute("rolestring", "utøver");
        }else if (wantedUserRole == StaticValues.TRENER) {
            request.setAttribute("rolestring", "trener");
        }


        String klubbIDString = request.getParameter("klubbID");
        int klubbID = 0;
        if (klubbIDString != null) {
            klubbID = Integer.parseInt(klubbIDString);
        }


        String errorMessage = "";

        String fornavn = request.getParameter("fornavn");
        String etternavn = request.getParameter("etternavn");
        String fodselsdato = request.getParameter("fodselsdato");
        String tlf = request.getParameter("tlf");
        String email = request.getParameter("email");
        String gatenavn = request.getParameter("gatenavn");
        String husnummer = request.getParameter("husnummer");
        String postnummer = request.getParameter("postnummer");
        String poststed = request.getParameter("poststed");
        String hoyde = request.getParameter("hoyde");
        String vekt = request.getParameter("vekt");

        String[] fieldsToCheck = {fornavn,etternavn,fodselsdato,tlf,email,gatenavn,husnummer,postnummer,poststed,hoyde,vekt};

        for (int i = 0; i < fieldsToCheck.length; i++) {
            fieldsToCheck[i] = fieldsToCheck[i].replaceAll("\\s+","");
            if (fieldsToCheck[i].isEmpty()) {
                errorMessage = "Vennligst fyll ut alle feltene";
            }else if (fieldsToCheck[i].length() > 150) {
                errorMessage = "Skjemaet er ikke riktig utfylt. Maks 150 tegn i hvert felt";
            }
        }

        String[] fodselsdatoDelt = fodselsdato.split("\\.");
        if (fodselsdatoDelt.length != 3) {
            errorMessage = "Fødselsdato har feil format. Eksempel på riktig format: '02.10.2000'";
        }else {
            if (integerHasWrongFormat(fodselsdatoDelt[0], 1, 2)) {
                errorMessage = "Fødselsdato har feil format. Eksempel på riktig format: '02.10.2000'";
            }else if (integerHasWrongFormat(fodselsdatoDelt[1], 1, 2)) {
                errorMessage = "Fødselsdato har feil format. Eksempel på riktig format: '02.10.2000'";
            }else if (integerHasWrongFormat(fodselsdatoDelt[2], 4, 4)) {
                errorMessage = "Fødselsdato har feil format. Eksempel på riktig format: '02.10.2000'";
            }
        }

        if (integerHasWrongFormat(tlf, 8, 8)) {
            errorMessage = "Telefonnummer har feil format. Eksempel på riktig format: '40640382'";
        }

        if (integerHasWrongFormat(husnummer, 1, 5)) {
            errorMessage = "Husnummer har feil format. Eksempel på riktig format: '28'";
        }

        if (integerHasWrongFormat(postnummer, 1, 4)) {
            errorMessage = "Postnummer har feil format. Eksempel på riktig format: '3046'";
        }

        if (integerHasWrongFormat(hoyde, 2, 3)) {
            errorMessage = "Høyde har feil format. Eksempel på riktig format: '180'";
        }

        if (floatHasWrongFormat(vekt, 2, 3)) {
            errorMessage = "Vekt har feil format. Eksempel på riktig format: '83.2'";
        }

        if (!errorMessage.isEmpty()) {
            System.out.println("Errormessage not empty");
            request.setAttribute("errormessage", errorMessage);
            RequestDispatcher rq = request.getRequestDispatcher("../NyBruker/index.jsp");
            rq.forward(request, response);
        }else {
            int husnummerInt = Integer.parseInt(husnummer);
            int postnummerInt = Integer.parseInt(postnummer);

            String adresseID = DatabaseWriter.createAdress(gatenavn, husnummerInt, postnummerInt, poststed);
            DatabaseValue fornavnValue = new DatabaseValue(fornavn);
            DatabaseValue etternavnValue = new DatabaseValue(etternavn);
            DatabaseValue tlfValue = new DatabaseValue(Integer.parseInt(tlf));
            DatabaseValue epostValue = new DatabaseValue(email);
            DatabaseValue passwordValue = new DatabaseValue("root");
            DatabaseValue adresseIDValue = new DatabaseValue(adresseID);
            DatabaseValue klubbIDValue = new DatabaseValue(klubbID);
            DatabaseValue rolleValue = new DatabaseValue(wantedUserRole);
            DatabaseValue rankingValue = new DatabaseValue(8);
            DatabaseValue vektValue = new DatabaseValue(Integer.parseInt(vekt));
            DatabaseValue hoydeValue = new DatabaseValue(Integer.parseInt(hoyde));

            java.util.Date javaDate = new java.util.Date();
            javaDate.setYear(Integer.parseInt(fodselsdatoDelt[0]));
            javaDate.setMonth(Integer.parseInt(fodselsdatoDelt[1])-1);
            javaDate.setYear(Integer.parseInt(fodselsdatoDelt[2]));
            Date date = new Date(javaDate.getTime());
            DatabaseValue fodselsdatoValue = new DatabaseValue(date);

            DatabaseValue[] brukerValues = {fornavnValue, etternavnValue, fodselsdatoValue, tlfValue, epostValue, passwordValue, adresseIDValue, klubbIDValue, rolleValue, rankingValue, vektValue, hoydeValue};

            DatabaseWriter.addRowToTable("bruker", DatabaseInfo.BRUKER_KOLONNER, brukerValues);
            response.sendRedirect("../../../");
        }
    }

    public boolean integerHasWrongFormat(String number, int minLength, int maxLength) {
        if (number.length() >= minLength && number.length() <= maxLength) {
            try {
                int createdInt = Integer.parseInt(number);
                return false;
            }catch (NumberFormatException e) {
                e.printStackTrace();
                return true;
            }
        }else {
            return true;
        }
    }

    public boolean floatHasWrongFormat(String number, int minLength, int maxLength) {
        if (number.length() >= minLength && number.length() <= maxLength) {
            try {
                float createdFloat = Float.parseFloat(number);
                return false;
            }catch (NumberFormatException e) {
                e.printStackTrace();
                return true;
            }
        }else {
            return true;
        }
    }
}
