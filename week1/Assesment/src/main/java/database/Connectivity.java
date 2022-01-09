package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class Connectivity {

        private final Connection connection;

        public Connectivity() throws ClassNotFoundException,  SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");


            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/simple_banking_system",
                    "root",
                    "password"
            );// it loads the driver into memory
        }

        public Connection getConnection() {
            return connection;
        }
    }

