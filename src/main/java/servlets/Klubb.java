package servlets;

public class Klubb {
    private int klubbID;
    private String navn;
    private String adresse;
    private int tlf;
    private int antallMedlemmer;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
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

    public int getAntallMedlemmer() {
        return antallMedlemmer;
    }

    public void setAntallMedlemmer(int antallMedlemmer) {
        this.antallMedlemmer = antallMedlemmer;
    }

    public int getKlubbID() {
        return klubbID;
    }

    public void setKlubbID(int klubbID) {
        this.klubbID = klubbID;
    }
}
