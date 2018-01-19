import java.util.*;

/*
THIS IS THE DRIVER FILE
*/
public class Scheduler {

	public static void main(String[] args) {
		String courseName, dates;
		int startTime, endTime;
		Scanner scan = new Scanner(System.in);
		String[] course = new String{"course1", "course2", "course3", "course4"};
		for(int i = 1; i <= 4; i++){
	    Course course = new Course(i);
	    System.out.println("Please enter the course name: ");
	    courseName = scan.next();

			do {
				System.out.print("Please enter 1 for MWF or 2 for TTH meeting days: ");
				int input = scan.nextInt();
				switch(input)
				{
					case 1:
						dates = "MWF";
						break;
					case 2:
						dates = "TTH";
						break;
					default:
						System.out.println("Please enter 1 or 2!");
				}
				} while (input != 1 || input != 2)


	    System.out.print("Please enter the start time (0-24): ");
	    startTime = scan.nextInt();

			System.out.print("Please enter the end time (0-24): ");
	    endTime = scan.nextInt();
			course[i] = new Course(courseName, dates, startTime, endTime);
    }

	}
}
