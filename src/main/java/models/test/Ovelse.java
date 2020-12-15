package models.test;

// Denne klassen lager et Ovelseobjekt med tilhørende atributter.
// Formål: Lar oss hente/definere atributter til en Ovelse. Brukes i OpprettTest

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
