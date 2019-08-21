import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection connection = null;
    private static DataBaseConnection dataBaseConnection = null;

    private DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/school?verifyServerCertificate=false&useSSL=true", "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataBaseConnection getInstance() {
        if (connection == null) {
            synchronized (DataBaseConnection.class) {
                if (connection == null) {
                    return new DataBaseConnection();
                }
            }
        }
        return dataBaseConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
