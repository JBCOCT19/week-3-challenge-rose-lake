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
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        String userStr;
        int userID;
        ArrayList<User> users = new ArrayList<>();

        System.out.println("Welcome to Rose's Awesome Resume App!");
        boolean playLoop = true;

        while(playLoop) {
            System.out.print("Please enter your user id (if you do not have one, type \"0\"): ");
            userID = keyboard.nextInt();
            keyboard.nextLine();

            // fetch existing or create new USER object
            User currentUser = validateUserID(userID, users);

            System.out.println("Welcome, " + currentUser.name + "!\n" +
                    "Would you like to...\n" +
                    "\tVIEW your resume(s) [\"v\" or \"view\"]\n" +
                    "\tADD a new one [\"a\" or \"add\"]" +
                    "\tlog in as a different USER [\"u\" or \"user\"]" +
                    "\tor QUIT [\"q\" or \"quit\"]?");
            userStr = keyboard.nextLine();
            boolean userLoop = true;
            while (userLoop) {
                if (userStr.equalsIgnoreCase("v") || userStr.equalsIgnoreCase("view")) {

                } else if (userStr.equalsIgnoreCase("a") || userStr.equalsIgnoreCase("add")) {

                } else if (userStr.equalsIgnoreCase("u") || userStr.equalsIgnoreCase("user")) {
                    break;
                } else if (userStr.equalsIgnoreCase("q") || userStr.equalsIgnoreCase("quit")) {
                    playLoop = false;
                    break;
                } else {
                    System.out.print("Please enter a valid option:\n" +
                            "\"v\" to view, \"a\" to add, \"u\" to switch users, or \"q\" to quit: ");
                    userStr = keyboard.nextLine();
                }

            } // end User Loop
        }

        // Testing Code
        ArrayList<Resume> testResumes = testResumesBuilder();
        for (Resume testResume : testResumes) {
            System.out.println(testResume.displayText());
        }

        // Print All of ONE USER's Resumes


        // exit
        System.out.println("Best of luck in getting the job that's right for you!");
        System.out.println("Goodbye!");
        keyboard.close();

    } // end main

    // takes in a user ID and the current user-list from main()
    // returns the User object for the current user (calls makeNewUser() if needed)
    public static User validateUserID(int id, ArrayList<User> users){

    }

    // for TESTING code :: SEVERAL pre-built RESUMES
    public static ArrayList<Resume> testResumesBuilder(){

        ArrayList<Resume> resumes = new ArrayList<>();

        // build RESUME ONE
        String name = "I am a Resume Tester";
        String email = "tester@test.com";
        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(
                new Education("B.S.", "Testing", "Testing University", 2011),
                new Education("M.S.", "Astro-Physics", "MIT", 2015)));
        ArrayList<WorkExperience> works = new ArrayList<>(Arrays.asList(
                new WorkExperience("Scientist", "NASA", "August 2015", "present",
                        new ArrayList<String>(Arrays.asList("building telescopes", "discovering exoplanets", "being awesome"))),
                new WorkExperience("Tester", "Google Analytics", "2011", "2013",
                        new ArrayList<String>(Arrays.asList("tested code", "analyzed data", "was awesome")))));
        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(
                new Skill("Astronomy", "Excellent"),
                new Skill("Physics", "Outstanding"),
                new Skill("Testing", "Advanced"),
                new Skill("Thinking", "Yup")));
        resumes.add(new Resume(name, email, educations, works, skills));

        // build RESUME TWO
        String name = "John J Jingleheimer-Schmidt";
        String email = "jjjschmidt@gmail.com";
        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(
                new Education("B.S.", "Psychology", "University of Maryland", 2002),
                new Education("M.S.", "Software Engineering", "Johns Hopkins University", 2005)));
        ArrayList<WorkExperience> works = new ArrayList<>(Arrays.asList(
                new WorkExperience("Software Developer II", "Amtrak", "June 2015", "Present",
                        new ArrayList<String>(Arrays.asList("writing code", "testing code", "rocking out"))),
                new WorkExperience("Software Developer I", "Amtrak", "June 2014", "June 2015",
                        new ArrayList<String>(Arrays.asList("wrote code", "refactored other people's code", "rocked out"))),
                new WorkExperience("Business Analyst", "DCPS", "August 2005", "May 2014",
                        new ArrayList<String>(Arrays.asList("analysed business", "yeah")))));
        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(
                new Skill("Java", "Advanced"),
                new Skill("PHP", "Intermediate"),
                new Skill("Ruby on Rails", "Novice"),
                new Skill("Perl", "Fundamental")));
        resumes.add(new Resume(name, email, educations, works, skills));

        return resumes;
    }

    // for TESTING code :: ONE pre-built RESUME
    public static Resume testResumeBuilder(){

        String name = "I am a Resume Tester";
        String email = "tester@test.com";
        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(
                new Education("B.S.", "Testing", "Testing University", 2011),
                new Education("M.S.", "Astro-Physics", "MIT", 2015)));
        ArrayList<WorkExperience> works = new ArrayList<>(Arrays.asList(
                new WorkExperience("Scientist", "NASA", "August 2015", "present",
                        new ArrayList<String>(Arrays.asList("building telescopes", "discovering exoplanets", "being awesome"))),
                new WorkExperience("Tester", "Google Analytics", "2011", "2013",
                        new ArrayList<String>(Arrays.asList("tested code", "analyzed data", "was awesome")))));
        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(
                new Skill("Astronomy", "Excellent"),
                new Skill("Physics", "Outstanding"),
                new Skill("Testing", "Advanced"),
                new Skill("Thinking", "Yup")));

        return new Resume(name, email, educations, works, skills);

    }

    // USER input for ONE RESUME
    private static Resume getUserResume(){
        String name = getUserName();
        String email = getUserEmail();
        ArrayList<Education> education = getUserEducation();
        ArrayList<WorkExperience> workExperience = getUserWorkExperience();
        ArrayList<Skill> skill = getUserSkill();
        return new Resume(name, email, education, workExperience, skill);
    }

    // USER input for Name
    private static String getUserName(){
        System.out.print("\nPlease enter your name: ");
        return keyboard.nextLine();
    }

    // USER input for Email
    private static String getUserEmail(){
        System.out.print("\nPlease enter your email: ");
        return keyboard.nextLine();
    }

    // USER input for Education
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

    // USER input for Work Experience
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

    // USER input for Skill
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


