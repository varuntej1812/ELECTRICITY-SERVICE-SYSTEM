package DATABASE;

import java.sql.*;

import USER.CUSTOMER.Customer;

public class DataBase extends Customer {
    private String DB_URL = "jdbc:mysql://localhost:3306/vivekchaitanya";
    private String USER = "root";
    private String PASS = "Vivek@9352";
    protected Statement stmt;

    public DataBase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {

        } catch (SQLException e) {

        }
    }

}