package ejopackage.helper;

public class Dailyplan {
	
	private String lessontitle;
	private String lessonintroduction;
	private String lessondescription;
	private String lessonexemples;
	private String lessonexercises;
	private String observation;

	private int teacherid;

	private int currentclassid;
	
	private int courseid;

	public Dailyplan() {	}

	public String getLessontitle() {
		return lessontitle;
	}

	public void setLessontitle(String lessontitle) {
		this.lessontitle = lessontitle;
	}

	public String getLessonintroduction() {
		return lessonintroduction;
	}

	public void setLessonintroduction(String lessonintroduction) {
		this.lessonintroduction = lessonintroduction;
	}

	public String getLessondescription() {
		return lessondescription;
	}

	public void setLessondescription(String lessondescription) {
		this.lessondescription = lessondescription;
	}

	public String getLessonexemples() {
		return lessonexemples;
	}

	public void setLessonexemples(String lessonexemples) {
		this.lessonexemples = lessonexemples;
	}

	public String getLessonexercises() {
		return lessonexercises;
	}

	public void setLessonexercises(String lessonexercises) {
		this.lessonexercises = lessonexercises;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public int getCurrentclassid() {
		return currentclassid;
	}

	public void setCurrentclassid(int currentclassid) {
		this.currentclassid = currentclassid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	
	

}