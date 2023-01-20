package ejopackage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Dailylessonplan {
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private LocalDateTime time;
	private int year;
	private int trimester;
	private String lessontitle;
	private String lessonintroduction;
	private String lessondescription;
	private String lessonexemples;
	private String lessonexercises;
	private String obervation;
	@ManyToOne
	private Teacher teacher;
	@ManyToOne
	private Aclass currentclass;
	
	@ManyToOne
	private Course course;
	public Dailylessonplan() {
			
	}
	public Dailylessonplan(int id, LocalDateTime time, int year, int trimester, String lessontitle,
			String lessonintroduction, String lessondescription, String lessonexemples, String lessonexercises,
			String obervation, Teacher teacher, Aclass currentclass, Course course) {
		this.id = id;
		this.time = time;
		this.year = year;
		this.trimester = trimester;
		this.lessontitle = lessontitle;
		this.lessonintroduction = lessonintroduction;
		this.lessondescription = lessondescription;
		this.lessonexemples = lessonexemples;
		this.lessonexercises = lessonexercises;
		this.obervation = obervation;
		this.teacher = teacher;
		this.currentclass = currentclass;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrimester() {
		return trimester;
	}
	public void setTrimester(int trimester) {
		this.trimester = trimester;
	}
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
	public String getObervation() {
		return obervation;
	}
	public void setObervation(String obervation) {
		this.obervation = obervation;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Aclass getCurrentclass() {
		return currentclass;
	}
	public void setCurrentclass(Aclass currentclass) {
		this.currentclass = currentclass;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}