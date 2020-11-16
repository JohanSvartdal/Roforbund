package servlets;

public class Test {
    private Integer Test_id;

    private Integer Klubb_id;
    private String klubbNavn;

    private String kommentar;

    private String Dato;
    private Integer Trener_id;
    private String trenerNavn;
    private Integer Godkjent;
    private String TestListe;
    private Integer AntallOvelser;

public Integer getTest_id() {return Test_id;}

public void setTest_id(Integer test_id) {this.Test_id = test_id;}

public Integer getKlubb_id() {return Klubb_id;}

public void setKlubb_id(Integer klubb_id) {this.Klubb_id = klubb_id;}

public String getDato() {return  Dato;}

public void setDato(String dato) {this.Dato = dato;}

public Integer getTrener_id() {return Trener_id;}

public void setTrener_id(Integer trener_id) {this.Trener_id = trener_id;}

public Integer getGodkjent() {return Godkjent;}

public void setGodkjent(Integer godkjent) {this.Godkjent = godkjent;}

public String getTestListe() {return TestListe;}

public void setTestListe(String testListe) {this.TestListe = testListe;}

public Integer getAntallOvelser() {return AntallOvelser;}

public void setAntallOvelser(Integer antallTester) {this.AntallOvelser = antallTester;}

    public String getKlubbNavn() {
        return klubbNavn;
    }

    public void setKlubbNavn(String klubbNavn) {
        this.klubbNavn = klubbNavn;
    }

    public String getTrenerNavn() {
        return trenerNavn;
    }

    public void setTrenerNavn(String trenerNavn) {
        this.trenerNavn = trenerNavn;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
