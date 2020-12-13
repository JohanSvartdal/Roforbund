package tools.databaseTools;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

// Bruker test Database for å sjekke om koblingen til databasen er korrekt og kan brukes til å legge inn, hente ut og slette data.
// Bruker assertArrayEqals for å gjennomføre testen.
class DatabaseTest {
        String [] expectedOutput;   //data testen legger inn i databasen.
        String [] methodOutput;     //data getDBInput metoden henter ut av databasen.

    //Fullstendig test hvor data legges inn i databasen, og slettes fra databasen etter gjennomført test.
        @Test
        public void completeDBTest() {
            //Testraden legger inn i databasen.
            publishTest();
            getDBInput();

            //Sjekker om databasens input og output stemmer overens.
            assertArrayEquals(expectedOutput, methodOutput);

            //Testraden fjernes.
            removeTestRow();

        }
        @Test
        public void insertData() {
            //Testraden legger inn i databasen.
            publishTest();
            getDBInput();

            //Sjekker om databasens input og output stemmer overens.
            assertArrayEquals(expectedOutput, methodOutput);
        }

        //Fjerner testrad.
        public void removeTestRow() {
            DatabaseWriter.removeLastRow("test","bruker", "Bruker_id");
        }

        //Oppretter variabler og publiserer test i database.
        private void publishTest() {

            //Definer database verdier.
            DatabaseValue fornavn = new DatabaseValue("Karoline");
            DatabaseValue etternavn = new DatabaseValue("Nielsen");
            DatabaseValue fodselsdag = new DatabaseValue("1998-08-05");
            DatabaseValue epost = new DatabaseValue("karro.nielsen@gmail.com");
            DatabaseValue passord = new DatabaseValue("12345");
            DatabaseValue rolle = new DatabaseValue(1);

            //Legger til database verdier i databasen test.
            DatabaseWriter.addRowToTable("test","bruker", "Fornavn, Etternavn, Fodseldato, Epost, Passord, Rolle", new DatabaseValue[]{fornavn, etternavn, fodselsdag, epost, passord, rolle});

            //Definerer identifikator.
            expectedOutput = new String[]{etternavn.text, fodselsdag.text, epost.text};

        }

        ////Henter siste rad lagt inn i "bruker" table.
        private void getDBInput() {

            //return: SQL statement.
            ResultSet resultat = DatabaseReader.getLastRecord("test.bruker", "Bruker_id");

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

}