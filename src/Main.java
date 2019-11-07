/*
 * Thursday Weekly Challenge
 * Week 3
 * Resume Challenge
 *
 * Ksenia Lake
 * November 7, 2019
 *
 * Project Description:
 * Part 2: https://canvas.instructure.com/courses/1743334/assignments/12845641?module_item_id=26321394
 *
 * This is the working copy of my implementation of PART TWO.
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // class-level vars
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        // local main-method vars
        String userStr;
        int userID;

        System.out.println("Welcome to Rose's Awesome Resume App!");
        // eventually :: you can log in as a user, a recruiter, or q to quit.

        // for now, user only:
        UserHashMapSingleton userMap = UserHashMapSingleton.getInstance();
        System.out.print("Please enter a USER ID. If you do not have one, type \"0\": ");
        userID = keyboard.nextInt();
        keyboard.nextLine();
        playLoop: while(true) {
            User currentUser = getOrCreateUser(userID, userMap);
            // this method will return a User, or null if the ID was not zero and was not found in the userMap.
            if (currentUser != null) {
                System.out.print("\nWelcome, " + currentUser.getName() + "!\n" +
                        "Would you like to...\n" +
                        "\t[\"v\" or \"view\"] VIEW your resume(s)\n" +
                        "\t[\"a\" or \"add\"]  ADD a new one \n" +
                        "\t[\"u\" or \"user\"] log in as a different USER \n" +
                        "\t[\"q\" or \"quit\"] or QUIT?\n" +
                        "Please enter your choice: ");
                userStr = keyboard.nextLine();
                while (true) {
                    if (userStr.equalsIgnoreCase("v") || userStr.equalsIgnoreCase("view")) {
                        // VIEW resumes
                        if (currentUser.getResumes().size() > 0) {
                            int counter = 1;
                            System.out.println("Here are your current resumes, " + currentUser.getName() + "!\n");
                            for (Resume r : currentUser.getResumes()) {
                                System.out.println("RESUME " + counter + ":");
                                System.out.println(r.displayText());
                                counter++;
                            }
                        } else {
                            System.out.println("\nYou must first add a resume!");
                        }
                    } else if (userStr.equalsIgnoreCase("a") || userStr.equalsIgnoreCase("add")) {
                        // ADD a resume
                        currentUser.addResume(getUserResume());
                        // test code
                        // currentUser.addResume(testResumeBuilder());
                        System.out.println("\nCongratulations on adding a Resume!");
                    } else if (userStr.equalsIgnoreCase("u") || userStr.equalsIgnoreCase("user")) {
                        break;
                    } else if (userStr.equalsIgnoreCase("q") || userStr.equalsIgnoreCase("quit")) {
                        break playLoop;
                    } else {
                        System.out.print("Please enter a valid option:\n" +
                                "\"v\" to view, \"a\" to add, \"u\" to switch users, or \"q\" to quit: ");
                        userStr = keyboard.nextLine();
                        continue;
                    }
                    System.out.print("What would you like to do next, " + currentUser.getName() + "?\n" +
                            "\t[\"v\" or \"view\"] VIEW your resume(s)\n" +
                            "\t[\"a\" or \"add\"]  ADD a new one \n" +
                            "\t[\"u\" or \"user\"] log in as a different USER \n" +
                            "\t[\"q\" or \"quit\"] or QUIT?\n" +
                            "Please enter your choice: ");
                    userStr = keyboard.nextLine();
                } // end User Loop
            } // end User was not null
            else { System.out.println("That was not a valid user ID."); }
            System.out.print("\nPlease enter another USER ID (if you do not have one, type \"0\"): ");
            userID = keyboard.nextInt();
            keyboard.nextLine();

        } // end Play Loop

//        // Testing Code
//        ArrayList<Resume> testResumes = testResumesBuilder();
//        for (Resume testResume : testResumes) {
//            System.out.println(testResume.displayText());
//        }

        // exit the program
        System.out.println("Goodbye!");
        keyboard.close();

    } // end main

    // takes in a user ID
    // returns the User object for the current user (calls createNewUser() if needed)
    // returns null if the user entered an id and it was not found in our HashMap
    public static User getOrCreateUser(int id, UserHashMapSingleton userMap){
        if (id == 0) { return createNewUser(userMap); }
        else return userMap.getUser(id);
    }

    public static User createNewUser(UserHashMapSingleton userMap){
        System.out.print("\nPlease enter your Name: ");
        String name = keyboard.nextLine();
        User newUser = new User(name, new ArrayList<>());
        int newId = userMap.addUser(newUser);
        System.out.println("\nThe USER ID for " + newUser.getName() + " is *** " + newId + " ***\nPlease make a note of it!");
        return newUser;
    }

    // for TESTING code :: SEVERAL pre-built RESUMES
    public static ArrayList<Resume> testResumesBuilder(){

        ArrayList<Resume> resumes = new ArrayList<>();
        String name, email;
        ArrayList<Education> educations;
        ArrayList<WorkExperience> works;
        ArrayList<Skill> skills;

        // build RESUME ONE
        name = "I am a Resume Tester";
        email = "tester@test.com";
        educations = new ArrayList<>(Arrays.asList(
                new Education("B.S.", "Testing", "Testing University", 2011),
                new Education("M.S.", "Astro-Physics", "MIT", 2015)));
        works = new ArrayList<>(Arrays.asList(
                new WorkExperience("Scientist", "NASA", "August 2015", "present",
                        new ArrayList<String>(Arrays.asList("building telescopes", "discovering exoplanets", "being awesome"))),
                new WorkExperience("Tester", "Google Analytics", "2011", "2013",
                        new ArrayList<String>(Arrays.asList("tested code", "analyzed data", "was awesome")))));
        skills = new ArrayList<>(Arrays.asList(
                new Skill("Astronomy", "Excellent"),
                new Skill("Physics", "Outstanding"),
                new Skill("Testing", "Advanced"),
                new Skill("Thinking", "Yup")));
        resumes.add(new Resume(name, email, educations, works, skills));

        // build RESUME TWO
        name = "John J Jingleheimer-Schmidt";
        email = "jjjschmidt@gmail.com";
        educations = new ArrayList<>(Arrays.asList(
                new Education("B.S.", "Psychology", "University of Maryland", 2002),
                new Education("M.S.", "Software Engineering", "Johns Hopkins University", 2005)));
        works = new ArrayList<>(Arrays.asList(
                new WorkExperience("Software Developer II", "Amtrak", "June 2015", "Present",
                        new ArrayList<String>(Arrays.asList("writing code", "testing code", "rocking out"))),
                new WorkExperience("Software Developer I", "Amtrak", "June 2014", "June 2015",
                        new ArrayList<String>(Arrays.asList("wrote code", "refactored other people's code", "rocked out"))),
                new WorkExperience("Business Analyst", "DCPS", "August 2005", "May 2014",
                        new ArrayList<String>(Arrays.asList("analysed business", "yeah")))));
        skills = new ArrayList<>(Arrays.asList(
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
            while (detailLoop) {
                System.out.print("Detail: ");
                String detail = keyboard.nextLine();

                details.add(detail);

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


