package DATABASE;

import java.sql.*;
import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.ArrayList;

import USER.CUSTOMER.Bill;
import USER.CUSTOMER.Customer;

public class CustomerDB extends PersonDB {

    public boolean InsertCustomerData(Customer C) throws SQLException {
        String Query = "Insert INTO Customer values('" + C.getMobile_Number() + C.getHouse_No() + "','"
                + C.getTypeOfConnection() + "')";
        return !statement.execute(Query);
    }

    public boolean DeleteCustomerData(String UniqueNo) throws SQLException {
        String Query = "Delete from Customer where UniqueNo = '" + UniqueNo + "'";
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

    public ArrayList<Customer> getPersonwName(String Name) throws SQLException {
        String Query = "Select * from person where Name= '" + Name + "'";
        rs = statement.executeQuery(Query);
        ArrayList<Customer> custList = new ArrayList<>();
        Customer customer = null;
        while (rs.next()) {
            customer = new Customer(rs.getString("Name"), rs.getString("Mobile_Number"), rs.getString("House_No"),
                    rs.getString("Street"), rs.getString("City"), rs.getString("TypeOfUser"),
                    rs.getString("LoginStatus"));
            custList.add(customer);
        }
        return custList;
    }

    public Bill getBillDetails(String BillId) throws SQLException {
        String Query = "Select * from Bill where BillId = '" + BillId + "'";
        ResultSet rs = statement.executeQuery(Query);
        Bill bill = new Bill();
        if (rs.next()) {
            bill.setUniqueNo(rs.getString("UniqueNo"));
            bill.setBillId(rs.getString("BillId"));
            String date = rs.getString("Billdate");
            LocalDate D = LocalDate.parse(date);
            bill.setBilldate(D);
            bill.setAmount(rs.getInt("Amount"));
            String duedate = rs.getString("Billduedate");
            LocalDate dD = LocalDate.parse(duedate);
            bill.setBillduedate(dD);
            bill.setBillpaystatus(rs.getString("BillPayStatus"));
            return bill;
        }
        return null;
    }

    // public String gettypeofconnection(String ) throws SQLException{
    // String Query = "Select "
    // }

    public ArrayList<Customer> GetAllCustomers() throws SQLException {
        String Query = "select * from Person where TypeOfUser = 'customer'";
        ResultSet rs = statement.executeQuery(Query);
        ArrayList<Customer> ListCustomers = new ArrayList<Customer>();
        while (rs.next()) {
            Customer customer = new Customer();
            // customer.setUniqueNo(rs.getString("UniqueNo"));
            customer.setName(rs.getString("Name"));
            customer.setMobile_Number(rs.getString("Mobile_Number"));
            customer.setHouse_No(rs.getString("House_No"));
            customer.setUniqueNo();
            customer.setStreet(rs.getString("Street"));
            customer.setCity(rs.getString("City"));
            ListCustomers.add(customer);
        }
        rs.close();
        for (int i = 0; i < ListCustomers.size(); i++) {
            String Query1 = "select TypeOfConnection from Customer where UniqueNo = '"
                    + ListCustomers.get(i).getUniqueNo() + "'";
            ResultSet rs1 = statement.executeQuery(Query1);
            if (rs1.next()) {
                ListCustomers.get(i).setTypeOfConnection(rs1.getString("TypeOfConnection"));
            }
        }
        return ListCustomers;
    }

    public ArrayList<Bill> GetAllbillsgt(String Amount) throws SQLException {
        int amt = Integer.parseInt(Amount);
        String Query = "Select * from bill where Amount > '" + amt + "'";
        ResultSet rs = statement.executeQuery(Query);
        ArrayList<Bill> billlist = new ArrayList<>();
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setUniqueNo(rs.getString("UniqueNo"));
            bill.setBillId(rs.getString("BillId"));
            String date = rs.getString("Billdate");
            LocalDate D = LocalDate.parse(date);
            bill.setBilldate(D);
            bill.setAmount(rs.getInt("Amount"));
            String date1 = rs.getString("Billduedate");
            LocalDate D1 = LocalDate.parse(date1);
            bill.setBillduedate(D1);
            bill.setBillpaystatus(rs.getString("BillPayStatus"));
            billlist.add(bill);
        }

        return billlist;
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

    public boolean InsertBillRecord(Bill B) throws SQLException {
        String Query = "Insert INTO Bill values('" + B.getUniqueNo() + "','" + B.getBillId() + "','" + B.getBilldate()
                + "','" + B.getAmount() + "','" + B.getBillduedate() + "','" + B.getBillpaystatus() + "')";
        return !statement.execute(Query);
    }

    public boolean UpdateBillPaymentStatus(Bill B) throws SQLException {
        String Query = "Update Bill set Billpaystatus= 'paid' where BillId = '" + B.getBillId() + "'";
        return !statement.execute(Query);
    }

    // public boolean UpdateCustomerName(String Mobile_Number) {

    // // String Query = "Update Bill set Name = '" +
    // }

}
