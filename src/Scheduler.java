/*
THIS IS THE DRIVER FILE
*/
import java.util.*;

public class Scheduler {

	public static void main(String[] args) {
		String courseName;
		String dates;
		int startTime;
		int endTime;

		String askAddCourse;

		boolean courseChecker = false;
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to your schedule builder!");

		do {
			System.out.print("Please enter a course that you would like to add(CS141, Bio, or Eng): ");
			courseName = kb.nextLine();
			switch (courseName.toLowerCase())
			{
				case "cs141": {
					Course cs141 = new Course(courseName, 0, 10, 11);
					dates = cs141.getDatesVerbose();
					startTime = cs141.getStartTime();
					endTime = cs141.getEndTime();
					courseName = cs141.getCourseName();
					System.out.print("Would you like to add another class?(y/n)");
					askAddCourse = kb.nextLine();
					if (askAddCourse.charAt(0) != 'y' || askAddCourse.charAt(0) != 'n')
						courseChecker = true;
				}

				case "eng": {
					Course eng = new Course(courseName, 1, 11, 12);
					dates = eng.getDatesVerbose();
					startTime = eng.getStartTime();
					endTime = eng.getEndTime();
					courseName = eng.getCourseName();
					System.out.print("Would you like to add another class?(y/n)");
					askAddCourse = kb.nextLine();
					if (askAddCourse.charAt(0) != 'y' || askAddCourse.charAt(0) != 'n')
						courseChecker = true;
				}

				case "bio": {
					Course bio = new Course(courseName, 1, 9, 10);
					dates = bio.getDatesVerbose();
					startTime = bio.getStartTime();
					endTime = bio.getEndTime();
					courseName = bio.getCourseName();
					System.out.print("Would you like to add another class?(y/n)");
					askAddCourse = kb.nextLine();
					if (askAddCourse.charAt(0) != 'y' || askAddCourse.charAt(0) != 'n')
						courseChecker = true;
				}
			}
		} while (!courseChecker);
	}
}
