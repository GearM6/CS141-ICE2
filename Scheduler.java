import java.util.*;

/*
THIS IS THE DRIVER FILE
*/
public class Scheduler {


	public static void checkInterference (Course A, Course B, Course C, Course D) {
		if (A.getDates().equals(B.getDates())){
			if (A.getEndTime() > B.getStartTime() || B.getEndTime() > A.getStartTime())
			System.out.println("Course conflict between " + A.getCourseName() + " and " + B.getCourseName() + ".");
		}
		if (A.getDates().equals(C.getDates())){
			if (A.getEndTime() > C.getEndTime() || C.getEndTime() > A.getStartTime())
			System.out.println("Course conflict between " + A.getCourseName() + " and " + C.getCourseName() + ".");
		}
		if (A.getDates().equals(D.getDates())){
			if (A.getEndTime() > D.getEndTime() || D.getEndTime() > A.getStartTime())
			System.out.println("Course conflict between " + A.getCourseName() + " and " + D.getCourseName() + ".");
		}
		if (B.getDates().equals(C.getDates())){
			if (B.getEndTime() > C.getEndTime() || C.getEndTime() > B.getStartTime())
			System.out.println("Course conflict between " + B.getCourseName() + " and " + C.getCourseName() + ".");
		}
		if (B.getDates().equals(D.getDates())){
			if (B.getEndTime() > D.getEndTime() || D.getEndTime() > B.getStartTime())
			System.out.println("Course conflict between " + B.getCourseName() + " and " + D.getCourseName() + ".");
		}
		if (C.getDates().equals(D.getDates())){
			if (C.getEndTime() > D.getEndTime() || D.getEndTime() > C.getStartTime())
			System.out.println("Course conflict between " + C.getCourseName() + " and " + D.getCourseName() + ".");
		}
	}
	public static void main(String[] args) {
		String courseName, dates = null;
		int startTime, endTime, input;
		Scanner scan = new Scanner(System.in);
		Course course1 = null;
		Course course2 = null;
		Course course3 = null;
		Course course4 = null;
		for(int i = 0; i <= 3; i++){

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
		checkInterference(course1, course2, course3, course4);
		//System.out.println(course1.getCourseName());
		//System.out.println(course2.getCourseName());
		//System.out.println(course3.getCourseName());
		//System.out.println(course4.getCourseName());

		scan.close();
	}
}
