package tools.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRunner {
    static String [] expectedOutput;
    static String [] methodOutput;

    public void runTests() {
        runTest1();
    }

    public void runTest1() {
        publishTest();
        getDBInput();
        compareArray("DatabaseAdder", expectedOutput, methodOutput);
        DatabaseWriter.removeLastRow("bruker", "Bruker_id");
    }


    private static void publishTest() {
        //Definer database verdier.
        DatabaseValue fornavn = new DatabaseValue("Karoline");
        DatabaseValue etternavn = new DatabaseValue("Nielsen");
        DatabaseValue fodselsdag = new DatabaseValue("1998-08-05");
        DatabaseValue epost = new DatabaseValue("karro.nielsen@gmail.com");
        DatabaseValue passord = new DatabaseValue("12345");
        DatabaseValue rolle = new DatabaseValue(1);

        //Legg til database verdier i databasen roforbund.
        DatabaseWriter.addRowToTable("bruker", "Fornavn, Etternavn, Fodseldato, Epost, Passord, Rolle", new DatabaseValue[]{fornavn, etternavn, fodselsdag, epost, passord, rolle});

        //Definer identifikator.
        expectedOutput = new String[]{etternavn.text, fodselsdag.text, epost.text};

    }

    private static void getDBInput() {
        //Hent siste resultat fra "bruker" table.
        //return: SQL statement.
        ResultSet resultat = DatabaseReader.getLastRecord("roforbund.bruker", "Bruker_id");

        methodOutput = new String[3];
        try {
            resultat.next();
            String hentetEnavn = resultat.getString("Etternavn");
            Date hentetFdato = resultat.getDate("Fodseldato");
            String hentetEpost = resultat.getString("Epost");

            methodOutput = new String [] {hentetEnavn, hentetFdato.toString(), hentetEpost};

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean compareArray(String testID,String[] expected, String[] actual) {
        if (expected.length == actual.length) {
            for (int i = 0; i < expected.length; i++) {
                if (!actual[i].equals(expected[i])) {
                    System.out.println("Test failed: " + testID + ", expected value was " + expected[i] + ", while the actual value was " + actual[i]);
                    return false;
                }
            }
            System.out.println("Test godkjent");
            return true;
        }else {
            System.out.println("Test failed: " + testID + ", expected length was " + String.valueOf(expected.length) + ", while the actual length was " + String.valueOf(actual.length));
            return false;
        }
    }
}
