package USER.ADMIN;

import java.sql.SQLException;
import java.util.*;
import USER.Person;

public class Admin extends Person {

    private String AdminID;
    private String Password;

    private static DATABASE.AdminDB AdDB = new DATABASE.AdminDB();

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public static Admin getAdminDB() {
        return AdminDB;
    }

    public static void setAdminDB(Admin adminDB) {
        AdminDB = adminDB;
    }

    private static Admin AdminDB = new Admin();

    public Admin() {
        super.setTypeOfUser("Admin");
    }

    public Admin(String adminID, String Password) {
        AdminID = adminID;
        this.Password = Password;
        super.setTypeOfUser("Admin");
    }

    public Admin(String name, String mobile_Number, String h_No, String street, String city, String adminID,
            String Password) {
        super(name, mobile_Number, h_No, street, city);
        AdminID = adminID;
        this.Password = Password;
        super.setTypeOfUser("Admin");
    }

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public boolean Registration() throws SQLException {
        try (Scanner sc = new Scanner(System.in)) {
            String name, H_No, street, city;
            // int typeofConn = 0;
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

            // boolean x = true;
            boolean y = true;
            // while (x) {
            // System.out.printf(
            // "Choose Your Type Of Connection:/nEnter 0 for NormalConnection/nEnter 1 for
            // SolarConnection");
            // typeofConn = sc.nextInt();
            // if (typeofConn == 0 || typeofConn == 1) {
            // x = false;
            // if (typeofConn == 0) {
            // System.out.println("You Choose Normal Connection\n");
            // } else {
            // System.out.println("You Choose Solar Connection\n");
            // }
            // } else {
            // System.out.println("Please Enter the Correct Option\n");
            // }
            // }
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
            // setTypeOfConnection(typeofConn);
            System.out.println("You Are Now a Registered Admin");
            // ID++;
        }
        return AdDB.InsertAdminData(this);
    }

    // public Customer SearchCustomer(int UniqueNo) {

    // return null;
    // }

    public boolean Login(String AdminId, String Password) throws SQLException {
        Admin admin = AdDB.getAdminDetails(AdminId);
        String Pass = admin.getPassword();
        if (Pass.equals(Password)) {
            return true;
        } else {
            return false;
        }
    }
}
