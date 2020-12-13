package tools.databaseTools;

import java.sql.Date;

public class DatabaseValue {
    String text = null;
    Integer number = null;
    Date date = null;
    Boolean aBoolean = null;

    public DatabaseValue(int number) {
        this.number = number;
    }

    public DatabaseValue(String text) {
        this.text = text;
    }

    public DatabaseValue(Date date) {
        this.date = date;
    }

    public DatabaseValue(boolean bool) {
        this.aBoolean = bool;
    }
}
