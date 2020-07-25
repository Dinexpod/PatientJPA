package mate.academy.jpademo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/coolcompany?serverTimezone=UTC", "root", "root");
        } catch (ClassNotFoundException e) {
            System.out.println("Problems with JDBC DRIVERS");
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Problems with connection to  DATABASE");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
