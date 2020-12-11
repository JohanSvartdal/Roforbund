package models.bruker;

public class Utover extends Bruker {
    private int klasseID;
    private String klasseNavn;

    public Utover(String fornavn, String etternavn, int tlf, int brukerID, String epost) {
        super(fornavn, etternavn, tlf, brukerID);
        super.setEpost(epost);
    }

    public Utover(String fornavn, String etternavn, Integer tlf) {
        super(fornavn,etternavn,tlf);
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
}
