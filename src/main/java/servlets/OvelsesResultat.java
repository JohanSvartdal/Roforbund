package servlets;

import java.util.ArrayList;
//Constructor for OvelsesResultat, brukes hvor?

public class OvelsesResultat {
    private String ovelsesNavn;
    private int ovelsesID;
    private ArrayList<Resultat> resultater;

    public String getOvelsesNavn() {
        return ovelsesNavn;
    }

    public void setOvelsesNavn(String ovelsesNavn) {
        this.ovelsesNavn = ovelsesNavn;
    }

    public int getOvelsesID() {
        return ovelsesID;
    }

    public void setOvelsesID(int ovelsesID) {
        this.ovelsesID = ovelsesID;
    }

    public ArrayList<Resultat> getResultater() {
        return resultater;
    }

    public void setResultater(ArrayList<Resultat> resultater) {
        this.resultater = resultater;
    }

    public void addToResultater(Resultat resultat) {
        resultater.add(resultat);
    }
}
