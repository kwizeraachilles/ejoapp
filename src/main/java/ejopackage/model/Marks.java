package ejopackage.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Marks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private double score;
	private String type;
	private LocalDate date;
	private int year;
	private int period;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Student student;


   

	public Marks(int id, double score, String type, LocalDate date, int year, int period, Course course,
			Student student) {
		
		this.id = id;
		this.score = score;
		this.type = type;
		this.date = date;
		this.year = year;
		this.period = period;
		this.course = course;
		this.student = student;
	}

	public Marks() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

  

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}



	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
}
