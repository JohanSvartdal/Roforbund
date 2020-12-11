package tools.database;

public class DatabaseColumn {
    private String columnName;
    private int columnType;

    public DatabaseColumn(String columnName, int columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public static final int TYPE_INT = 2308;
    public static final int TYPE_STRING = 56654;
    public static final int TYPE_DATE = 59487;
    public static final int TYPE_FLOAT = 987;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }
}
