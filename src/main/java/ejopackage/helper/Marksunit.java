package ejopackage.helper;

import java.util.List;

public class Marksunit {
	
	private int lessonid;
	private String type;
	private int per;
	private int year;
	private int semester;
    
	private List<Coursemarkstrans> coursemarks;

	public Marksunit() {

	}



	public Marksunit(int lessonid, String type, int per, int year, int semester, List<Coursemarkstrans> coursemarks) {
	
		this.lessonid = lessonid;
		this.type = type;
		this.per = per;
		this.year = year;
		this.semester = semester;
		this.coursemarks = coursemarks;
	}



	public int getPer() {
		return per;
	}



	public void setPer(int per) {
		this.per = per;
	}



	public int getLessonid() {
		return lessonid;
	}

	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public List<Coursemarkstrans> getCoursemarks() {
		return coursemarks;
	}

	public void setCoursemarks(List<Coursemarkstrans> coursemarks) {
		this.coursemarks = coursemarks;
	}
	
	
	
}
