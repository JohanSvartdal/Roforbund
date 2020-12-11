package tools.pools;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import tools.config.StaticValues;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        if (StaticValues.TEST_MODE) {
            config.setJdbcUrl("jdbc:mariadb://localhost:3308/");
        }else {
            config.setJdbcUrl("jdbc:mariadb://172.17.0.1:3308/");
        }
        config.setUsername("root");
        config.setPassword("12345");
        config.setMinimumIdle(2200);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private HikariCPDataSource(){}
}
