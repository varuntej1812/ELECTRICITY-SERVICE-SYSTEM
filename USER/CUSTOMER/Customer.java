package USER.CUSTOMER;

import java.sql.*;
import DATABASE.CustomerDB;
import USER.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {
    private int UniqueNo;
    private int typeOfConnection;
    private String Password;
    private ArrayList<Bill> BillList;
    private static CustomerDB CustDB = new CustomerDB();

    public Customer() {
        super.setTypeOfUser("Customer");
    }

    public Customer(String name, String mobile_Number, String h_No, String street, String city, int uniqueNo,
            int typeOfConnection, String password) {
        super(name, mobile_Number, h_No, street, city);
        UniqueNo = uniqueNo;
        this.typeOfConnection = typeOfConnection;
        Password = password;
        super.setTypeOfUser("Customer");
    }

    public Customer(String name, String mobile_Number, String h_No, String street, String city) {
        super(name, mobile_Number, h_No, street, city);
        super.setTypeOfUser("Customer");
    }

    public Customer(int UniqueNo, int typeOfConnection, String Password) {
        this.UniqueNo = UniqueNo;
        this.typeOfConnection = typeOfConnection;
        this.Password = Password;
        super.setTypeOfUser("Customer");
    }

    public int getUniqueNo() {
        return UniqueNo;
    }

    public void setUniqueNo(int uniqueNo) {
        UniqueNo = uniqueNo;
    }

    public int getTypeOfConnection() {
        return typeOfConnection;
    }

    public void setTypeOfConnection(int typeOfConnection) {
        this.typeOfConnection = typeOfConnection;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    // public static int getRandomNumber() {
    // int i = new Random().nextInt(899999) + 100000;
    // return i;
    // }

    public boolean Registration() throws SQLException {
        try (Scanner sc = new Scanner(System.in)) {
            String name, H_No, street, city;
            int typeofConn = 0;
            String mobile_no;
            String Password;
            // int ID = getRandomNumber();
            // int ID=100001;
            System.out.println("Enter Your Name:\n");
            name = sc.nextLine();
            setName(name);
            System.out.println("Enter Your Mobile Number:\n");
            mobile_no = sc.nextLine();
            setMobile_Number(mobile_no);
            System.out.println("Enter Your House Number:\n");
            H_No = sc.nextLine();
            setHouse_No(H_No);
            System.out.println("Enter Your Street Name:\n");
            street = sc.nextLine();
            setHouse_No(street);
            System.out.println("Enter Your City:\n");
            city = sc.nextLine();
            setCity(city);

            boolean x = true;
            boolean y = true;
            while (x) {
                System.out.printf(
                        "Choose Your Type Of Connection:/nEnter 0 for NormalConnection/nEnter 1 for SolarConnection");
                typeofConn = sc.nextInt();
                if (typeofConn == 0 || typeofConn == 1) {
                    x = false;
                    if (typeofConn == 0) {
                        System.out.println("You Choose Normal Connection\n");
                    } else {
                        System.out.println("You Choose Solar Connection\n");
                    }
                } else {
                    System.out.println("Please Enter the Correct Option\n");
                }
            }
            // System.out.println("Your Unique RegisterId is: \n" + ID);
            System.out.println("Set Your Password:\n");
            Password = sc.nextLine();
            String checkPass;
            System.out.println("Confirm and Enter the Password Again:\n");
            while (y) {
                checkPass = sc.nextLine();
                if (Password.equals(checkPass)) {
                    y = false;
                } else {
                    System.out.println("Enter The Correct Password:");
                }
            }
            // setUniqueNo(ID);
            setPassword(Password);
            setTypeOfConnection(typeofConn);
            System.out.println("You Are Registered");
            // ID++;
        }
        return CustDB.InsertCustomerData(this);
    }

    public boolean Logout() {
        // TODO Auto-generated method stub
        return false;
    }

    // @Override
    // public boolean deleteUser() throws SQLException {
    // return(CustDB.deleteUserRecord(this) && CustDB.deleteRecruiterRecord(this));

    // }

    public boolean Login(String Mobile_Number, String Password) throws SQLException {
        Customer customer = CustDB.getCustomer(Mobile_Number);
        String Pass = customer.getPassword();
        // Customer customerPass = CustDB.getCustomer(Password);
        if (Pass.equals(Password)) {
            this.setLoginStatus(true);
            CustDB.updateUserLoginStatus(getUniqueNo(), isLoginStatus());
            return true;
        } else {
            System.out.println("Login Failed");
            return false;
        }
    }
}
