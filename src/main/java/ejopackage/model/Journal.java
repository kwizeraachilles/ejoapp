package ejopackage.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Journal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private String title;
	private LocalDate date;
	private String details;
	private boolean viewed;
	@ManyToOne 
	 private Teacher teacher;
	
	@ManyToOne
	private Student student;

	public Journal(int id, String title, LocalDate date, String details, Student student) {
	
		this.id = id;
		this.title = title;
	this.date=LocalDate.now();
		this.details = details;
		this.student = student;
		this.viewed=false;
	}

	public Journal() {
     this.date=LocalDate.now();
     this.viewed=false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Student fetchStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	
	
	
	
}
