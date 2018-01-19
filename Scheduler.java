/*
THIS IS THE DRIVER FILE
*/
public class Scheduler {

	public static void main(String[] args) {
		String courseName, dates;
		int startTime, endTime;
		Scanner scan = new Scanner(System.in);
		for(int i = 1; i <= 4; i++){
	    Course course = new Customer(i);
	    System.out.println("Please enter the course name: ");
	    String courseName = scan.next();

			do {
				System.out.print("Please enter 1 for MWF or 2 for TH meeting days: ");
				int input = scan.nextInt();
				switch(input)
				{
					case 1:
						setPermitType(1);
						setPrice(2);
						break;
					case 12:
						setPermitType(12);
						setPrice(5);
						correctInput = true;
						break;
					case 24:
						setPermitType(24);
						setPrice(8);
						correctInput = true;
						break;
					default:
						System.out.println("Please enter 1 or 2!");
				}
				} while (input != 1 || input != 2)


	    System.out.print("Please enter the start time (0-24): ");
	    startTime = scan.nextInt();

			System.out.print("Please enter the end time (0-24): ");
	    endTime = scan.nextInt();
    }
	}
}
