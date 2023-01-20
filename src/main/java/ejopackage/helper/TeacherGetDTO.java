package ejopackage.helper;

import ejopackage.model.Weeklytimetable;

import java.util.List;

import ejopackage.model.Coursetime;

public class TeacherGetDTO {
	private int teacherid;
	private String teacherfirstname;
	private String teacherlastname;
	private String midlename;
	private Weeklytimetable weeklytimetable;
	private List<Coursetime> coursetimes;
	private int maxhourz;
	public TeacherGetDTO() {
	
	}
	
	
   


	public TeacherGetDTO(int teacherid, String teacherfirstname, String teacherlastname, String midlename,
			Weeklytimetable weeklytimetable, List<Coursetime> coursetimes, int maxhourz) {
		this.teacherid = teacherid;
		this.teacherfirstname = teacherfirstname;
		this.teacherlastname = teacherlastname;
		this.midlename = midlename;
		this.weeklytimetable = weeklytimetable;
		this.coursetimes = coursetimes;
		this.maxhourz = maxhourz;
	}





	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	
	public String getMidlename() {
		return midlename;
	}





	public void setMidlename(String midlename) {
		this.midlename = midlename;
	}





	public String getTeacherfirstname() {
		return teacherfirstname;
	}





	public void setTeacherfirstname(String teacherfirstname) {
		this.teacherfirstname = teacherfirstname;
	}





	public String getTeacherlastname() {
		return teacherlastname;
	}





	public void setTeacherlastname(String teacherlastname) {
		this.teacherlastname = teacherlastname;
	}





	public Weeklytimetable getWeeklytimetable() {
		return weeklytimetable;
	}
	public void setWeeklytimetable(Weeklytimetable weeklytimetable) {
		this.weeklytimetable = weeklytimetable;
	}
	public int getMaxhourz() {
		return maxhourz;
	}
	public void setMaxhourz(int maxhourz) {
		this.maxhourz = maxhourz;
	}


	public List<Coursetime> getCoursetimes() {
		return coursetimes;
	}


	public void setCoursetimes(List<Coursetime> coursetimes) {
		this.coursetimes = coursetimes;
	}
	
  
}
