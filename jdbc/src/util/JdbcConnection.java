package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

    public final class JdbcConnection {

        private JdbcConnection() {
        }

        public static Connection getConnection() {
            Connection connection = null;
            try (FileInputStream db = new FileInputStream("jdbc/db.properties")) {
                Properties properties = new Properties();
                properties.load(db);
                String url = properties.getProperty("url");
                String user = properties.getProperty("jdbc.user");
                String password = properties.getProperty("password");
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException | IOException e) {
                System.err.println(e.getMessage());
            }
            return connection;
        }
    }


