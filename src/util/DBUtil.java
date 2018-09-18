package util;

import java.sql.*;

public class DBUtil {
    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/manishsingh/IdeaProjects/frs/db/sqlite/frs.db";
            Class.forName("org.sqlite.JDBC");
            // create a connection to the database
            connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
