/*
THIS IS THE DRIVER FILE
*/

import java.util.Scanner;

public class Scheduler {
    public static int courseCounter = 0; //Counts Number of Courses
    public static boolean courseChecker = false; //Determines whether or not the user will add a new course
    public static String courseName, oldCourseName; //Sets course name and passes old course name
    public static String askAddCourse;  //Asks if the user would like to add another course

    public static void main(String[] args) {
        String dates; //
        int startTime, endTime; //
        boolean courseChecker = false; //Determines whether or not the user will add a new course

        //Passing Variables into the Constructor
        Course cs141 = new Course(courseName, "0", 10, 11); //Creates CS141 course
        Course bio = new Course(courseName, "1", 9, 10); //Creates Bio course
        Course eng = new Course(courseName, "1", 11, 12); //Creates Eng course

        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to your schedule builder!\n");

        System.out.print("Please enter a course that you would like to add(CS141, Bio, or Eng): ");
        courseName = kb.nextLine(); //Gets User Input of which course they would like to add.

        do {
            switch (courseName.toLowerCase()) { //Adds courses to schedule (need to cleanup)
                case "cs141": {
                    dates = cs141.getDatesVerbose();
                    startTime = cs141.getStartTime();
                    endTime = cs141.getEndTime();
                    courseName = cs141.getCourseName();

                    courseCounter++;
                    System.out.print("Would you like to add another class?(y/n): ");
                    askAddCourse = kb.nextLine();
                    askCheck(askAddCourse);
                }

                case "eng": {
                    dates = eng.getDatesVerbose();
                    startTime = eng.getStartTime();
                    endTime = eng.getEndTime();
                    courseName = eng.getCourseName();

                    courseCounter++;
                    System.out.print("Would you like to add another class?(y/n): ");
                    askAddCourse = kb.nextLine();
                    askCheck(askAddCourse);
                }

                case "bio": {
                    dates = bio.getDatesVerbose();
                    startTime = bio.getStartTime();
                    endTime = bio.getEndTime();
                    courseName = bio.getCourseName();

                    courseCounter++;
                    System.out.print("Would you like to add another class?(y/n): ");
                    askAddCourse = kb.nextLine();
                    askCheck(askAddCourse);
                }

                default: {
                    System.out.println("Invalid course name.");
                    System.exit(0); //Temporary Fix
                }
            }
        } while (courseChecker && courseCounter <= 4);
    }

    public static boolean askCheck(String charCheck) {
        Scanner kb = new Scanner(System.in);
        boolean check = true;

        while (charCheck.charAt(0) != 'y' || charCheck.charAt(0) != 'n') {
            System.out.println("Error: Please enter y or n.");
            System.out.print("Would you like to add another class?(y/n): ");
            askAddCourse = kb.nextLine();
        }

        if (askAddCourse.charAt(0) == 'y') {
            addNewCourse();
        }
        else
            check = false;
        return check;
    }

    public static void addNewCourse() { //After adding initial course, adds more courses.
        Scanner kb = new Scanner(System.in);
        oldCourseName = courseName;
        System.out.print("Please enter another course that you would like to add(CS141, Bio, or Eng): ");
        courseName = kb.nextLine();
    }
}
