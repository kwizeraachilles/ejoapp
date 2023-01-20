package ejopackage.helper;

public class CourseDTO {
	
	private int coursecategoryid;
	private String coursename;
	private int hourz;
	private int importance;

	public CourseDTO() {
	
	}

	public int getCoursecategoryid() {
		return coursecategoryid;
	}

	public void setCoursecategoryid(int coursecategoryid) {
		this.coursecategoryid = coursecategoryid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getHourz() {
		return hourz;
	}

	public void setHourz(int hourz) {
		this.hourz = hourz;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	
}
