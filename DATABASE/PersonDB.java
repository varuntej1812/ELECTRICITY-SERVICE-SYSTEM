package DATABASE;

import java.sql.*;

import USER.Person;
import USER.ADMIN.Admin;
import USER.CUSTOMER.Customer;

public class PersonDB {
    private Connection connection;
    private DataBase database;
    protected Statement statement;
    protected ResultSet rs;

    public PersonDB() {
        database = new DataBase();

        try {

            connection = DriverManager.getConnection(database.getDB_URL(), database.getUSER(),
                    database.getPASS());
            statement = connection.createStatement();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public boolean insertpersonrecord(Person person) throws SQLException {
        String Query = "insert into person values('" + person.getName() + "','" + person.getMobile_Number() + "','"
                + person.getHouse_No() + "','" + person.getStreet() + "','" + person.getCity() + "','"
                + person.getTypeOfUser() + "','" + person.getPassword() + "','" + person.getLoginStatus() + "')";
        return !statement.execute(Query);
    }

    public boolean updatedetails(Person P) throws SQLException {
        String Query = "Update person set Name = '" + P.getName() + "'," + "Street = '" + P.getStreet() + "',"
                + "City = '" + P.getCity() + "' " + "where Mobile_Number = '" + P.getMobile_Number() + "'";
        return !statement.execute(Query);
    }

    public boolean deletepersonrecord(Person person) throws SQLException {
        String Query = "delete from person where Mobile_Number= '" + person.getMobile_Number() + "'";
        return !statement.execute(Query);
    }

    public String getPersonPassword(String mobilenumber) throws SQLException {
        String Query = "select password from person where Mobile_Number = '" + mobilenumber + "'";
        rs = statement.executeQuery(Query);
        if (rs.next()) {
            return rs.getString("password");
        } else {
            return null;
        }
    }

    public String getPersonLoginStatus(String mobilenumber) throws SQLException {
        String Query = "select LoginStatus from person where mobilenumber = '" + mobilenumber + "'";
        rs = statement.executeQuery(Query);
        if (rs.next()) {
            String LoginStatus = rs.getString("LoginStatus");
            return LoginStatus;
        }
        return null;
    }

    public boolean updateUserLoginStatus(String mobileNumber, String status) throws SQLException {
        String Query = "update person set LoginStatus='" + status + "' where Mobile_number= '" + mobileNumber + "'";
        return !statement.execute(Query);
    }

    public Person getPerson(String Mobile_Number) throws SQLException {
        String Query = "select * from person where Mobile_Number = '" + Mobile_Number + "'";
        rs = statement.executeQuery(Query);
        Person person = null;
        if (rs.next()) {
            String TypeOfUser = rs.getString("TypeOfUser");
            if (TypeOfUser.toLowerCase().equals("customer")) {
                person = new Customer(rs.getString("Name"), rs.getString("Mobile_Number"), rs.getString("House_No"),
                        rs.getString("Street"), rs.getString("City"), rs.getString("TypeOfUser"),
                        rs.getString("Password"), rs.getString("LoginStatus"));
            } else if (TypeOfUser.toLowerCase().equals("admin")) {
                person = new Admin(rs.getString("Name"), rs.getString("Mobile_Number"), rs.getString("House_No"),
                        rs.getString("Street"), rs.getString("City"), rs.getString("TypeOfUser"),
                        rs.getString("Password"), rs.getString("LoginStatus"));
            }
        }

        return person;
    }

}
