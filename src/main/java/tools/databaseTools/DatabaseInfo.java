package tools.databaseTools;
// Klasse for å definere hvilke kolonner de ulike tabellene i databasen består av.
// Formål: Brukes av andre databasetools for å skrive/hente fra databasen
public class DatabaseInfo {
    public static final String BRUKER_KOLONNER =
            "Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde";

    public static final DatabaseColumn[] BRUKER_INFO =
            {
                    new DatabaseColumn("Fornavn", DatabaseColumn.TYPE_STRING),
                    new DatabaseColumn("Etternavn", DatabaseColumn.TYPE_STRING),
                    new DatabaseColumn("Fodseldato", DatabaseColumn.TYPE_DATE),
                    new DatabaseColumn("Tlf", DatabaseColumn.TYPE_INT),
                    new DatabaseColumn("Epost", DatabaseColumn.TYPE_STRING),
                    new DatabaseColumn("Passord", DatabaseColumn.TYPE_STRING),
                    new DatabaseColumn("Adresse_id", DatabaseColumn.TYPE_STRING),
                    new DatabaseColumn("Klubb_id", DatabaseColumn.TYPE_INT),
                    new DatabaseColumn("Rolle", DatabaseColumn.TYPE_INT),
                    new DatabaseColumn("Ranking", DatabaseColumn.TYPE_INT),
                    new DatabaseColumn("Vekt", DatabaseColumn.TYPE_INT),
                    new DatabaseColumn("Hoyde", DatabaseColumn.TYPE_INT)
            };

    public static final String POSTNUMMERE_KOLONNER =
            "Postnummer, Poststed";

    public static final String ADRESSER_KOLONNER =
            "Adresse_id, Gatenavn, Husnummer, Postnummer";

    public static final String TESTER_KOLONNER =
            "Klubb_id, Trener_id, Godkjent, Antall_ovelser, Kommentar";

    public static final String RESULTATER_KOLONNER =
            "Ovelse_id, Test_id, Bruker_id, Tid, Watt";
}
