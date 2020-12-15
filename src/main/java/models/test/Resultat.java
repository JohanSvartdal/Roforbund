package models.test;

// constructor for Resultatobjekt. Brukes til å definere/hente atributtene til resultatobjektet
// Formål: Brukes av OpprettTest eller Resultater servlet for å
// la oss lese eller skrive nye resultater.

public class Resultat {
    private int ovelsesID;
    private int resultatID;
    private int testID;
    private int brukerID;
    private String brukerNavn;
    private String notat;
    private int tid = -9000;
    private int watt = -9000;
    private int kg = -9000;
    private int repetisjoner = -9000;

    public Resultat() {

    }

    public int getOvelsesID() {
        return ovelsesID;
    }

    public void setOvelsesID(int ovelsesID) {
        this.ovelsesID = ovelsesID;
    }

    public int getResultatID() {
        return resultatID;
    }

    public void setResultatID(int resultatID) {
        this.resultatID = resultatID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public int getBrukerID() {
        return brukerID;
    }

    public void setBrukerID(int brukerID) {
        this.brukerID = brukerID;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getWatt() {
        return watt;
    }

    public void setWatt(int watt) {
        this.watt = watt;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getRepetisjoner() {
        return repetisjoner;
    }

    public void setRepetisjoner(int repetisjoner) {
        this.repetisjoner = repetisjoner;
    }

    public String getBrukerNavn() {
        return brukerNavn;
    }

    public void setBrukerNavn(String brukerNavn) {
        this.brukerNavn = brukerNavn;
    }

    public String getNotat() {
        return notat;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }
}
