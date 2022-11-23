package DATABASE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import USER.ADMIN.Admin;
import USER.CUSTOMER.Customer;

// import USER.CUSTOMER.Customer;

public class AdminDB extends PersonDB {

    public Admin searchAdmin(String Mobile_Number) throws SQLException {
        String Query = "Select * from Person where Mobile_Number = '" + Mobile_Number + "'"
                + "and TypeOfUser = 'admin'";
        ResultSet rs = statement.executeQuery(Query);
        Admin Admin = new Admin();
        if (rs.next()) {
            Admin.setName(rs.getString("Name"));
            Admin.setHouse_No(rs.getString("House_No"));
            Admin.setStreet(rs.getString("Street"));
            Admin.setCity(rs.getString("City"));
            Admin.setMobile_Number(rs.getString("Mobile_Number"));
            Admin.setLoginStatus(rs.getString("LoginStatus"));
        }
        return Admin;

    }

    public ArrayList<Admin> GetAllAdmins() throws SQLException {
        String Query = "Select * from Person where TypeOfUser = 'admin'";
        ResultSet rs = statement.executeQuery(Query);
        ArrayList<Admin> ListAdmins = new ArrayList<Admin>();
        Admin Admin = new Admin();
        while (rs.next()) {
            Admin.setName(rs.getString("Name"));
            Admin.setMobile_Number(rs.getString("MobileNumber"));
            Admin.setHouse_No(rs.getString("House_No"));
            Admin.setStreet(rs.getString("Street"));
            Admin.setCity(rs.getString("City"));
            // Admin.setUniqueNo(rs.getInt("UniqueNo"));
            // Admin.setTypeOfConnection(rs.getInt("TypeOfConnection"));
            ListAdmins.add(Admin);
        }
        return ListAdmins;
    }

    public ArrayList<Customer> GetAllCustomers() throws SQLException {
        String Query = "select * from Customer";
        ResultSet rs = statement.executeQuery(Query);
        ArrayList<Customer> ListCustomers = new ArrayList<Customer>();
        Customer customer = new Customer();
        while (rs.next()) {
            // customer.setUniqueNo(rs.getString("UniqueNo"));
            customer.setName(rs.getString("Name"));
            customer.setMobile_Number(rs.getString("MobileNumber"));
            customer.setHouse_No(rs.getString("House_No"));
            customer.setUniqueNo();
            customer.setStreet(rs.getString("Street"));
            customer.setCity(rs.getString("City"));
        }
        return ListCustomers;
    }
}
