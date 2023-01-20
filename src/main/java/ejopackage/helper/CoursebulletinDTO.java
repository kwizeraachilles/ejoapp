package ejopackage.helper;

import java.time.LocalDateTime;

public class CoursebulletinDTO {

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
	public CoursebulletinDTO() {
		
	}
	public CoursebulletinDTO(int courseid, String coursename, int importance, double onecw, double oneex, double onetot,
			double twocw, double twoex, double twotot, double threecw, double threeex, double threetot,double annual,
			LocalDateTime updated) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.importance = importance;
		this.onecw = onecw;
		this.oneex = oneex;
		this.onetot = onetot;
		this.twocw = twocw;
		this.twoex = twoex;
		this.twotot = twotot;
		this.threecw = threecw;
		this.threeex = threeex;
		this.threetot = threetot;
		this.annual=annual;
		this.updated = updated;
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
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
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
	public double getAnnual() {
		return annual;
	}
	public void setAnnual(double annual) {
		this.annual = annual;
	}
	
	

}
