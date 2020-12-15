package servlets.Sider.SuperServlets;

import servlets.AbstractAppServlet;
import tools.config.StaticValues;
import tools.databaseTools.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

// Servlet for å la superbruker legge til nye brukere. Finnes under
// /AdminKlubber/KlubbInstillinger/AdminBrukere/NyBruker

@WebServlet(name= "NyBruker", urlPatterns = {"/SuperDash/AdminKlubber/KlubbInnstillinger/AdminBrukere/NyBruker/"})
public class NyBruker extends AbstractAppServlet {
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }
    // Denne metoden
    //
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

        String brukerIDString = request.getParameter("brukerID");
        int brukerID = 0;
        if (brukerIDString != null) {
            brukerID = Integer.parseInt(brukerIDString);
        }

        System.out.println("Her er brukerid:" + brukerID + " " + brukerIDString);

        ResultSet brukerInfo = DatabaseReader.getResultSet("roforbund.bruker", "Bruker_id", brukerID);

        try {
            brukerInfo.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (DatabaseColumn column:DatabaseInfo.BRUKER_INFO) {
            System.out.println("Her er brukerid:" + brukerID + " " + brukerIDString);
            try {
                if (column.getColumnType() == DatabaseColumn.TYPE_STRING) {
                    request.setAttribute(column.getColumnName(), brukerInfo.getString(column.getColumnName()));
                }else if (column.getColumnType() == DatabaseColumn.TYPE_INT) {
                    request.setAttribute(column.getColumnName(), brukerInfo.getInt(column.getColumnName()));
                }else if (column.getColumnType() == DatabaseColumn.TYPE_FLOAT) {
                    request.setAttribute(column.getColumnName(), brukerInfo.getFloat(column.getColumnName()));
                }else if (column.getColumnType() == DatabaseColumn.TYPE_DATE) {
                    Date date = brukerInfo.getDate(column.getColumnName());
                    String dateString = date.getDate() + "." + (date.getMonth() + 1) + "." + date.getYear();
                    request.setAttribute(column.getColumnName(), dateString);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                request.setAttribute(column.getColumnName(), "");
            }
        }

        ResultSet adresseResult = DatabaseReader.getResultSet("roforbund.adresser", "Adresse_id", (String) request.getAttribute("Adresse_id"));
        try {
            adresseResult.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String gateNavn = "";
        try {
            gateNavn = adresseResult.getString("Gatenavn");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("Gatenavn", gateNavn);

        int husnummer = 0;
        try {
            husnummer = adresseResult.getInt("Husnummer");
            request.setAttribute("Husnummer", husnummer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            request.setAttribute("Husnummer", "");
        }

        int postnummer = 0;
        try {
            postnummer = adresseResult.getInt("Postnummer");
            request.setAttribute("Postnummer", postnummer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            request.setAttribute("Postnummer", "");
        }

        String postSted = DatabaseReader.getString("roforbund.postnummere", "Postnummer", postnummer, "Poststed");
        if (postSted == null) {
            postSted = "";
        }
        request.setAttribute("Poststed", postSted);


        System.out.println("Done with for loop");

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

        String brukerIDString = request.getParameter("brukerID");
        int brukerID = 0;
        if (brukerIDString != null) {
            try {
                brukerID = Integer.parseInt(brukerIDString);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }


        fieldCheck(request, response, wantedUserRole, klubbID, brukerID);
    }

    private void fieldCheck(HttpServletRequest request, HttpServletResponse response, int wantedUserRole, int klubbID, int brukerID) throws ServletException, IOException {
        String errorMessage = "";

        String fornavn = request.getParameter("fornavn");
        request.setAttribute("Fornavn", fornavn);
        String etternavn = request.getParameter("etternavn");
        request.setAttribute("Etternavn", etternavn);
        String fodselsdato = request.getParameter("fodselsdato");
        request.setAttribute("Fodseldato", fodselsdato);
        String tlf = request.getParameter("tlf");
        request.setAttribute("Tlf", tlf);
        String email = request.getParameter("email");
        request.setAttribute("Epost", email);
        String gatenavn = request.getParameter("gatenavn");
        request.setAttribute("Gatenavn", gatenavn);
        String husnummer = request.getParameter("husnummer");
        request.setAttribute("Husnummer", husnummer);
        String postnummer = request.getParameter("postnummer");
        request.setAttribute("Postnummer", postnummer);
        String poststed = request.getParameter("poststed");
        request.setAttribute("Poststed", poststed);
        String hoyde = request.getParameter("hoyde");
        request.setAttribute("Hoyde", hoyde);
        String vekt = request.getParameter("vekt");
        request.setAttribute("Vekt", vekt);

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

            if (brukerID != 0) {
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Fornavn", fornavnValue);
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Etternavn", etternavnValue);
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Fodseldato", fodselsdatoValue);
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Tlf", tlfValue);
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Epost", epostValue);
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Adresse_id", adresseIDValue);
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Vekt", vektValue);
                DatabaseWriter.changeCellValue("roforbund", "roforbund.bruker", "Bruker_id", brukerID, "Hoyde", hoydeValue);
            }else {
                DatabaseValue[] brukerValues = {fornavnValue, etternavnValue, fodselsdatoValue, tlfValue, epostValue, passwordValue, adresseIDValue, klubbIDValue, rolleValue, rankingValue, vektValue, hoydeValue};
                DatabaseWriter.addRowToTable("roforbund","bruker", DatabaseInfo.BRUKER_KOLONNER, brukerValues);
            }
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
