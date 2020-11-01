package tools.repository;

import java.sql.Date;

public class DatabaseValue {
    String text = null;
    Integer number = null;
    Date date = null;

    public DatabaseValue(int number) {
        this.number = number;
    }

    public DatabaseValue(String text) {
        this.text = text;
    }

    public DatabaseValue(Date date) {
        this.date = date;
    }
}
