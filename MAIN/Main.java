
import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Scanner;
import java.util.ArrayList;

// import DATABASE.AdminDB;
import DATABASE.CustomerDB;
import DATABASE.PersonDB;
import USER.Person;
import USER.ADMIN.Admin;
import USER.CUSTOMER.Bill;
// import USER.CUSTOMER.Bill;
// import USER.ADMIN.Admin;
import USER.CUSTOMER.Customer;

public class Main {
    private static PersonDB persondb = new PersonDB();
    private static CustomerDB customerdb = new CustomerDB();
    // private static AdminDB admindb = new AdminDB();
    private static Admin admin = new Admin();
    private static Person person;
    private static Customer customer;

    public static void main(String[] args) throws SQLException {
        if (args.length > 0)
            executeCommandLineArguments(args);
    }

    public static void executeCommandLineArguments(String[] args) throws SQLException {
        String function = commandArgs(args);
        if (function == null) {
            return;
        }
        switch (function) {
            case "login": {
                login(args[1], args[2]);
                break;
            }
            case "logout": {
                logout(args[1]);
                break;
            }
            case "register": {
                register(args[1]);
                break;
            }
            case "adminregister": {
                adminregister(args[1]);
                break;
            }
            case "help": {
                printHelp();
                break;
            }
            case "searchperson": {
                searchperson(args[1]);
                break;
            }
            case "searchcustomer": {
                searchcustomer(args[1], args[2]);
                break;
            }
            case "generatebill": {
                generatebill(args[1], args[2]);
                break;
            }
            case "paybill": {
                paybill(args[1]);
                break;
            }

            case "deleteperson": {
                deleteperson(args[1]);
                break;
            }

            case "searchvianame": {
                searchviaName(args[1]);
                break;
            }

            case "printallcustomers": {
                printallcustomers();
                break;
            }

            case "getbillgt": {
                getbillgt(args[1]);
            }

        }
    }

    public static String commandArgs(String[] args) {
        if (args.length == 0) {
            return null;
        } else if (args.length == 1) {
            if (args[0].toLowerCase().equals("help"))
                return "help";
            else if (args[0].toLowerCase().equals("printallcustomers"))
                return "printallcustomers";
        } else if (args.length == 2) {
            if (args[0].toLowerCase().equals("logout"))
                return "logout";
            else if (args[0].toLowerCase().equals("register"))
                return "register";
            else if (args[0].toLowerCase().equals("adminregister"))
                return "adminregister";
            else if (args[0].toLowerCase().equals("searchperson"))
                return "searchperson";
            else if (args[0].toLowerCase().equals("paybill"))
                return "paybill";
            else if (args[0].toLowerCase().equals("deleteperson"))
                return "deleteperson";
            else if (args[0].toLowerCase().equals("searchvianame"))
                return "searchvianame";
            else if (args[0].toLowerCase().equals("getbillgt"))
                ;
            return "getbillgt";
        }

        else if (args.length == 3) {
            if (args[0].toLowerCase().equals("login"))
                return "login";
            else if (args[0].toLowerCase().equals("searchcustomer")) {
                return "searchcustomer";
            } else if (args[0].toLowerCase().equals("generatebill"))
                return "generatebill";
        }
        // // if (args[0].equalsIgnoreCase("addbuses"))
        // // return "addbuses";
        // } else if (args.length == 4) {
        // // if (args[0].equalsIgnoreCase("bookticket"))
        // // return "bookticket";
        // }

        return null;
    }

    public static void printallcustomers() throws SQLException {
        ArrayList<Customer> custlist = customerdb.GetAllCustomers();
        for (Customer customer : custlist) {
            customer.getDetails();
            System.out.printf("\n\n");
        }
    }

    public static void register(String csvPath) throws SQLException {
        customer = new Customer();
        if (customer.personRegister(csvPath)) {
            System.out.println("Registration successfull!");
            customer.getDetails();
        } else
            System.out.println("Registration failed");
    }

    public static void adminregister(String csvPath) throws SQLException {
        admin = new Admin();
        if (admin.personRegister(csvPath)) {
            System.out.println("Registration successfull!");
            admin.getDetails();
        } else
            System.out.println("Registration failed");
    }

