package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Coursemarks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int coursemarksid;
	private float onecw;
	private float oneex;
	private float twocw;
	private float twoex;
	private float threecw;
	private float threeex;
	@ManyToOne
	private Student student;
	@OneToOne
	private Course course;
	public Coursemarks(int coursemarksid, float onecw, float oneex, float twocw, float twoex, float threecw,
			float threeex, Student student, Course course) {
	
		this.coursemarksid = coursemarksid;
		this.onecw = onecw;
		this.oneex = oneex;
		this.twocw = twocw;
		this.twoex = twoex;
		this.threecw = threecw;
		this.threeex = threeex;
		this.student = student;
		this.course = course;
	}
	public Coursemarks() {	}
	public int getCoursemarksid() {
		return coursemarksid;
	}
	public void setCoursemarksid(int coursemarksid) {
		this.coursemarksid = coursemarksid;
	}
	public float getOnecw() {
		return onecw;
	}
	public void setOnecw(float onecw) {
		this.onecw = onecw;
	}
	public float getOneex() {
		return oneex;
	}
	public void setOneex(float oneex) {
		this.oneex = oneex;
	}
	public float getOnetot() {
		
		return onecw+oneex;
	}
	public float getTwocw() {
		return twocw;
	}
	public void setTwocw(float twocw) {
		this.twocw = twocw;
	}
	public float getTwoex() {
		return twoex;
	}
	public void setTwoex(float twoex) {
		this.twoex = twoex;
	}
	public float getTwotot() {
		
		return twocw+twoex;
	}
	public float getThreecw() {
		return threecw;
	}
	public void setThreecw(float threecw) {
		this.threecw = threecw;
	}
	public float getThreeex() {
		return threeex;
	}
	public void setThreeex(float threeex) {
		this.threeex = threeex;
	}
	
	public float getThreetot() {
		
		return threecw+threeex;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public float getAnuualtot() {
		
		return (onecw+oneex+twocw+twoex+threecw+threeex)/3;
	}

}
