// package MAIN;

// import java.util.Scanner;
import USER.CUSTOMER.Customer;

public class UserOutput {
    public static void printHelp() {
        System.out.println(
                "***********************************************************************************************************************");
        System.out.println(
                "There can be multiple command line arguments, be sure first argument always refers to the operation you want to perform");
        System.out.println("For Example : login 'useremail' 'password'");
        System.out.println("Below are some command line arguments you can use : ");
        System.out.println("login 'useremail' 'password'");
        System.out.println("login 'useremail'");
        System.out.println("logout 'useremail' ");
        System.out.println("viewmyprofile 'useremail'");
        System.out.println(
                "searchprofile 'useremail1' 'useremail2' [useremail1 - administrator/recruiter , useremail2 - user]");
        System.out.println("viewjobs");
        System.out.println("viewmyappliedjobs 'useremail'");
        // add more...
        System.out.println(
                "***********************************************************************************************************************");

    }

    public static void printUserLoginMenu() {
        System.out.println("Enter 1 to login");
        System.out.println("Enter 2 to Register");
        System.out.println("Enter 0 to exit");
    }

    public static void printCustomerMenu() {
        System.out.println("1 : Profile");
        System.out.println("2 : Bills");
        System.out.println("3 : Logout");
    }

    public static void printProfileMenu() {
        System.out.println("1 : View Profile");
        System.out.println("2 : Modify Profile");
        System.out.println("3 : Back");
    }

    // public static void printJobSeekerJobMenu() {
    //     System.out.println("1 : View Jobs");
    //     System.out.println("2 : Apply for Job");
    //     System.out.println("3 : View Applied Jobs");
    //     System.out.println("4 : view profile");
    // }

    public static void printAdminMenu() {
        System.out.println("1 : Profile");
        // System.out.println("2 : Job");
        // System.out.println("3 : Applications");
        System.out.println("4 : Logout");
    }

    // public static void printRecruiterJobMenu() {
    //     System.out.println("1 : View Jobs posted by You");
    //     System.out.println("2 : Post a Job");
    //     System.out.println("3 : Modify a Job Posting");
    //     System.out.println("4 : Delete A Job Posting");
    //     System.out.println("5 : Back");
    // }

    public static void printApplicationsMenu() {

    }

    public static void printAdministratorMenu() {

    }

    // public static void printJobTitles(ArrayList<Job> jobList) {
    //     int variable = 1;
    //     for (Job job : jobList) {
    //         System.out.println(variable + " : " + job.getJobTitle() + " ID" + job.getId());
    //         variable++;
    //     }
    //     System.out.println(variable + " : View All");
    // }

    // public static void printJobDetails(Job job) {
    //     System.out.println("Job Title : " + job.getJobTitle());
    //     System.out.println("Job ID : " + job.getId());
    //     System.out.println("Company Name : " + job.getCompanyName());
    //     System.out.println("Location : " + job.getLocation());
    //     System.out.println("Job Description : " + job.getDescription());
    //     System.out.println("Skills : " + job.getSkillRequired());
    //     System.out.println("Vacancies : " + job.getNumberOfVacancies());
    //     System.out.println("Experience : " + job.getMinExperience());
    //     System.out.println("Last Date : " + job.getDeadline());
    // }

    public static void printUpdatesRequirement(Customer customer) {
        System.out.println("1. Update  Name");
        System.out.println("2. Update  Mobile Number");
        System.out.println("3. Update  House Number");
        System.out.println("4. update  Street");
        System.out.println("5. Update  City");
        System.out.println("6. Update  Password");
        System.out.println("7. Update  TypeOfConnection");
        System.out.println("8. Back");
        System.out.print("Choose your option :");
    }
}