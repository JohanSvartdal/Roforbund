package models.bruker;

// Denne klassen lager trenerobjektet med de attributten som trengs
// for å skrive og lese av databasen.
// Formål: Lar oss lage et Trenerobjekt med tilhørende atributter som brukes i kommunikasjon med database
// Bygger videre på bruker da de fleste feltene er helt like.

public class Trener extends Bruker {

    public Trener(String fornavn, String etternavn, int tlf, String adresse, int brukerID) {
        super(fornavn, etternavn, tlf, brukerID);
        super.setAdresse(adresse);
    }
}
