package servlets;

// Constructor for Ovelse, brukes av ? for å sette/hente ting fra databasen

public class Ovelse {
    private int ovelseID;
    private String ovelseNavn;

    public int getOvelseID() {
        return ovelseID;
    }

    public String getOvelseNavn() {
        return ovelseNavn;
    }

    public void setOvelseID(int ovelseID) {
        this.ovelseID = ovelseID;
    }

    public void setOvelseNavn(String ovelseNavn) {
        this.ovelseNavn = ovelseNavn;
    }
}
