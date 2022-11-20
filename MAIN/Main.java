package MAIN;

import java.sql.*;

import DATABASE.AdminDB;
import DATABASE.CustomerDB;
import USER.ADMIN.Admin;
import USER.CUSTOMER.Customer;

public class Main {

    private static AdminDB admindb = new AdminDB();
    private static CustomerDB customerdb = new CustomerDB();
    private static Customer customer;
    private static Admin admin;

    public static void main(String[] args) {
        if (args.length == 0) {
            PersonInterface();
        } else {
            PersonInterface(args);
        }
    }

    public static void CustomerInterface() throws SQLException{
        // UserOutput.printUserLoginMenu();
        // int choice = UserInput.scanChoice();
        // switch(choice){
        //     case 1 : {
        //        user= login();
        //        if(user==null)return;
        //        if(user.getUserType().toLowerCase().equals("jobseeker")){
        //        jobseeker = (JobSeeker) administratorDb.getUser(user.getEmail());
           
        //         jobSeekerMenu();
        //     }
        //         else if(user.getUserType().toLowerCase().equals("recruiter")){
        //             recruiter = (Recruiter) administratorDb.getUser(user.getEmail());
        //             recruiterMenu();
        //         }
        //        else if(user.getUserType().toLowerCase().equals("administrator")){
        //         administratorMenu();
        //     }
        //        break;
        //     }
        //     case 2 : {
        //        register();
        //     }
            
        //     case 0 : {
        //          return;
        //     }
        // }
    
}
}
