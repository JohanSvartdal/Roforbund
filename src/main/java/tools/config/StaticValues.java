package tools.config;

// Denne klassen setter statiske verdier for å sende til riktig dashboard og for resultater
// som skal godkjennes
// Formål: Brukes av andre servlets for å gi riktig dashboard/resultat

public class StaticValues {
    public static final int RESULTAT_KLAR = 1;
    public static final int RESULTAT_UTKAST = 4;
    public static final int RESULTAT_GODKJENT = 2;
    public static final int RESULTAT_AVVIST = 3;

    public static final int UTOVER = 1;
    public static final int TRENER = 2;
    public static final int SUPERBRUKER = 3;

    public static final boolean TEST_MODE = false;
}
