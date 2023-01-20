package ejopackage.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private boolean checked; 
	private boolean attended;
	private LocalDate date;
	@ManyToOne
	private Course course;
	@OneToOne 
	private Student student;

	public Attendance(int id, boolean attended, LocalDate date, Student student) {
	
		this.id = id;
		this.checked=false;
		this.attended = attended;
		this.date=LocalDate.now();
		this.student = student;
	}

	public Attendance() {
    this.checked=false;		
	this.date=LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student fetchStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
