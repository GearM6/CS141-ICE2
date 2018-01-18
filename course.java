public class Course {
	private String courseName, dates;
	private int startTime, endTime; // Endtime cannot be lower than starttime

	public Course() {
		this.courseName = "UNDEFINED";
		this.dates = "UNDEFINED";
		this.startTime = 0;
		this.endTime = 1;
	}
}