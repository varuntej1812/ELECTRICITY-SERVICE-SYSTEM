package USER.ADMIN;

import java.io.FileReader;
import java.sql.SQLException;
import com.opencsv.CSVReader;
import DATABASE.AdminDB;
import DATABASE.PersonDB;
import USER.Person;

public class Admin extends Person {
    private static AdminDB adminDB = new AdminDB();
    private static PersonDB persondb = new PersonDB();

    public Admin() {
    }

    public Admin(String name, String mobile_Number, String house_No, String street, String city, String typeOfUser,
            String password, String loginStatus) {
        super(name, mobile_Number, house_No, street, city, typeOfUser, password, loginStatus);
    }

    @Override
    public boolean personLogin(String Mobile_Number, String Password) throws SQLException {
        // Admin admin = adminDB.getAdminDetails(AdminId);
        String Pass = adminDB.getPersonPassword(Mobile_Number);
        // String Pass = admin.getPassword();
        if (Pass.equals(Password)) {

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

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csv));
            String Li[];
            Li = reader.readNext();
            if (Li == null)
                return false;
            this.setName(Li[0]);
            this.setMobile_Number(Li[1]);
            this.setHouse_No(Li[2]);
            this.setStreet(Li[3]);
            this.setCity(Li[4]);
            this.setTypeOfUser("admin");
            this.setPassword(Li[5]);
            this.setLoginStatus("true");
            return (persondb.insertpersonrecord(this));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void getDetails() {
        System.out.println("Name :" + getName());
        System.out.println("Mobile_Number : " + getMobile_Number());
        System.out.println("House Number: " + getHouse_No());
        System.out.println("Street : " + getStreet());
        System.out.println("City : " + getCity());
        System.out.println("Type of User: " + getTypeOfUser());
    }

}
