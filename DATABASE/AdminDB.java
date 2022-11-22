package DATABASE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import USER.ADMIN.Admin;
import USER.CUSTOMER.Customer;

// import USER.CUSTOMER.Customer;

public class AdminDB extends PersonDB {

    // public boolean InsertAdminData(Admin A) throws SQLException {
    //     String Query = "Insert INTO Admin (Name,House_No,Street,City,MobileNumber,AdminId,Password) values('"
    //             + A.getName() + "','" + A.getHouse_No() + "','"
    //             + A.getStreet() + "','" + A.getCity() + "','" + A.getMobile_Number() + "','" + A.getAdminID() + "','"
    //             + A.getPassword() + "')";
    //     return statement.execute(Query);
    // }

    public Admin getAdminDetails(String AdminId) throws SQLException {
        String Query = "Select * from Admin where AdminId = " + AdminId;
        ResultSet rs = statement.executeQuery(Query);
        Admin A = new Admin();
        A.setName(rs.getString("Name"));
        A.setHouse_No(rs.getString("House_No"));
        A.setStreet(rs.getString("Street"));
        A.setCity(rs.getString("City"));
        A.setMobile_Number(rs.getString("MobileNumber"));
        // A.setAdminID(rs.getString("AdminId"));
        // A.setTypeOfConnection(rs.getInt("Connection Type"));
        return A;
    }

    // public Admin getAdminDetails(String MobileNumber) throws SQLException {
    // String Query = "Select * from Customer where MobileNumber = " + MobileNumber;
    // ResultSet rs = statement.executeQuery(Query);
    // Admin A = new Admin();
    // A.setName(rs.getString("Name"));
    // A.setHouse_No(rs.getString("House_No"));
    // A.setStreet(rs.getString("Street"));
    // A.setCity(rs.getString("City"));
    // A.setMobile_Number(rs.getString("MobileNumber"));
    // A.setAdminID(rs.getString("AdminId"));
    // // A.setTypeOfConnection(rs.getInt("Connection Type"));
    // return A;
    // }

    public Admin searchAdmin(int UniqueNo) throws SQLException {
        String Query = "Select * from Customer where UniqueNo =" + UniqueNo;
        ResultSet rs = statement.executeQuery(Query);
        Admin Admin = new Admin();

        Admin.setName(rs.getString("Name"));
        Admin.setHouse_No(rs.getString("House_No"));
        Admin.setStreet(rs.getString("Street"));
        Admin.setCity(rs.getString("City"));
        Admin.setMobile_Number(rs.getString("MobileNumber"));
        // Admin.setUniqueNo(rs.getInt("UniqueNo"));
        // Admin.setTypeOfConnection(rs.getInt("TypeOfConnection"));
        return Admin;
    }

    public ArrayList<Admin> GetAllAdmins() throws SQLException {
        String Query = "Select * from Admin";
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
        String Query = "select * from Customer'";
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
