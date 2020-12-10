package servlets;

// Denne klassen lager utoverobjektet med de attributten som trengs
// for å skrive og lese av databasen.

public class Utover {
    private String fornavn;
    private String etternavn;
    private String adresse;
    private String epost;
    private int tlf;
    private int klasseID;
    private String klasseNavn;
    private int brukerID;

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String Etternavn) {
        this.etternavn = Etternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public int getKlasseID() {
        return klasseID;
    }

    public void setKlasseID(int klasseID) {
        this.klasseID = klasseID;
    }

    public String getKlasseNavn() {
        return klasseNavn;
    }

    public void setKlasseNavn(String klasseNavn) {
        this.klasseNavn = klasseNavn;
    }

    public int getBrukerID() {
        return brukerID;
    }

    public void setBrukerID(int brukerID) {
        this.brukerID = brukerID;
    }
}