    // public static void UpdateCustomerDetails(String Mobile_Number, String
    // csvPath) throws SQLException {
    // Person person = persondb.getPerson(Mobile_Number);
    // String UId = Mobile_Number + person.getHouse_No();
    // Customer customer = customerdb.getCustomer(Mobile_Number, UId);
    // if()

    // }

    public static void login(String mobileNumber, String password) throws SQLException {
        person = persondb.getPerson(mobileNumber);
        if (person == null)
            return;
        if (person.personLogin(mobileNumber, password))
            System.out.println("Login success");
        else
            System.out.println("Login failed");
    }

    // public static void registerAdmin(String csvPath) throws SQLException {
    // admin = new Admin();
    // if (admin.personRegister(csvPath)) {
    // System.out.println("Registration successfull!");
    // } else
    // System.out.println("Registration failed");
    // }

    public static void logout(String mobileNumber) throws SQLException {
        person = persondb.getPerson(mobileNumber);
        if (person != null && person.personLogout(mobileNumber))
            System.out.println("You're logged out");
    }

    public static void searchperson(String MobileNumber) throws SQLException {
        Person person = persondb.getPerson(MobileNumber);
        if (person != null)
            person.printperson();
        else
            System.out.println("Person Not Found");
    }

    public static void searchcustomer(String MobileNumber, String House_No) throws SQLException {
        Customer customer = customerdb.getCustomer(MobileNumber, House_No);
        if (customer != null)
            customer.getDetails();
        else {
            System.out.println("Customer Not Found");
        }
    }

    public static void searchviaName(String Name) throws SQLException {
        ArrayList<Customer> custList = customerdb.getPersonwName(Name);
        for (Customer customer : custList) {
            customer.printperson();
            System.out.printf("\n\n");
        }
    }

    public static void generatebill(String Mobile_Number, String House_No) throws SQLException {
        Customer C = customerdb.getCustomer(Mobile_Number, House_No);
        if (C.getLoginStatus().toLowerCase().equals("true")) {
            C.CreateBill();
        } else {
            System.out.println("Please Login for the bill to be generated");
        }
    }

    public static void deleteperson(String Mobile_Number) throws SQLException {
        Person person = persondb.getPerson(Mobile_Number);
        String UniqueNo = person.getMobile_Number() + person.getHouse_No();
        if (persondb.deletepersonrecord(person)) {
            if (person.getTypeOfUser().toLowerCase().equals("customer") && customerdb.DeleteCustomerData(UniqueNo)) {
                System.out.println("Customer is Deleted");
            }

        } else {
            System.out.println("Deletion Failed");
        }
    }

    public static void getbillgt(String Amount) throws SQLException {
        ArrayList<Bill> billlist = customerdb.GetAllbillsgt(Amount);
        if (billlist != null) {
            for (Bill b : billlist) {
                b.printbilldetails();
                System.out.printf("\n\n");
            }
        } else {
            System.out.println("No Bills with the given input");
        }

    }

    public static void paybill(String BillId) throws SQLException {
        Bill bill = customerdb.getBillDetails(BillId);
        if (customerdb.UpdateBillPaymentStatus(bill)) {
            System.out.println("Bill has been Paid");
            bill.printbilldetails();
        } else {
            System.out.println("Payment not processed");
        }
    }

    public static void printHelp() {
        System.out.println(
                "'help'                                                -- prints all command line arguments you can use");
        System.out.println(
                "'login' [mobile number] [password]                    -- login using mobile number and password");
        System.out.println(
                "'register' [csvfilepath]                              -- customer registeration using csv file");
        System.out.println("'logout' [mobile number]                                            -- person logout");
        System.out
                .println(
                        "'generatebill' [Mobile_Number] [House_No]     -- Generates and prints the bill of the customer");
        System.out.println("''");
    }

    // class userInput {
    // private static Scanner scanner = new Scanner(System.in);

    // public static String scanPassword() {
    // System.out.print("Enter Password : ");
    // String Password = scanner.next();
    // return Password;
    // }
    // }

}
