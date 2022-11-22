// package MAIN;

// import java.net.Socket;
// import java.sql.SQLException;
import java.util.Scanner;

import USER.CUSTOMER.Customer;

// import USER.User;
// import USER.Customer.Customer;
// import USER.RECRUITER.Job;
// import USER.RECRUITER.Recruiter;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static Customer scanCustomerDetails() {
        Customer Customer = new Customer();
        System.out.print("Enter Name : ");
        Customer.setName(scanner.next());
        System.out.print("Enter MobileNumber : ");
        Customer.setMobile_Number(scanner.next());
        System.out.print("Enter House_No : ");
        Customer.setHouse_No(scanner.next());
        System.out.print("Enter Street : ");
        Customer.setStreet(scanner.next());
        System.out.print("Enter City : ");
        Customer.setCity(scanner.next());
        System.out.println("Enter TypeOfConnection : ");
        Customer.setTypeOfConnection(scanner.next());
        System.out.print("Enter Password : ");
        Customer.setPassword(scanner.next());
        Customer.setLoginStatus("true");
        return Customer;
    }

    // public static Recruiter scanRecruiterDetails(Recruiter recruiter) {
    // System.out.print("Enter First Name : ");
    // recruiter.setFirstName(scanner.next());
    // System.out.print("Enter Last Name : ");
    // recruiter.setLastName(scanner.next());
    // System.out.print("Enter Email : ");
    // recruiter.setEmail(scanner.next());
    // System.out.print("Enter Password : ");
    // recruiter.setPassword(scanner.next());
    // System.out.print("Enter Date Of Birth : ");
    // recruiter.setDateOfBirth(scanner.next());

    // return recruiter;
    // }

    public static String scanPassword() {
        System.out.print("Enter Password : ");
        String password = scanner.next();
        return password;
    }

    public static int scanChoice() {
        System.out.print("Enter Choice : ");
        int choice = scanner.nextInt();
        return choice;
    }

    public static String scanMobileNumber() {
        System.out.print("Enter MobileNumber : ");
        String mobile_number = scanner.next();
        return mobile_number;
    }

    // public static void applyjobs(Customer user) throws SQLException {
    // System.out.print("Enter job ID : ");
    // String ID = scanner.next();
    // boolean flag = false;
    // user.setEligibleJobs();
    // for (Job i : user.getEligibleJobs()) {
    // if (i.getId().equals(ID)) {
    // if (user.applyForJob(i) == true) {
    // System.out.println("****Application successful****");
    // } else {
    // System.out.println("****Application failed****");
    // }
    // flag = true;
    // break;
    // }
    // if (!flag) {
    // System.out.println("you aren't eligible for the job");
    // }
    // }
    // }

    // public static void modifyCustomer(Customer Customer) throws SQLException {
    // UserOutput.printUpdatesRequirement(Customer);
    // int choice = scanner.nextInt();
    // switch (choice) {
    // case 1: {
    // System.out.print("Enter new name : ");
    // String name = scanner.next();
    // Customer.setName(name);
    // break;
    // }
    // // case 2: {
    // // System.out.print("Enter new last name : ");
    // // String ln = scanner.next();
    // // Customer.setLastName(ln);
    // // break;
    // // }
    // case 2: {
    // System.out.print("Enter new mobileNumber : ");
    // String mobilenumber = scanner.next();
    // Customer.setMobile_Number(mobilenumber);
    // break;
    // }
    // case 3: {
    // System.out.print("Enter new House Number : ");
    // String H_No = scanner.next();
    // Customer.setHouse_No(H_No);
    // break;
    // }
    // case 4: {
    // System.out.print("Enter new Street : ");
    // String Street = scanner.next();
    // Customer.setHouse_No(Street);
    // break;
    // }
    // case 5: {
    // System.out.print("Enter new City : ");
    // String city = scanner.next();
    // Customer.setCity(city);
    // break;
    // }
    // case 6: {
    // System.out.print("Enter new password : ");
    // String password = scanner.next();
    // Customer.setPassword(password);
    // break;
    // }
    // case 7: {
    // System.out.print("Enter new Type of Connection : ");
    // String TypeofC = scanner.next();
    // Customer.setTypeOfConnection(TypeofC);
    // break;
    // }
    // case 8: {
    // Main.customermenu();
    // }
    // }
    // if (choice != 8) {
    // Customer.deleteUser();
    // Customer.Register();
    // System.out.println("Successfully updated");
    // }
    // Main.customermenu();
    // }

}