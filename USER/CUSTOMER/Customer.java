package USER.CUSTOMER;

import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import DATABASE.CustomerDB;
// import DATABASE.PersonDB;
import USER.Person;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class Customer extends Person {
    private String UniqueNo;
    private String typeOfConnection;
    private ArrayList<Bill> BillList = new ArrayList<>();
    private static CustomerDB CustDB = new CustomerDB();

    public Customer() {
        super(null, null, null, null, null, null, null, null);
    }

    public Customer(String uniqueNo, String typeOfConnection) {
        UniqueNo = uniqueNo;
        this.typeOfConnection = typeOfConnection;
    }

    public Customer(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String LoginStatus) {
        super(name, mobile_Number, house_No, street, city, typeOfUser, LoginStatus);
    }

    public Customer(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String password, String loginStatus) {
        super(name, mobile_Number, house_No, street, city, typeOfUser, password, loginStatus);
    }

    public Customer(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String loginStatus, String uniqueNo, String password, String typeOfConnection) {
        super(name, mobile_Number, house_No, street, city, typeOfUser, password, loginStatus);
        UniqueNo = uniqueNo;
        this.typeOfConnection = typeOfConnection;
    }

    public ArrayList<Bill> getBillList() {
        return BillList;
    }

    public void setBillList(ArrayList<Bill> billList) {
        BillList = billList;
    }

    public String getUniqueNo() {
        return UniqueNo;
    }

    public void setUniqueNo() {
        UniqueNo = this.getMobile_Number() + this.getHouse_No();
    }

    public String getTypeOfConnection() {
        return typeOfConnection;
    }

    public void setTypeOfConnection(String typeOfConnection) {
        this.typeOfConnection = typeOfConnection;
    }

    public String toString() {
        return "Customer [Name=" + getName() + ", MobileNumber=" + getMobile_Number() + ", HouseNumber=" + getHouse_No()
                + ", Street="
                + getStreet()
                + ", City=" + getCity() + ", TypeOfUser=" + getTypeOfUser() + ",LoginStatus=" + getLoginStatus() + "]";

    }

    public void CreateBill() throws SQLException {
        Bill bill = new Bill();
        bill.setUniqueNo(this.UniqueNo);
        bill.GenerateBillID(UniqueNo, LocalDate.now());
        int amount = bill.calculateBill(this);
        bill.setAmount(amount);
        bill.setBillpaystatus("due");
        bill.setBillduedate(LocalDate.now());
        if (CustDB.InsertBillRecord(bill)) {
            BillList.add(bill);
            System.out.println("Generating Bill.....");
            bill.printbilldetails();
        } else {
            System.out.println("Bill Not Generated");
        }

    }

    @Override
    public boolean personLogin(String Mobile_Number, String Password) throws SQLException {
        String Pass = CustDB.getPersonPassword(Mobile_Number);
        if (Pass.equals(Password)) {
            this.setLoginStatus("true");
            CustDB.updateUserLoginStatus(getMobile_Number(), getLoginStatus());
            return true;
        } else {
            // System.out.prStringln("Login Failed");
            return false;
        }
    }

    @Override
    public boolean personLogout(String Mobile_Number) throws SQLException {
        this.setLoginStatus("false");
        return CustDB.updateUserLoginStatus(Mobile_Number, "false");
    }

    @Override
    public boolean personRegister(String csv) throws SQLException {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csv));
            String Li[];
            Li = reader.readNext();
            if (Li == null)
                return false;
            // while (Li != null) {
            this.setName(Li[0]);
            this.setHouse_No(Li[1]);
            this.setStreet(Li[2]);
            this.setCity(Li[3]);
            this.setMobile_Number(Li[4]);
            this.setTypeOfUser("customer");
            this.setLoginStatus("false");
            this.setTypeOfConnection(Li[5]);
            this.setPassword(Li[6]);
            return (CustDB.insertpersonrecord(this) && CustDB.InsertCustomerData(this));
            // }
            // this.setUniqueNo(Stringeger.parseString(Li[7]));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        // return false;
    }

    public void getDetails() {
        System.out.println("Name :" + getName());
        System.out.println("Mobile_Number : " + getMobile_Number());
        System.out.println("House Number: " + getHouse_No());
        System.out.println("Street : " + getStreet());
        System.out.println("City : " + getCity());
        System.out.println("UniqueNo : " + getMobile_Number() + getHouse_No());
        System.out.println("TypeOfConnection : " + getTypeOfConnection());
    }

}
