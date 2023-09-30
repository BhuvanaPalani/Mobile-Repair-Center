import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://mysql-aurora-1-instance-1.clthmylawioj.eu-north-1.rds.amazonaws.com/mobile_store_2023";
    private static final String DB_USERNAME = "admin";
    private static final String DB_PASSWORD = "kbhn.1991";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    protected Connection conn;

    public boolean isConnected = false;

    public DatabaseManager() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            isConnected = (conn != null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}