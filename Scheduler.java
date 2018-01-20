import java.util.*;

/*
THIS IS THE DRIVER FILE
*/
public class Scheduler {



	@SuppressWarnings("null")
	public static void main(String[] args) {
		String courseName, dates = null;
		int startTime, endTime, input = 3;
		Scanner scan = new Scanner(System.in);
		Course course1 = null;
		Course course2 = null;
		Course course3 = null;
		Course course4 = null;
		for(int i = 0; i <= 3; i++){
		    //Course course = new Course(i);
		    System.out.print("Please enter the course name: ");
		    courseName = scan.next();

				if (input != 1 || input != 2) {
					System.out.print("Please enter 1 for MWF or 2 for TTH meeting days: ");
					input = scan.nextInt();
					switch(input)
					{
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
				}


		    System.out.print("Please enter the start time (0-24): ");
		    startTime = scan.nextInt();

			System.out.print("Please enter the end time (0-24): ");
		    endTime = scan.nextInt();

			if (i == 0)
				course1 = new Course(courseName, dates, startTime, endTime);
			else if (i == 1)
				course2 = new Course(courseName, dates, startTime, endTime);
			else if (i == 2)
				course2 = new Course(courseName, dates, startTime, endTime);
			else if (i == 2)
				course3 = new Course(courseName, dates, startTime, endTime);


		}
		System.out.println(course1.getCourseName());
		System.out.println(course2.getCourseName());
		System.out.println(course3.getCourseName());
		System.out.println(course4.getCourseName());

		scan.close();
	}
}
