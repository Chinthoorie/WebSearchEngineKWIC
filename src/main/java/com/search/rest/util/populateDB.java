package com.search.rest.util;
import java.sql.*;

public class populateDB {
    public static String url ="";
    public static Connection conn = null;

    public static void connect(String fileName) {
        // SQLite connection string
        String path = System.getProperty("user.home") + "\\Desktop\\";
//        String path = "/Users/killer/Documents/";
        url = "jdbc:sqlite:"+path+"" + fileName;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewDatabase(String fileName) {
        connect(fileName);
        try  {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable(String fileName) {
        // SQLite connection string
        //String url = "jdbc:sqlite:C://sqlite/db/tests.db";

        // SQL statement for creating a new table
        connect(fileName);
        String sqlUrl = "CREATE TABLE IF NOT EXISTS urls (\n"
                + "    id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    url text NOT NULL\n"
                + ");";

        String sqlDesc = "CREATE TABLE IF NOT EXISTS descriptions (\n"
                + "    id integer,\n"
                + "    shifts text NOT NULL\n"
                + ");";

        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sqlUrl);
            stmt.execute(sqlDesc);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     */
    public void insert(String name, String fileName) {
        connect(fileName);
        String sql = "INSERT INTO urls(url) VALUES(?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAll(String fileName){
        connect(fileName);
        String sql = "SELECT id, url FROM urls";

        try (
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("url"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
