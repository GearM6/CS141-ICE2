import java.util.*;

/*
THIS IS THE DRIVER FILE
*/
public class Scheduler {


	public static void checkInterference (Course A, Course B) {
		if (A.getDates().equals(B.getDates())){
			if (A.getEndTime() > B.getStartTime())
			System.out.println("Course conflict between " + A.getCourseName() + " and " + B.getCourseName() + ".");
		}
		/*else if (course1.dates.equals(course3.dates)){
			if (course1.endTime > course3.endTime)
			System.out.println("Course conflict between " + course1.getCourseName " and " + course3.getCourseName ".")
		}*/
	}
	@SuppressWarnings("null")
	public static void main(String[] args) {
		String courseName, dates = null;
		int startTime, endTime, input;
		Scanner scan = new Scanner(System.in);
		Course course1 = null;
		Course course2 = null;
		Course course3 = null;
		Course course4 = null;
		for(int i = 0; i <= 1; i++){

		    System.out.print("Please enter the course name: ");
		    courseName = scan.next();

				while (true) {
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
					if (input == 1 || input == 2)
						break;
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
				course3 = new Course(courseName, dates, startTime, endTime);
			else if (i == 2)
				course4 = new Course(courseName, dates, startTime, endTime);


		}
		checkInterference(course1, course2);
		System.out.println(course1.getCourseName());
		System.out.println(course2.getCourseName());
		//System.out.println(course3.getCourseName());
		//System.out.println(course4.getCourseName());

		scan.close();
	}
}
