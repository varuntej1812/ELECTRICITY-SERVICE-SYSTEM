package USER;

import java.sql.*;

public abstract class Person {
    private String Name;
    private String Mobile_Number;
    private String House_No;
    private String Street;
    private String City;
    private String TypeOfUser;
    private boolean LoginStatus;

    public Person() {

    }

    public Person(String name, String mobile_Number, String h_No, String street, String city) {
        Name = name;
        Mobile_Number = mobile_Number;
        House_No = h_No;
        Street = street;
        City = city;
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

    public boolean isLoginStatus() {
        return LoginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        LoginStatus = loginStatus;
    }

    

    public abstract boolean Login(String email, String password) throws SQLException;
    public abstract boolean Registration() throws SQLException;
    // public abstract boolean Logout();
    // public abstract boolean deleteUser() throws SQLException;

}
