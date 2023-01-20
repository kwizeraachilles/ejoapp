package ejopackage.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Studentnotification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private String title;
	private LocalDate date;
	private String details;
	@ManyToOne
	private  Student student;
	public Studentnotification(int id, String title, String details, Student student) {
	
		this.id = id;
		this.date=LocalDate.now();
		this.title = title;
		this.details = details;
		this.student = student;
	}
	public Studentnotification() {
		this.date=LocalDate.now();
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
	
	
	
	

}
