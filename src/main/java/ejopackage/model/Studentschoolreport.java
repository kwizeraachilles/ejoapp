package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Studentschoolreport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private String title;
	private String details;
    
	@ManyToOne
	private Student student;

	public Studentschoolreport(int id, String title, String details, Student student) {
		
		this.id = id;
		this.title = title;
		this.details = details;
		this.student = student;
	}

	public Studentschoolreport() {
	
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
