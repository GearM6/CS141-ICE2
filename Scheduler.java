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
        String[] addMWF = new String[3];
        String[] addTTH = new String[3];

        int[] startTimeMWF = new int[3];
        int[] endTimeMWF = new int[3];
        int[] startTimeTTH = new int[3];
        int[] endTimeTTH = new int[3];


        if (A.getDates().charAt(0) == 'M') {
            addMWF[0] = A.getCourseName();
            startTimeMWF[0] = A.getStartTime();
            endTimeMWF[0] = A.getEndTime();
        }
        else {
            addTTH[0] = A.getCourseName();
            startTimeTTH[0] = A.getStartTime();
            endTimeTTH[0] = A.getEndTime();
        }
        if (B.getDates().charAt(0) == 'M') {
            addMWF[1] = B.getCourseName();
            startTimeMWF[1] = B.getStartTime();
            endTimeMWF[1] = B.getEndTime();
        }
        else {
            addTTH[1] = B.getCourseName();
            startTimeTTH[1] = B.getStartTime();
            endTimeTTH[1] = B.getEndTime();
        }
        if (C.getDates().charAt(0) == 'M') {
            addMWF[2] = C.getCourseName();
            startTimeMWF[2] = A.getStartTime();
            endTimeMWF[2] = A.getEndTime();
        }
        else {
            addTTH[2] = C.getCourseName();
            startTimeTTH[2] = C.getStartTime();
            endTimeTTH[2] = C.getEndTime();
        }
        if (D.getDates().charAt(0) == 'M') {
            addMWF[3] = D.getCourseName();
            startTimeMWF[3] = A.getStartTime();
            endTimeMWF[3] = A.getEndTime();
        }
        else {
            addTTH[3] = D.getCourseName();
            startTimeTTH[3] = D.getStartTime();
            endTimeTTH[3] = D.getEndTime();
        }

        String[] sortedCourseMWF = sortCourses(addMWF, A, B, C, D);
        String[] sortedCourseTTH = sortCourses(addTTH, A, B, C, D);

        int[] sortedStartTimeMWF = sortTime(startTimeMWF);
        int[] sortedEndTimeMWF = sortTime(endTimeMWF);
        int[] sortedStartTimeTTH = sortTime(startTimeTTH);
        int[] sortedEndTimeTTH = sortTime(endTimeTTH);

        System.out.println("   MWF");
        System.out.println("---------");
        for (int i = 0; i < addMWF.length - 1; i++) {
            System.out.printf("%s: %2d-%d", sortedCourseMWF[i], sortedStartTimeMWF[i], sortedEndTimeMWF[i]);
        }
        System.out.println();

        System.out.println("   TTH");
        System.out.println("---------");
        for (int i = 0; i < addTTH.length - 1; i++) {
            System.out.printf("%s: %2d-%d", sortedCourseTTH[i], sortedStartTimeTTH[i], sortedEndTimeTTH[i]);
        }
    }

    public static String[] sortCourses(String[] a, Course A, Course B, Course C, Course D) {
        String min;
        if (A.getStartTime() < D.getStartTime()) {
            min = B.getCourseName();
            a[1] = a[0];
            a[0] = min;
            if (A.getStartTime() > C.getStartTime()) {
                min = C.getCourseName();
                a[2] = a[1];
                a[1] = min;
                if (A.getStartTime() > D.getStartTime()) {
                    min = D.getCourseName();
                    a[3] = a[2];
                    a[2] = min;
                }
            }
            else if (A.getStartTime() > D.getStartTime()) {
                min = D.getCourseName();
                a[3] = a[1];
                a[1] = min;
            }
        }
        else if (A.getStartTime() > C.getStartTime()) {
            min = C.getCourseName();
            a[2] = a[0];
            a[0] = min;
            if (A.getStartTime() > D.getStartTime()) {
                min = D.getCourseName();
                a[3] = a[2];
                a[2] = min;
            }
        }
        else if (A.getStartTime() > D.getStartTime()) {
            min = D.getCourseName();
            a[3] = a[0];
            a[0] = min;
        }
        else if (B.getStartTime() > C.getStartTime()) {
            min = C.getCourseName();
            a[2] = a[1];
            a[1] = min;
            if (B.getStartTime() > D.getStartTime()) {
                min = D.getCourseName();
                a[3] = a[2];
                a[2] = min;
            }
        }
        else if (C.getStartTime() > D.getStartTime()) {
            min = D.getCourseName();
            a[2] = a[3];
            a[3] = min;
        }
        return a;
    }
    public static int[] sortTime(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = 0, temp;
            for (int j = i + 1; i < a.length; j++) {
                if (a[i] > a[j]) {
                    min = j;
                }
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
        return a;
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
