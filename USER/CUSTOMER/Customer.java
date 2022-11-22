package USER.CUSTOMER;

import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import DATABASE.CustomerDB;
import USER.Person;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class Customer extends Person {
    private String UniqueNo;
    private String typeOfConnection;
    private ArrayList<Bill> BillList;
    private static CustomerDB CustDB = new CustomerDB();

    public Customer() {
        super.setTypeOfUser("Customer");
    }

    public Customer(String uniqueNo, String typeOfConnection) {
        UniqueNo = uniqueNo;
        this.typeOfConnection = typeOfConnection;
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
        double amount = bill.calculateBill(this);
        bill.setAmount(amount);
        bill.setBillpaystatus("due");
        if (CustDB.InsertBillRecord(bill)) {
            BillList.add(bill);
        } else {
            System.out.println("Bill Not Generated");
        }

    }

    // public boolean UpdateBillStatus(String BillId) {

    // }

    public boolean Register() throws SQLException {
        return CustDB.InsertCustomerData(this);
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

    public void getDetails() {
        System.out.println("Name :" + getName());
        System.out.println("Mobile_Number : " + getMobile_Number());
        System.out.println("House Number: " + getHouse_No());
        System.out.println("Street : " + getStreet());
        System.out.println("City : " + getCity());
        System.out.println("UniqueNo : " + getUniqueNo());
        System.out.println("TypeOfConnection : " + getTypeOfConnection());
    }

    // public void GetDetails() {
    //     System.out.println("UniqueNo :" + getUniqueNo());
    //     System.out.println("Type Of Connection :" + getTypeOfConnection());
    // }

    @Override
    public boolean personRegister(String csv) throws SQLException {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csv));
            String Li[];
            Li = reader.readNext();
            if (Li == null)
                return false;
            this.setName(Li[0]);
            this.setHouse_No(Li[1]);
            this.setStreet(Li[2]);
            this.setCity(Li[3]);
            this.setMobile_Number(Li[4]);
            this.setTypeOfUser("customer");
            this.setLoginStatus("true");
            this.setTypeOfConnection(Li[5]);
            this.setPassword(Li[6]);
            // this.setUniqueNo(Stringeger.parseString(Li[7]));

            return (CustDB.insertpersonrecord(this) && CustDB.InsertCustomerData(this));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    // public boolean Registration() throws SQLException {
    // try (Scanner sc = new Scanner(System.in)) {
    // String name, H_No, street, city;
    // String typeofConn = 0;
    // String mobile_no;
    // String Password;
    // // String ID = getRandomNumber();
    // // String ID=100001;
    // System.out.prStringln("Enter Your Name:\n");
    // name = sc.nextLine();
    // setName(name);
    // System.out.prStringln("Enter Your Mobile Number:\n");
    // mobile_no = sc.nextLine();
    // setMobile_Number(mobile_no);
    // System.out.prStringln("Enter Your House Number:\n");
    // H_No = sc.nextLine();
    // setHouse_No(H_No);
    // System.out.prStringln("Enter Your Street Name:\n");
    // street = sc.nextLine();
    // setHouse_No(street);
    // System.out.prStringln("Enter Your City:\n");
    // city = sc.nextLine();
    // setCity(city);

    // boolean x = true;
    // boolean y = true;
    // while (x) {
    // System.out.prStringf(
    // "Choose Your Type Of Connection:/nEnter 0 for NormalConnection/nEnter 1 for
    // SolarConnection");
    // typeofConn = sc.nextString();
    // if (typeofConn == 0 || typeofConn == 1) {
    // x = false;
    // if (typeofConn == 0) {
    // System.out.prStringln("You Choose Normal Connection\n");
    // } else {
    // System.out.prStringln("You Choose Solar Connection\n");
    // }
    // } else {
    // System.out.prStringln("Please Enter the Correct Option\n");
    // }
    // }
    // // System.out.prStringln("Your Unique RegisterId is: \n" + ID);
    // System.out.prStringln("Set Your Password:\n");
    // Password = sc.nextLine();
    // String checkPass;
    // System.out.prStringln("Confirm and Enter the Password Again:\n");
    // while (y) {
    // checkPass = sc.nextLine();
    // if (Password.equals(checkPass)) {
    // y = false;
    // } else {
    // System.out.prStringln("Enter The Correct Password:");
    // }
    // }
    // // setUniqueNo(ID);
    // setPassword(Password);
    // setTypeOfConnection(typeofConn);
    // System.out.prStringln("You Are Registered");
    // // ID++;
    // }
    // return CustDB.InsertCustomerData(this);
    // }

    // @Override
    // public boolean deleteUser() throws SQLException {
    // return(CustDB.deleteUserRecord(this) && CustDB.deleteRecruiterRecord(this));

    // }

    // public Customer(String name, String mobile_Number, String h_No, String
    // street, String city, String uniqueNo,
    // String typeOfConnection, String password) {
    // super(name, mobile_Number, h_No, street, city, password, password, password);
    // UniqueNo = uniqueNo;
    // this.typeOfConnection = typeOfConnection;
    // Password = password;
    // super.setTypeOfUser("Customer");
    // }

    // public Customer(String name, String mobile_Number, String h_No, String
    // street, String city) {
    // super(name, mobile_Number, h_No, street, city);
    // super.setTypeOfUser("Customer");
    // }

    // public Customer(String UniqueNo, String typeOfConnection, String Password) {
    // this.UniqueNo = UniqueNo;
    // this.typeOfConnection = typeOfConnection;
    // this.Password = Password;
    // super.setTypeOfUser("Customer");
    // }

}
