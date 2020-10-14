package tools.repository;

public class DatabaseValue {
    String text = null;
    Integer number = null;

    public DatabaseValue(int number) {
        this.number = number;
    }

    public DatabaseValue(String text) {
        this.text = text;
    }
}
