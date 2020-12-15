package models.bruker;

// Denne klassen lager utoverobjektet med de attributten som trengs
// for å skrive og lese av databasen.
// Formål: Lar oss lage et utoverobjekt med tilhørende atributter som brukes i kommunikasjon med databasen
// Bygger videre på brukerklassen med noen ekstra felter som kun gjelder utover

public class Utover extends Bruker {
    private int klasseID;
    private String klasseNavn;

    public Utover(String fornavn, String etternavn, int tlf, int brukerID, String epost) {
        super(fornavn, etternavn, tlf, brukerID);
        super.setEpost(epost);
    }

    public Utover(String fornavn, String etternavn, Integer brukerID) {
        super(fornavn,etternavn,brukerID);
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
