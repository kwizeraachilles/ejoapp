package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;





@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int teacherid;
    private String qualification;
	private String course;
	private boolean astutor;
	@OneToOne
    private Staff staff;

	
	
	public Teacher() {
	
	}
    
	public Teacher(int teacherid, String qualification, String course, boolean astutor, Staff staff) {

		this.teacherid = teacherid;
		this.qualification = qualification;
		this.course = course;
		this.astutor = astutor;
		this.staff = staff;
	}

	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public boolean isAstutor() {
		return astutor;
	}
	public void setAstutor(boolean astutor) {
		this.astutor = astutor;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	


	
	
	
}
