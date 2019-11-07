/*
 * Thursday Weekly Challenge
 * Week 3
 * Resume Challenge
 *
 * Ksenia Lake
 * November 7, 2019
 *
 * Project Description:
 * Part 1: Robo Resume: https://canvas.instructure.com/courses/1743334/assignments/12845640?module_item_id=26321393
 *
 * This code is all of the complete and working PART ONE ONLY
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        String userStr;
        System.out.println("Welcome to Rose's Awesome Resume App!");
        System.out.println("You rock! Are you ready to enter in a resume? (y/n)");
        userStr = keyboard.nextLine();
        if (!userStr.equalsIgnoreCase("n")) {
            Resume userResume = getUserResume();
            System.out.println("\nGreat! Here is your resume:\n");
            System.out.println(userResume.displayText());
        }
        System.out.println("Best of luck in getting the job that's right for you!");
        System.out.println("Goodbye!");
        keyboard.close();

    } // end main

    private static Resume getUserResume(){
        String name = getUserName();
        String email = getUserEmail();
        ArrayList<Education> education = getUserEducation();
        ArrayList<WorkExperience> workExperience = getUserWorkExperience();
        ArrayList<Skill> skill = getUserSkill();
        return new Resume(name, email, education, workExperience, skill);
    }

    private static String getUserName(){
        System.out.print("\nPlease enter your name: ");
        return keyboard.nextLine();
    }

    private static String getUserEmail(){
        System.out.print("\nPlease enter your email: ");
        return keyboard.nextLine();
    }

    private static ArrayList<Education> getUserEducation(){

        ArrayList<Education> educationList = new ArrayList<>();
        boolean keepGoing = true;
        String degree, major, university, userStr;
        int graduationYear, counter = 0;

        System.out.println("\nPlease enter at least one Educational Achievement...");
        while(keepGoing) {

            System.out.println("\nEducational Achievement " + (counter+1) + ":");
            System.out.print("Degree: ");
            degree = keyboard.nextLine();
            System.out.print("Major: ");
            major = keyboard.nextLine();
            System.out.print("University: ");
            university = keyboard.nextLine();
            System.out.print("Graduation Year: ");
            graduationYear = keyboard.nextInt();
            keyboard.nextLine();

            // add ONE Education to our list
            educationList.add(new Education(degree, major, university, graduationYear));
            counter++;

            // decide whether to loop
            System.out.print("Would you like to enter another Educational Achievement? (y/n): ");
            userStr = keyboard.nextLine();
            if (userStr.equalsIgnoreCase("n")) { keepGoing = false; }
        }

        return educationList;

    } // end getUserEducation


    private static ArrayList<WorkExperience> getUserWorkExperience(){
        ArrayList<WorkExperience> workList = new ArrayList<>();
        boolean workLoop = true;
        int workCounter = 0;

        System.out.println("\nPlease enter at least one Work Experience...");
        while (workLoop) {

            System.out.println("\nWork Experience " + (workCounter+1) + ":");
            System.out.print("Title: ");
            String title = keyboard.nextLine();
            System.out.print("Company: ");
            String company = keyboard.nextLine();
            System.out.print("Start Date: ");
            String startDate = keyboard.nextLine();
            System.out.print("End Date: ");
            String endDate = keyboard.nextLine();

            // get some details from the user
            System.out.println("Please enter at least one Detail pertaining to this Work Experience...");
            ArrayList<String> details = new ArrayList<>();
            boolean detailLoop = true;
            int detailCounter = 0;
            while (detailLoop) {

                System.out.print("Detail: ");
                String detail = keyboard.nextLine();

                details.add(detail);
                detailCounter++;

                System.out.print("Would you like to enter another Detail? (y/n): ");
                String userStr = keyboard.nextLine();
                if (userStr.equalsIgnoreCase("n")) {detailLoop = false;}
            }

            // add ONE WorkExperience to our list
            workList.add(new WorkExperience(title, company, startDate, endDate, details));
            workCounter++;

            // decide whether to loop
            System.out.print("Would you like to enter another Work Experience? (y/n): ");
            String userStr = keyboard.nextLine();
            if (userStr.equalsIgnoreCase("n")) { workLoop = false; }
        }

        return workList;

    } // end getUserWorkExperience


    private static ArrayList<Skill> getUserSkill(){
        ArrayList<Skill> skillList = new ArrayList<>();
        boolean keepGoing = true;
        int counter = 0;

        System.out.println("\nPlease enter at least three Skills...");
        while (keepGoing) {

            System.out.print("Skill " + (counter+1) + ": ");
            String name = keyboard.nextLine();
            System.out.print("Proficiency: ");
            String proficiency = keyboard.nextLine();

            skillList.add(new Skill(name, proficiency));
            counter++;

            // ensure three skills + decide whether to loop more
            if (counter >= 3) {
                System.out.print("Would you like to enter another Skill? (y/n): ");
                String userStr = keyboard.nextLine();
                if (userStr.equalsIgnoreCase("n")) { keepGoing = false; }
            }

        } // end while

        return skillList;

    } // end getUserSkill


} // end main class


// ***********************************************
// test code used while building the code base...
// ***********************************************
//
//            // CALLING CODE in main()
//            Resume testResume = testResumeBuilder();
//            System.out.println(testResume.displayText());
//
//    // METHOD in Main{}
//    public static Resume testResumeBuilder(){
//        String name = "John Doe";
//        String email = "john@doe.com";
//        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(
//                new Education("B.S.", "Mathematics", "UMCP", 2001),
//                new Education("M.Ed.", "Secondary Mathematics", "UMCP", 2003)));
//        ArrayList<WorkExperience> works = new ArrayList<>(Arrays.asList(
//                new WorkExperience("Barista", "Dolcezza", "August 2011", "August 2014",
//                        new ArrayList<String>(Arrays.asList("detail 1", "detail 2", "detail 3"))),
//                new WorkExperience("Tutor", "Self", "1999", "present",
//                        new ArrayList<String>(Arrays.asList("detail one", "detail two", "detail three")))));
//        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(
//                new Skill("Java", "Excellent"),
//                new Skill("Python", "Outstanding"),
//                new Skill("Test", "Advanced"),
//                new Skill("Writing", "Yup")));
//
//        return new Resume(name, email, educations, works, skills);
//
//    }
//
