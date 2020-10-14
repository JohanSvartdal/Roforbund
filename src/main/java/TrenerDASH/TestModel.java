package TrenerDASH;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestModel {
    private Integer test_id;
    private Integer klubb_id;
    private String dato;
    private Integer bruker_id;
    private Integer godkjent;

    //constructor with all fields.
    public TestModel(Integer test_id, Integer klubb_id, String dato, Integer bruker_id, Integer godkjent) {
        this.test_id = test_id;
        this.klubb_id = klubb_id;
        this.dato = dato;
        this.bruker_id = bruker_id;
        this.godkjent = godkjent;
    }

    //constructor without id field.
    public TestModel(Integer klubb_id, String dato, Integer bruker_id, Integer godkjent) {
        this.klubb_id = klubb_id;
        this.dato = dato;
        this.bruker_id = bruker_id;
        this.godkjent = godkjent;
    }

    //default constructor.
    public TestModel() {
    }

    //getters for all fields.
    public Integer getTest_id() {
        return test_id;
    }

    public Integer getKlubb_id() {
        return klubb_id;
    }

    public String getDato() {
        return dato;
    }

    public Integer getTrener_id() {
        return bruker_id;
    }

    public Integer getGodkjent() {
        return godkjent;
    }

    //setters for all fields.
    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public void setKlubb_id(Integer klubb_id) {
        this.klubb_id = klubb_id;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setBruker_id(Integer bruker_id) {
        this.bruker_id = bruker_id;
    }

    public void setGodkjent(Integer godkjent) {
        this.godkjent = godkjent;
    }
}

