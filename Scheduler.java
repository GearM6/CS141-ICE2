/*
THIS IS THE DRIVER FILE
*/
import java.util.*;

public class Scheduler {

	public static void main(String[] args) {
		int sectionNumber;
		String courseName;
		String dates;
		int startTime;
		int endTime;

		String askAddCourse = "n";

		boolean courseChecker = false;
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to your schedule builder!");

		do {
			System.out.print("Please enter a course that you would like to add(CS141, Bio, or Eng): ");
			courseName = kb.nextLine();
			switch (courseName.toLowerCase())
			{
				case cs141: {
					Course cs141 = new Course(CS141, 0, 10, 11);
					dates = cs141.getDatesVerbose();
					startTime = cs141.getStartTime();
					endTime = cs141.getEndTime();
					courseName = cs141.getCourseName();
					System.out.print("Would you like to add another class?(y/n)");
					askAddCourse = kb.nextLine();
					if (addAnotherCourse.toLowerCase() != y || addAnotherCourse.toLowerCase != n)
						courseChecker = true;
				}

				case eng: {
					Course eng = new Course(English, 1, 11, 12);
					dates = eng.getDatesVerbose();
					startTime = eng.getStartTime();
					endTime = eng.getEndTime();
					courseName = eng.getCourseName();
					System.out.print("Would you like to add another class?(y/n)");
					addAnotherCourse = kb.nextLine();
					if (addAnotherCourse.toLowerCase() != y || addAnotherCourse.toLowerCase != n)
						courseChecker = true;
				}

				case bio: {
					Course bio = new Course(Biology, 1, 9, 10);
					dates = bio.getDatesVerbose();
					startTime = bio.getStartTime();
					endTime = bio.getEndTime();
					courseName = bio.getCourseName();
					System.out.print("Would you like to add another class?(y/n)");
					addAnotherCourse = kb.nextLine();
					if (addAnotherCourse.toLowerCase() != y || addAnotherCourse.toLowerCase != n)
						courseChecker = true;
				}
			}
		} while (courseChecker == false);
	}
}
