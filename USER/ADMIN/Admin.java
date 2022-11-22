package USER.ADMIN;

// import java.io.FileReader;
import java.sql.SQLException;
// import java.util.*;

// import com.opencsv.CSVReader;

import DATABASE.AdminDB;
import USER.Person;

public class Admin extends Person {

    // private String AdminID;

    private static AdminDB adminDB = new AdminDB();

    public Admin() {
        super.setTypeOfUser("Admin");
    }

    public Admin(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String password, String loginStatus) {
        super(name, mobile_Number, house_No, street, city, typeOfUser, password, loginStatus);
    }

    // public Admin(String adminID) {
    //     AdminID = adminID;
    // }

    public Admin(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String password, String loginStatus, String adminID) {
        super(name, mobile_Number, house_No, street, city, typeOfUser, password, loginStatus);
        // AdminID = adminID;
    }

    // private static DATABASE.AdminDB AdDB = new DATABASE.AdminDB();

    // public static Admin getAdminDB() {
    // return AdminDB;
    // }

    // public static void setAdminDB(Admin adminDB) {
    // AdminDB = adminDB;
    // }

    // public String getAdminID() {
    //     return AdminID;
    // }

    // public void setAdminID(String adminID) {
    //     AdminID = adminID;
    // }

    // public boolean Registration() throws SQLException {
    // try (Scanner sc = new Scanner(System.in)) {
    // String name, H_No, street, city;
    // // int typeofConn = 0;
    // String mobile_no;
    // String Password;
    // // int ID = getRandomNumber();
    // // int ID=100001;
    // System.out.println("Enter Your Name:\n");
    // name = sc.nextLine();
    // setName(name);
    // System.out.println("Enter Your Mobile Number:\n");
    // mobile_no = sc.nextLine();
    // setMobile_Number(mobile_no);
    // System.out.println("Enter Your House Number:\n");
    // H_No = sc.nextLine();
    // setHouse_No(H_No);
    // System.out.println("Enter Your Street Name:\n");
    // street = sc.nextLine();
    // setHouse_No(street);
    // System.out.println("Enter Your City:\n");
    // city = sc.nextLine();
    // setCity(city);

    // // boolean x = true;
    // boolean y = true;
    // // while (x) {
    // // System.out.printf(
    // // "Choose Your Type Of Connection:/nEnter 0 for NormalConnection/nEnter 1
    // for
    // // SolarConnection");
    // // typeofConn = sc.nextInt();
    // // if (typeofConn == 0 || typeofConn == 1) {
    // // x = false;
    // // if (typeofConn == 0) {
    // // System.out.println("You Choose Normal Connection\n");
    // // } else {
    // // System.out.println("You Choose Solar Connection\n");
    // // }
    // // } else {
    // // System.out.println("Please Enter the Correct Option\n");
    // // }
    // // }
    // // System.out.println("Your Unique RegisterId is: \n" + ID);
    // System.out.println("Set Your Password:\n");
    // Password = sc.nextLine();
    // String checkPass;
    // System.out.println("Confirm and Enter the Password Again:\n");
    // while (y) {
    // checkPass = sc.nextLine();
    // if (Password.equals(checkPass)) {
    // y = false;
    // } else {
    // System.out.println("Enter The Correct Password:");
    // }
    // }
    // // setUniqueNo(ID);
    // setPassword(Password);
    // // setTypeOfConnection(typeofConn);
    // System.out.println("You Are Now a Registered Admin");
    // // ID++;
    // }
    // return AdDB.InsertAdminData(this);
    // }

    // public Customer SearchCustomer(int UniqueNo) {

    // return null;
    // }

    @Override
    public boolean personLogin(String Mobile_Number, String Password) throws SQLException {
        // Admin admin = adminDB.getAdminDetails(AdminId);
        String Pass = adminDB.getPersonPassword(Mobile_Number);
        // String Pass = admin.getPassword();
        if (Pass.equals(Password)) {
            // return true;
            this.setLoginStatus("true");
            // adminDB.updateUserLoginStatus(getAdminID(), getLoginStatus());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean personLogout(String Mobile_Number) throws SQLException {
        this.setLoginStatus("false");
        return adminDB.updateUserLoginStatus(Mobile_Number, "false");
    }

    @Override
    public boolean personRegister(String csv) throws SQLException {
      
        return false;
    }

    // @Override
    // public boolean personRegister(String csv) throws SQLException {
        
    //     CSVReader reader = null;
    //     try {
    //         reader = new CSVReader(new FileReader(csv));
    //         String Li[];
    //         Li = reader.readNext();
    //         if (Li == null)
    //             return false;
    //         this.setName(Li[0]);
    //         this.setMobile_Number(Li[1]);
    //         this.setHouse_No(Li[2]);
    //         this.setStreet(Li[3]);
    //         this.setCity(Li[4]);
    //         this.setTypeOfUser(Li[5]);
    //         this.setPassword(Li[6]);
    //         // this.setAdminID(Li[7]);
    //         return (adminDB.InsertAdminData(this));
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return false;
    //     }
    // }

    // @Override
    // public boolean personRegister(String csv) throws SQLException{
    //     return false;
    // }

    // public boolean deleteUser() throws SQLException {
    // return(AdminDB.deleteUserRecord(this) &&
    // AdminDB.deleteAdministratorRecord(this));
    // }
}
