package models.bruker;

public class Trener extends Bruker {

    public Trener(String fornavn, String etternavn, int tlf, String adresse, int brukerID) {
        super(fornavn, etternavn, tlf, brukerID);
        super.setAdresse(adresse);
    }
}
