// package MAIN;

// import java.sql.*;

// import DATABASE.AdminDB;
// import DATABASE.CustomerDB;
// import USER.Person;
// import USER.ADMIN.Admin;
// import USER.CUSTOMER.Customer;

// public class Main {

//     private static AdminDB admindb = new AdminDB();
//     private static CustomerDB customerdb = new CustomerDB();
//     private static Person person;
//     private static Customer customer;
//     private static Admin admin;

//     public static void main(String[] args) throws SQLException {
//         // if (args.length == 0) {
//         //     PersonMenu();
//         // } else {
//         //     PersonMenu(args);
//         // }

//         if(args.length==0){
//         }
//         else{
//            executecommandlineargs();
//         }

//     }

//     public void executecommandlineargs(){

//     }

// public static void CustomerInterface() throws SQLException {
// }
// UserOutput.printUserLoginMenu();
// int choice = UserInput.scanChoice();
// switch(choice){
// case 1 : {
// person= login();
// if(person==null)return;
// if(person.getUserType().toLowerCase().equals("jobseeker")){
// jobseeker = (JobSeeker) administratorDb.getUser(person.getEmail());

// jobSeekerMenu();
// }
// else if(person.getUserType().toLowerCase().equals("recruiter")){
// recruiter = (Recruiter) administratorDb.getUser(person.getEmail());
// recruiterMenu();
// }
// else if(person.getUserType().toLowerCase().equals("administrator")){
// administratorMenu();
// }
// break;
// }
// case 2 : {
// register();
// }

// case 0 : {
// return;
// }
// }

// public static void PersonMenu() throws SQLException {
//     UserOutput.printPersonLoginMenu();
//     int choice = UserInput.inputChoice();
//     switch (choice) {
//         case 1: {
//             person = login();
//             if (person == null) {
//                 return;
//             }
//             if (person.getTypeOfUser().toLowerCase().equals("customer")) {
//                 customer = (customer) customerdb.getCustomer(person.getMobile_Number());
//                 customermenu();
//             }

//             else if (person.getTypeOfUser().toLowerCase().equals("admin")) {
//                 administratormenu();
//             }
//             break;
//         }

//         case 2: {
//             register();
//         }

//         case 0: {
//             return;
//         }

//     }
// }

// public static void customermenu() throws SQLException{
//     UserOutput.printCustomerMenu();
//     int choice = UserInput.inputChoice();
//     switch(choice){
//         case 1 : {
//             profileMenu();
//             break;
//         }
//         case 2 : {
//             Billhistory();
//             break;
//         }
//         case 3 :{
//             logout();
//             personmenu();
//             break;
//         }
//     }
// }

// public static void profileMenu() throws SQLException{
//     UserOutput.printProfileMenu();
//     int choice = UserInput.inputChoice();
//     switch(choice){
//         case 1 : {
//             viewUserProfile();
//             break;
//         }
//         case 2 : {
//             modifyUserProfile();
//             break;
//         }

//         case 3 : {
//             exitProfile();
//         }
//     }
// }

// public static void viewUserProfile(){
//     if(person.getTypeOfUser().equalsIgnoreCase("customer")){
//         customer.getDetails();
//     }
//     if(person.getTypeOfUser().equalsIgnoreCase("admin")){

//     }
// }

// public static void 

//}

import java.sql.SQLException;
import java.util.ArrayList;
// import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.Scanner;

