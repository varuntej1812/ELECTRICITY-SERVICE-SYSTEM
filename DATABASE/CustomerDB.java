package DATABASE;

import java.sql.*;

import USER.CUSTOMER.Bill;
import USER.CUSTOMER.Customer;

public class CustomerDB extends DataBase {
    public boolean InsertCustomerData(Customer C) throws SQLException {
        String connectionType;
        if (C.getTypeOfConnection() == 0) {
            connectionType = "Normal";
        } else {
            connectionType = "Solar";
        }
        String Query = "Insert INTO Customer (Name,House_No,street,City,MobileNumber,ConnectionType,Password) values('"
                + C.getName() + "','" + C.getHouse_No() + "','"
                + C.getStreet() + "','" + C.getCity() + "','" + C.getMobile_Number() + "','" + connectionType
                + C.getPassword() + "')";
        return stmt.execute(Query);
    }

    public boolean updateUserLoginStatus(int UniqueID, Boolean status) throws SQLException {
        String Query = "update user set loginstatus =" + status;
        return stmt.execute(Query);
    }

    public String GetUserPass(int UniqueID) throws SQLException {
        String Query = "Select Password from Customer where UniqueNo = " + UniqueID;
        ResultSet rs = stmt.executeQuery(Query);
        return rs.getString("Password");
    }

    public boolean DeleteCustomerData(int UniqueNo) throws SQLException {
        String Query = "Delete from Customer where UniqueNo = " + UniqueNo;
        return stmt.execute(Query);
    }

    public Customer getCustomerDetails(int UniqueNo) throws SQLException {
        String Query = "Select * from Customer where UniqueNo = " + UniqueNo;
        ResultSet rs = stmt.executeQuery(Query);
        Customer C = new Customer();
        C.setName(rs.getString("Name"));
        C.setHouse_No(rs.getString("House_No"));
        C.setStreet(rs.getString("Street"));
        C.setCity(rs.getString("City"));
        C.setMobile_Number(rs.getString("MobileNumber"));
        C.setUniqueNo(rs.getInt("UniqueNo"));
        C.setTypeOfConnection(rs.getInt("Connection Type"));
        return C;
    }

    public Customer getCustomerDetails(String Mobile_Number) throws SQLException {
        String Query = "Select * from Customer where MobileNumber = " + Mobile_Number;
        ResultSet rs = stmt.executeQuery(Query);
        Customer C = new Customer();
        C.setName(rs.getString("Name"));
        C.setHouse_No(rs.getString("House_No"));
        C.setStreet(rs.getString("Street"));
        C.setCity(rs.getString("City"));
        C.setMobile_Number(rs.getString("MobileNumber"));
        C.setUniqueNo(rs.getInt("UniqueNo"));
        C.setTypeOfConnection(rs.getInt("Connection Type"));
        return C;
    }

    public Customer getCustomer(String mobile_Number) throws SQLException {
        String Query = "Select * from Customer where UniqueNo =" + mobile_Number;
        ResultSet rs = stmt.executeQuery(Query);
        if (!rs.isBeforeFirst()) {
            System.out.println("Enter Correct Number");
            return null;
        }
        Customer customer = new Customer();
        customer.setName(rs.getString("Name"));
        customer.setHouse_No(rs.getString("House_No"));
        customer.setStreet(rs.getString("Street"));
        customer.setCity(rs.getString("City"));
        customer.setMobile_Number(rs.getString("MobileNumber"));
        customer.setUniqueNo(rs.getInt("UniqueNo"));
        customer.setTypeOfConnection(rs.getInt("TypeOfConnection"));
        return customer;
    }

    public boolean InsertBillRecord(Bill B) throws SQLException {
        String Query = "Insert INTO Bill values('" + B.getUniqueNo())"
    }
}
