package DATABASE;

import java.sql.*;
// import java.util.ArrayList;
import java.util.ArrayList;

import USER.CUSTOMER.Bill;
import USER.CUSTOMER.Customer;

public class CustomerDB extends PersonDB {

    public boolean InsertCustomerData(Customer C) throws SQLException {
        // String connectionType;
        // if (C.getTypeOfConnection() == 0) {
        // connectionType = "Normal";
        // } else {
        // connectionType = "Solar";
        // }
        String Query = "Insert INTO Customer values('" + C.getMobile_Number() + C.getHouse_No() + "','"
                + C.getTypeOfConnection() + "')";
        return !statement.execute(Query);
    }

    public boolean DeleteCustomerData(int UniqueNo) throws SQLException {
        String Query = "Delete from Customer where UniqueNo = " + UniqueNo;
        return !statement.execute(Query);
    }

    public Customer getCustomer(String Mobile_Number, String House_No) throws SQLException {
        String un = Mobile_Number + House_No;
        String Query = "Select * from person where Mobile_Number = '" + Mobile_Number + "'";
        String Query1 = "Select * from Customer where UniqueNo='" + un + "'";
        Customer customer = new Customer();
        ResultSet rs = statement.executeQuery(Query);
        if (rs.next()) {
            customer.setName(rs.getString("Name"));
            customer.setHouse_No(rs.getString("House_No"));
            customer.setStreet(rs.getString("Street"));
            customer.setCity(rs.getString("City"));
            customer.setLoginStatus(rs.getString("LoginStatus"));
            customer.setMobile_Number(rs.getString("Mobile_Number"));
            customer.setTypeOfUser("TypeOfUser");
            rs.close();
            rs = statement.executeQuery(Query1);
            if (rs.next()) {
                customer.setUniqueNo();
                customer.setTypeOfConnection(rs.getString("TypeOfConnection"));
                rs.close();

                return customer;
            }
        }

        return null;
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

    // public ArrayList<Bill> GetAllBills() throws SQLException{
    // String Query = "Select * from bill";
    // rs = statement.executeQuery(Query);
    // ArrayList<Bill> bill = new ArrayList<>();
    // while(rs.next()){
    // bill.add(new
    // Bill(rs.getInt("UniqueNo"),rs.getString("BillID"),rs.getDouble("Amount"),rs.getDatetime("DateTime"),rs.getString("BillPayStatus")));
    // }
    // }

    // public String GetUserPass(int UniqueID) throws SQLException {
    // String Query = "Select Password from Customer where UniqueNo = " + UniqueID;
    // ResultSet rs = statement.executeQuery(Query);
    // if (rs.next()) {
    // return rs.getString("Password");
    // } else {
    // return null;
    // }

    // }

    // public boolean updateUserLoginStatus(int UniqueID, Boolean status) throws
    // SQLException {
    // String Query = "update user set loginstatus =" + status + "where UniqueNo =
    // '" + UniqueID + "';";
    // return statement.execute(Query);
    // }

    // public Customer getCustomer(int UniqueNo) throws SQLException {
    // String Query = "Select * from Customer where UniqueNo = " + UniqueNo;
    // ResultSet rs = statement.executeQuery(Query);
    // Customer C = new Customer();
    // C.setName(rs.getString("Name"));
    // C.setHouse_No(rs.getString("House_No"));
    // C.setStreet(rs.getString("Street"));
    // C.setCity(rs.getString("City"));
    // C.setMobile_Number(rs.getString("MobileNumber"));
    // C.setUniqueNo(rs.getInt("UniqueNo"));
    // C.setTypeOfConnection(rs.getString("Connection Type"));
    // return C;
    // }

    // public Customer getCustomerDetails(String Mobile_Number) throws SQLException
    // {
    // String Query = "Select * from Customer where MobileNumber = " +
    // Mobile_Number;
    // ResultSet rs = statement.executeQuery(Query);
    // Customer C = new Customer();
    // C.setName(rs.getString("Name"));
    // C.setHouse_No(rs.getString("House_No"));
    // C.setStreet(rs.getString("Street"));
    // C.setCity(rs.getString("City"));
    // C.setMobile_Number(rs.getString("MobileNumber"));
    // C.setUniqueNo(rs.getInt("UniqueNo"));
    // C.setTypeOfConnection(rs.getInt("Connection Type"));
    // return C;
    // }

    // public Customer getCustomer(String mobile_Number) throws SQLException {
    // String Query = "Select * from Customer where MobileNumber =" + mobile_Number;
    // ResultSet rs = statement.executeQuery(Query);
    // if (rs.next()) {
    // Customer customer = new Customer();
    // customer.setName(rs.getString("Name"));
    // customer.setHouse_No(rs.getString("House_No"));
    // customer.setStreet(rs.getString("Street"));
    // customer.setCity(rs.getString("City"));
    // customer.setMobile_Number(rs.getString("MobileNumber"));
    // customer.setUniqueNo(rs.getInt("UniqueNo"));
    // customer.setTypeOfConnection(rs.getString("TypeOfConnection"));
    // return customer;
    // } else {
    // System.out.println("Record Not Found");
    // return null;
    // }

    // }

    public boolean InsertBillRecord(Bill B) throws SQLException {
        String Query = "Insert INTO Bill values('" + B.getUniqueNo() + "','" + B.getBillId() + "','" + B.getDatetime()
                + "','" + B.getAmount() + "','" + B.getBillpaystatus() + "')";
        return !statement.execute(Query);
    }

    public boolean UpadateBillPaymentStatus(Bill B) throws SQLException {
        String Query = "Update Bill set Billpaystatus= 'paid' where BillId = " + B.getBillId();
        return !statement.execute(Query);
    }

}
