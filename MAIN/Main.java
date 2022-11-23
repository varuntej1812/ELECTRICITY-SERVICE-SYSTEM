
import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Scanner;
import java.util.ArrayList;

import DATABASE.AdminDB;
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
    private static AdminDB admindb = new AdminDB();
    private static Admin admin = new Admin();
    private static Person person;
    private static Customer customer;

    public static void main(String[] args) throws SQLException {
        if (args.length > 0)
            executeCommandLineArguments(args);
        else {
            ;
        }
    }

    public static void executeCommandLineArguments(String[] args) throws SQLException {
        String function = commandArgs(args);
        if (function == null) {
            return;
        }
        switch (function) {
            case "register": {
                register(args[1]);
                break;
            }
            case "login": {
                login(args[1], args[2]);
                break;
            }
            case "logout": {
                logout(args[1]);
                break;
            }
            case "adminregister": {
                adminregister(args[1]);
                break;
            }
            case "menu": {
                printmenu();
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
                printallcustomers(args[1], args[2]);
                break;
            }

            case "getbillgt": {
                getbillgt(args[1]);
                break;
            }

            case "getbillst": {
                getbillst(args[1]);
                break;
            }

            case "knowbill": {
                knowbill(args[1]);
                break;
            }
            case "updatepersondetails": {
                updatepersondetails(args[1], args[2]);
                break;
            }

        }
    }

    public static String commandArgs(String[] args) {
        if (args.length == 0) {
            return null;
        } else if (args.length == 1) {
            if (args[0].toLowerCase().equals("menu"))
                return "menu";
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
                return "getbillgt";
            else if (args[0].toLowerCase().equals("getbillst"))
                return "getbillst";
            else if (args[0].toLowerCase().equals("knowbill"))
                return "knowbill";

        }

        else if (args.length == 3) {
            if (args[0].toLowerCase().equals("login"))
                return "login";
            else if (args[0].toLowerCase().equals("searchcustomer")) {
                return "searchcustomer";
            } else if (args[0].toLowerCase().equals("generatebill"))
                return "generatebill";
            else if (args[0].toLowerCase().equals("printallcustomers"))
                return "printallcustomers";
            else if (args[0].toLowerCase().equals("updatepersondetails"))
                return "updatepersondetails";
        }
        // // if (args[0].equalsIgnoreCase("addbuses"))
        // // return "addbuses";
        // } else if (args.length == 4) {
        // // if (args[0].equalsIgnoreCase("bookticket"))
        // // return "bookticket";
        // }

        return null;
    }

    public static void printallcustomers(String Mobile_Number, String password) throws SQLException {
        ArrayList<Customer> custlist = customerdb.GetAllCustomers();
        admin = admindb.searchAdmin(Mobile_Number);
        String Pass = admindb.getPersonPassword(Mobile_Number);
        if (Pass.equals(password)) {
            for (Customer customer : custlist) {
                customer.getDetails();
                System.out.printf("\n\n");
            }
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

    public static void updatepersondetails(String Mobile_Number, String csvPath) throws SQLException {
        Person person = persondb.getPerson(Mobile_Number);
        if (person.getLoginStatus().toLowerCase().equals("true")) {
            if (person.UpdatePerson(csvPath)) {
                person.printperson();
            } else {
                System.out.println("Person Not Updated");
            }
        }
    }

    public static void login(String mobileNumber, String password) throws SQLException {
        person = persondb.getPerson(mobileNumber);
        if (person == null)
            return;
        if (person.personLogin(mobileNumber, password))
            System.out.println("Login success");
        else
            System.out.println("Login failed");
    }

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

    public static void getbillst(String Amount) throws SQLException {
        ArrayList<Bill> billlist = customerdb.GetAllbillsst(Amount);
        if (billlist != null) {
            for (Bill b : billlist) {
                b.printbilldetails();
                System.out.printf("\n\n");
            }
        } else {
            System.out.println("No Bills with the given input");
        }

    }

    public static void knowbill(String BillId) throws SQLException {
        ArrayList<Bill> billlist = customerdb.getDueBillDetails(BillId);
        if (billlist.size() > 0) {
            System.out.println(".......Bill Details......");
            for (Bill b : billlist) {
                b.printbilldetails();
            }
        } else {
            System.out.println("No Due Bills");
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

    public static void printmenu() {
        System.out.println(
                "'menu'                                                -- prints all command line arguments you can use");
        System.out.println(
                "'login' [mobile number] [password]                    -- login using mobile number and password");
        System.out.println(
                "'register' [csvfilepath]                              -- customer registeration using csv file");
        System.out.println("'admin register' [csvfilepath]             -- admin registeration using csv file ");
        System.out.println("'logout' [mobile number]                                            -- person logout");
        System.out
                .println(
                        "'generatebill' [Mobile_Number] [House_No]     -- Generates and prints the bill of the customer");
        System.out.println("'paybill' [Bill Id]                        -- Pay bill using BillId");
        System.out.println("'getbillgt' [String Amount]                -- Get allbills greater than amount");
        System.out.println("'getbillst' [String Amount]                -- Get allbills smaller than amount");
        System.out.println("'searchperson' [Mobile_Number]             --Search via primary key of person table ");
        System.out.println("'deleteperson'[Mobile_Number]              --Delete person via primary key");
        System.out.println("'searchvianame'[name]                      --Multiple Records with name");
        System.out.println("'knowbill'[billid]                         --Print the bill if Not Paid");
        System.out.println(
                "'updatepersondetails'[Mobile_Number][csvpath]     --Updates Person details such as name,street,city");
        System.out.println(
                "'searchcustomer'[Mobile_Number][House_No]           --Searches Customer from customer table with UniqueNo");
        System.out.println(
                "'printallcustomers'[Mobile_Number][]        --Prints all the Customers only if you admin's login details");

    }
}
