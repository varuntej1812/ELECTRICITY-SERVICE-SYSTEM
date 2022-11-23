package USER;

import java.io.FileReader;
import java.sql.*;

import com.opencsv.CSVReader;

import DATABASE.PersonDB;

public abstract class Person {
    private String Name;
    private String Mobile_Number;
    private String House_No;
    private String Street;
    private String City;
    private String TypeOfUser;
    private String Password;
    private String LoginStatus;

    public Person() {

    }

    public Person(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String LoginStatus) {
        Name = name;
        Mobile_Number = mobile_Number;
        House_No = house_No;
        Street = street;
        City = city;
        TypeOfUser = typeOfUser;
        this.LoginStatus = LoginStatus;
    }

    public Person(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String password, String loginStatus) {
        Name = name;
        Mobile_Number = mobile_Number;
        House_No = house_No;
        Street = street;
        City = city;
        TypeOfUser = typeOfUser;
        Password = password;
        LoginStatus = loginStatus;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(String mobile_Number) {
        Mobile_Number = mobile_Number;
    }

    public String getHouse_No() {
        return House_No;
    }

    public void setHouse_No(String house_No) {
        House_No = house_No;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getTypeOfUser() {
        return TypeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        TypeOfUser = typeOfUser;
    }

    public String getLoginStatus() {
        return LoginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        LoginStatus = loginStatus;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean UpdatePerson(String csv) throws SQLException {
        PersonDB persondb = new PersonDB();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csv));
            String Li[];
            Li = reader.readNext();
            if (Li == null)
                return false;
            // while (Li != null) {
            this.setName(Li[0]);
            // this.setHouse_No(Li[1]);
            this.setStreet(Li[1]);
            this.setCity(Li[2]);
            // this.setMobile_Number(Li[4]);
            // this.setTypeOfUser("customer");
            // this.setLoginStatus("true");
            // this.setTypeOfConnection(Li[5]);
            // this.setPassword(Li[6]);
            return (persondb.updatedetails(this));
            // }
            // this.setUniqueNo(Stringeger.parseString(Li[7]));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        // return false;
    }

    public abstract boolean personLogin(String Mobile_Number, String password) throws SQLException;

    public abstract boolean personLogout(String Mobile_Number) throws SQLException;

    public abstract boolean personRegister(String csv) throws SQLException;

    // public abstract boolean deleteUser() throws SQLException;
    public void printperson() {
        System.out.println("Name : " + getName());
        System.out.println("Mobile_Number : " + getMobile_Number());
        System.out.println("House Number: " + getHouse_No());
        System.out.println("Street : " + getStreet());
        System.out.println("City : " + getCity());
        System.out.println("Type Of User : " + getTypeOfUser());
        System.out.println("Login Status : " + getLoginStatus());
    }

}
