package USER;

import java.sql.*;

public abstract class Person {
    private String Name;
    private String Mobile_Number;
    private String House_No;
    private String Street;
    private String City;
    private String TypeOfUser;
    private String Password;
    private String LoginStatus;

    @Override
    public String toString() {
        return "Person [Name=" + Name + ", MobileNumber=" + Mobile_Number + ", HouseNumber=" + House_No + ", Street="
                + Street
                + ", City=" + City + ", TypeOfUser=" + TypeOfUser + ",LoginStatus=" + LoginStatus + "]";

    }

    public Person() {

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

    public abstract boolean personLogin(String Mobile_Number, String password) throws SQLException;

    public abstract boolean personLogout(String Mobile_Number) throws SQLException;

    public abstract boolean personRegister(String csv) throws SQLException;
    // public abstract boolean Registration() throws SQLException;

    // public abstract boolean deleteUser() throws SQLException;

}
