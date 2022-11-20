package MAIN;

import java.util.Scanner;
import USER.CUSTOMER.Customer;

public class UserOutput {
    private static Scanner scanner = new Scanner(System.in);

    public static Customer scanCustomerDetails() {
        Customer customer = new Customer();
        System.out.print("Enter your Name : ");
        customer.setName(scanner.next());
        System.out.print("Enter MobileNumber : ");
        customer.setMobile_Number(scanner.next());
        System.out.print("Enter House_No : ");
        customer.setHouse_No(scanner.next());
        System.out.print("Enter Street : ");
        customer.setStreet(scanner.next());
        System.out.print("Enter City : ");
        customer.setCity(scanner.next());
        System.out.println("Enter Password");
        customer.setPassword(scanner.next());
        // System.out.print("Enter TypeofConnection : ");
        // customer.setCity(scanner.next());
        // scanner.nextLine();
        // System.out.print("Enter gender : ");
        // customer.setGender(scanner.next());
        // System.out.print("Enter mobile number : ");
        // customer.setMobileNumber(scanner.next());
        // scanner.nextLine();
        // System.out.print("Enter qualification : ");
        // customer.setQualification(scanner.nextLine());
        // System.out.print("Enter college : ");
        // customer.setCollege(scanner.nextLine());
        // System.out.print("Enter percentage : ");
        // customer.setPercentage(scanner.nextDouble());
        // scanner.nextLine();
        // System.out.print("Enter skill1 : ");
        // customer.setSkill1(scanner.nextLine());
        // System.out.print("Enter skill2 : ");
        // customer.setSkill2(scanner.nextLine());
        // System.out.print("Enter skill3 : ");
        // customer.setSkill3(scanner.nextLine());
        // System.out.print("Enter experience : ");
        // customer.setExperience(scanner.nextInt());
        customer.setLoginStatus(true);
        return customer;
    }

    // public static Recruiter scanRecruiterDetails(Recruiter recruiter) {
    //     System.out.print("Enter First Name : ");
    //     recruiter.setFirstName(scanner.next());
    //     System.out.print("Enter Last Name : ");
    //     recruiter.setLastName(scanner.next());
    //     System.out.print("Enter Email : ");
    //     recruiter.setEmail(scanner.next());
    //     System.out.print("Enter Password : ");
    //     recruiter.setPassword(scanner.next());
    //     System.out.print("Enter Date Of Birth : ");
    //     recruiter.setDateOfBirth(scanner.next());

    //     return recruiter;
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

    // public static String scanEmail() {
    //     System.out.print("Enter Email : ");
    //     String email = scanner.next();
    //     return email;
    // }
}
