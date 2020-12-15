package models.bruker;

// Denne klassen lager brukerobjektet med de attributten som trengs
// for å skrive og lese av databasen.
// Formål: Lar oss lage et brukerobjekt med tilhørende atributter som brukes i kommunikasjon med databasen

public abstract class Bruker {
    // definerer hvilke atributter en bruker kan ha
    private String fornavn;
    private String etternavn;
    private int tlf;
    private String adresse;
    private int brukerID;
    private String epost;

    public Bruker(String fornavn, String etternavn, int tlf, int brukerID) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.tlf = tlf;
        this.brukerID = brukerID;
    }

    public Bruker(String fornavn, String etternavn, Integer brukerID) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.brukerID = brukerID;
    }
    //Her er flere Set'ers og Get'ers for de ulike atributtene til brukeroppjektet
    //Formål: Set'ers definerer de ulike atributtene, Get'ers henter de fra objektet.
    public int getBrukerID() {
        return brukerID;
    }

    public void setBrukerID(int brukerID) {
        this.brukerID = brukerID;
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

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}
