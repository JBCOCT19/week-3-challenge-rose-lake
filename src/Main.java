/**
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
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        boolean keepGoing = true;
        String userStr;


        System.out.println("Welcome to Rose's Resume Builder App!");
        System.out.println("This program will walk you through creating a basic resume.");
        System.out.println("Would you like to continue?... (y/n)");
        userStr = keyboard.nextLine();
        if (userStr.equalsIgnoreCase("n")) { keepGoing = false; }
        else {
            // run the program to create ONE Resume
            Resume loopResume = new Resume();

            // vars for Resume inputs. May get rid of, later. For now, for clarity.
            String name;
            String email;
            ArrayList<Education> educationList = new ArrayList<>();
            ArrayList<WorkExperience> workList = new ArrayList<>();
            ArrayList<Skill> skillList = new ArrayList<>();

            // USER-Input
            System.out.println("Please enter your name: ");
            name = keyboard.nextLine();
            System.out.println("Please enter your email: ");
            email = keyboard.nextLine();
            educationList = getUserEducation();

            // test code: display what we have so far
            System.out.println(name);
            System.out.println(email);
            for (Education education : educationList) {
                System.out.println(education.displayText());
            }

//            workList = getUserWorkExperience();
//            skillList = getUserSkill();
//
//            //TO-DO: resume.add all the above things that were created
//
//            System.out.println("Great! Here is your resume:");
//            loopResume.displayText();

        }

        // exit the program
        System.out.println("Best of luck in getting the job that's right for you!");
        System.out.println("Goodbye!");
        keyboard.close();

    } // end main

    private static ArrayList<Education> getUserEducation(){
        ArrayList<Education> educationList = new ArrayList<>();
        boolean keepGoing = true;
        int counter = 0;
        System.out.println("Please enter at least one Educational Achievement...");
        while(keepGoing) {
            System.out.print("Degree: ");
            String degree = keyboard.nextLine();
            System.out.print("Major: ");
            String major = keyboard.nextLine();
            System.out.print("University: ");
            String university = keyboard.nextLine();
            System.out.print("Graduation Year: ");
            int graduationYear = keyboard.nextInt();
            keyboard.nextLine();
            educationList.add(new Education(degree, major, university, graduationYear));
            System.out.println("Would you like to enter another Educational Achievment? (y/n)");
            String userStr = keyboard.nextLine();
            if (userStr.equalsIgnoreCase("n")) { keepGoing = false; }
            // no else: we just keep looping until they say "n"
        }
        return educationList;
    } // end getUserEducation

//    private static ArrayList<WorkExperience> getUserWorkExperience(){
//        ArrayList<WorkExperience> workList = new ArrayList<>();
//        boolean keepGoing = true;
//        int counter = 0;
//
//        while (keepGoing) {
//            // ask for at least one work experience
//            WorkExperience loopWorkExperience = new WorkExperience();
//        }
//        return workList;
//    } // end getUserWorkExperience
//
//    private static ArrayList<Skill> getUserSkill(){
//        ArrayList<Skill> skillList = new ArrayList<>();
//        boolean keepGoing = true;
//        int counter = 0;
//        String userStr;
//
//        while (keepGoing) {
//            // ask for at least three skills
//
//            if (userStr.equalsIgnoreCase("n")) {
//                if (counter < 3) { System.out.println("You must enter at least three skills..."); }
//                else { keepGoing = false; }
//            }
//        }
//
//        return skillList;
//    } // end getUserSkill

} // end main class
