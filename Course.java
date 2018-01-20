public class Course {
	private String courseName, dates;
	private int startTime, endTime; // Endtime cannot be lower than starttime

	public Course() {
		this.courseName = "UNDEFINED";
		this.dates = "UNDEFINED";
		this.startTime = 0;
		this.endTime = 1;
	}

	public Course(String courseName, String dates, int startTime, int endTime) {
		this.courseName = courseName;
		this.dates = dates;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	//MODIFIERS
	public void setStartTime(int newTime){
		this.startTime = newTime;
	}
	public void setEndTime(int newTime){
		this.endTime = newTime;
	}
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	public void setDates(String dates){
		this.dates = dates;
	}

	//ACCESSORS
	public int getStartTime(){
		return this.startTime;
	}
	public int getEndTime(){
		return this.endTime;
	}
	public String getCourseName(){
		return this.courseName;
	}
	public String getDatesVerbose(){
		if(this.dates.equals(1)){return("M,W,F");}
		else {return("T,TH");}
	}
	public String getDates(){
		return(this.dates);	
	}
}
