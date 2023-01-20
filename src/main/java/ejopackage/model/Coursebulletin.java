package ejopackage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Coursebulletin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id;
	private int courseid;
	private String coursename;
	private int importance;
	private double onecw;
	private double oneex;
	private double onetot;
	private double twocw;
	private double twoex;
	private double twotot;
	private double threecw;
	private double threeex;
	private double threetot;
	private double annual;
    private LocalDateTime updated;
    
    @ManyToOne
    private Student  student;

	public Coursebulletin() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public double getOnecw() {
		return onecw;
	}

	public void setOnecw(double onecw) {
		this.onecw = onecw;
	}

	public double getOneex() {
		return oneex;
	}

	public void setOneex(double oneex) {
		this.oneex = oneex;
	}

	public double getOnetot() {
		return onetot;
	}

	public void setOnetot(double onetot) {
		this.onetot = onetot;
	}

	public double getTwocw() {
		return twocw;
	}

	public void setTwocw(double twocw) {
		this.twocw = twocw;
	}

	public double getTwoex() {
		return twoex;
	}

	public void setTwoex(double twoex) {
		this.twoex = twoex;
	}

	public double getTwotot() {
		return twotot;
	}

	public void setTwotot(double twotot) {
		this.twotot = twotot;
	}

	public double getThreecw() {
		return threecw;
	}

	public void setThreecw(double threecw) {
		this.threecw = threecw;
	}

	public double getThreeex() {
		return threeex;
	}

	public void setThreeex(double threeex) {
		this.threeex = threeex;
	}

	public double getThreetot() {
		return threetot;
	}

	public void setThreetot(double threetot) {
		this.threetot = threetot;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public double getAnnual() {
		return annual;
	}

	public void setAnnual(double annual) {
		this.annual = annual;
	}
	

}