// import DATABASE.AdminDB;
import DATABASE.CustomerDB;
import DATABASE.PersonDB;
import USER.Person;
import USER.ADMIN.Admin;
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
            case "help": {
                printHelp();
                break;
            }
            case "searchperson": {
                searchperson(args[1]);
            }
            case "searchcustomer": {
                searchcustomer(args[1], args[2]);
            }

            // case "generatebill": {
            // // generatebill();
            // break;
            // }
            // case "paybill": {
            // // paybill(args[1], args[2], args[3]);
            // break;
            // }
            // case "addbuses" : {
            // addBuses(args[1], args[2]);
            // break;
            // }
        }
    }

    public static void register(String csvPath) throws SQLException {
        customer = new Customer();
        if (customer.personRegister(csvPath)) {
            System.out.println("Registration successfull!");
        } else
            System.out.println("Registration failed");
    }

    public static void UpdateCustomerDetails(String Mobile_Number, String csvPath) throws SQLException {

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

    public static void registerAdmin(String csvPath) throws SQLException {
        admin = new Admin();
        if (admin.personRegister(csvPath)) {

            System.out.println("Registration successfull!");
        } else
            System.out.println("Registration failed");
    }

    public static void logout(String mobileNumber) throws SQLException {
        person = persondb.getPerson(mobileNumber);
        if (person != null && person.personLogout(mobileNumber))
            System.out.println("You're logged out");
    }

    public static void searchperson(String MobileNumber) throws SQLException {
        Person person = persondb.getPerson(MobileNumber);
        persondb.printperson(person);
    }

    // public static void

    public static void searchcustomer(String MobileNumber, String House_No) throws SQLException {
        Customer customer = customerdb.getCustomer(MobileNumber, House_No);
        if (customer != null)
            customer.getDetails();
    }
    // public static void AllCustomers(){
    // ArrayList<Customer> customers = CustomerDB.GetAllCustomers();
    // }

    public static String commandArgs(String[] args) {
        if (args.length == 0)
            return null;
        else if (args.length == 1) {
            if (args[0].toLowerCase().equals("help"))
                return "help";
            // else if (args[0].toLowerCase().equals("viewjobs"))
            // return "viewjobs";
            // else if (args[0].equalsIgnoreCase("searchbus"))
            // return "searchbus";
        } else if (args.length == 2) {
            // if (args[0].toLowerCase().equals("login"))
            // return "login";
            if (args[0].toLowerCase().equals("logout"))
                return "logout";
            else if (args[0].toLowerCase().equals("register"))
                return "register";
            else if (args[0].toLowerCase().equals("registeradmin"))
                return "registerAdmin";
            else if (args[0].toLowerCase().equals("searchperson"))
                return "searchperson";
        }

        else if (args.length == 3) {
            if (args[0].toLowerCase().equals("login"))
                return "login";
            else if (args[0].toLowerCase().equals("searchcustomer")) {
                return "searchcustomer";
            }
        }
        // // if (args[0].equalsIgnoreCase("addbuses"))
        // // return "addbuses";
        // } else if (args.length == 4) {
        // // if (args[0].equalsIgnoreCase("bookticket"))
        // // return "bookticket";
        // }

        return null;
    }

    public static void printHelp() {
        System.out.println(
                "'help'                                                -- prints all command line arguments you can use");
        System.out.println(
                "'login' [mobile number] [password]                    -- login using mobile number and password");
        System.out.println(
                "'register' [csvfilepath]                              -- customer registeration using csv file");
        System.out
                .println("'register' 'admin' [csvfilepath]                      -- admin registration using csv file");
        System.out.println("'logout' [mobile number]                              -- user logout");
        System.out.println(
                "'addbuses' [admin mobile number] [csvfilepath]        -- adds new bus routes or updates already present bus routes,this can be performed by only admin");
        System.out.println(
                "'searchbus'                                           -- prints all buses available with details");
        System.out.println(
                "'searchbus' [boarding point] [dropping point]         -- prints all avilable bus details passing through boarding point or dropping point");
        System.out.println(
                "'searchbus' [boarding point] [dropping point]  'lt' [price] -- prints required buses whose ticket price is less than passed price");
        System.out.println(
                "'searchbus' [boarding point] [dropping point]  'gt' [price] -- prints required buses whose ticket price is greater than passed price");
        System.out.println("'bookticket' [busid] [user mobile number] [journey date] -- bus ticket booking");
    }

    class userInput {
        private static Scanner scanner = new Scanner(System.in);

        public static String scanPassword() {
            System.out.print("Enter Password : ");
            String Password = scanner.next();
            return Password;
        }
    }

}
