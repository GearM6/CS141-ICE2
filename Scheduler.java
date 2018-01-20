import java.util.*;

/*
THIS IS THE DRIVER FILE
*/
public class Scheduler {


    public static void checkInterference(Course A, Course B, Course C, Course D) {
        if (A.getDates().equals(B.getDates())) {
            if (A.getEndTime() > B.getStartTime() || B.getEndTime() > A.getStartTime())
                System.out.println("Course conflict between " + A.getCourseName() + " and " + B.getCourseName() + ".");
        }
        if (A.getDates().equals(C.getDates())) {
            if (A.getEndTime() > C.getEndTime() || C.getEndTime() > A.getStartTime())
                System.out.println("Course conflict between " + A.getCourseName() + " and " + C.getCourseName() + ".");
        }
        if (A.getDates().equals(D.getDates())) {
            if (A.getEndTime() > D.getEndTime() || D.getEndTime() > A.getStartTime())
                System.out.println("Course conflict between " + A.getCourseName() + " and " + D.getCourseName() + ".");
        }
        if (B.getDates().equals(C.getDates())) {
            if (B.getEndTime() > C.getEndTime() || C.getEndTime() > B.getStartTime())
                System.out.println("Course conflict between " + B.getCourseName() + " and " + C.getCourseName() + ".");
        }
        if (B.getDates().equals(D.getDates())) {
            if (B.getEndTime() > D.getEndTime() || D.getEndTime() > B.getStartTime())
                System.out.println("Course conflict between " + B.getCourseName() + " and " + D.getCourseName() + ".");
        }
        if (C.getDates().equals(D.getDates())) {
            if (C.getEndTime() > D.getEndTime() || D.getEndTime() > C.getStartTime())
                System.out.println("Course conflict between " + C.getCourseName() + " and " + D.getCourseName() + ".");
        }
    }

    public static void sortSchedule(Course A, Course B, Course C, Course D) {
        String[] sortMWF = new String[3];
        String[] sortTTH = new String[3];

        if (A.getDates().charAt(0) == 'M')
            sortMWF[0] = A.getCourseName();
        else
            sortTTH[0] = A.getCourseName();
        if (B.getDates().charAt(0) == 'M')
            sortMWF[1] = B.getCourseName();
        else
            sortTTH[1] = B.getCourseName();
        if (C.getDates().charAt(0) == 'M')
            sortMWF[2] = C.getCourseName();
        else
            sortTTH[2] = C.getCourseName();
        if (D.getDates().charAt(0) == 'M')
            sortMWF[3] = D.getCourseName();
        else
            sortTTH[3] = D.getCourseName();

        for (int i = 0; i < sortMWF.length - 1; i++) {
            String min, temp;
            for (int j = i + 1; j < sortMWF.length; j++) {
                if (A.getStartTime() > B.getStartTime()) {
                    min = A.getCourseName();
                    sortMWF[1] = sortMWF[0];
                    sortMWF[0] = min;
                }
                else if (A.getStartTime() > C.getStartTime()) {
                    min = C.getCourseName();
                    sortMWF[2] = sortMWF[0];
                    sortMWF[0] = min;
                }
                else {
                    min = D.getCourseName();
                    sortMWF[3] = sortMWF[0];
                    sortMWF[0] = min;
                }
            }
            temp = sortMWF[i];

        }

        System.out.println("   MWF");
        System.out.println("---------");

        System.out.println();

        System.out.println("   TTH");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        String courseName, dates = null;
        int startTime, endTime, input;
        Scanner scan = new Scanner(System.in);
        Course course1 = null;
        Course course2 = null;
        Course course3 = null;
        Course course4 = null;
        for (int i = 0; i <= 3; i++) {

            System.out.print("Please enter the course name: ");
            courseName = scan.next();
            scan.nextLine();

            while (true) {
                System.out.print("Please enter 1 for MWF or 2 for TTH meeting days: ");
                input = scan.nextInt();
                scan.nextLine();
                switch (input) {
                    case 1:
                        dates = "MWF";
                        System.out.println("Date set to MWF");
                        break;
                    case 2:
                        dates = "TTH";
                        break;
                    default:
                        System.out.println("Please enter 1 or 2!");
                }
                if (input == 1 || input == 2)
                    break;
            }

            do {
                System.out.print("Please enter the start time (0-24): ");
                startTime = scan.nextInt();
                scan.nextLine();
                if (startTime < 0 || startTime > 24) {
                    System.out.println("Error: Input is out of bounds.");
                    System.out.print("Please enter the start time (0-24): ");
                    startTime = scan.nextInt();
                    scan.nextLine();
                }

                System.out.print("Please enter the end time (0-24): ");
                endTime = scan.nextInt();
                scan.nextLine();
                if (endTime < 0 || endTime > 24) {
                    System.out.println("Error: Input is out of bounds.");
                    System.out.print("Please enter the end time (0-24): ");
                    endTime = scan.nextInt();
                    scan.nextLine();
                }

                if (startTime > endTime) {
                    System.out.println("Error: Start time is greater than the end time.");
                    System.out.println("Please reenter start and end times.");
                }
            } while (startTime > endTime);

            if (i == 0)
                course1 = new Course(courseName, dates, startTime, endTime);
            else if (i == 1)
                course2 = new Course(courseName, dates, startTime, endTime);
            else if (i == 2)
                course3 = new Course(courseName, dates, startTime, endTime);
            else if (i == 3)
                course4 = new Course(courseName, dates, startTime, endTime);
        }

        checkInterference(course1, course2, course3, course4);
        sortSchedule(course1, course2, course3, course4);

        scan.close();
    }
}
