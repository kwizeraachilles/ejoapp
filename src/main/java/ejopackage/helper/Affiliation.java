package ejopackage.helper;

import java.util.List;

public class Affiliation {

	private int  userid;
	 private List<Integer>   studentids;
	private int nuteacherid;
	public Affiliation() {
	
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<Integer> getStudentids() {
		return studentids;
	}
	public void setStudentids(List<Integer> studentids) {
		this.studentids = studentids;
	}
	public int getNuteacherid() {
		return nuteacherid;
	}
	public void setNuteacherid(int nuteacherid) {
		this.nuteacherid = nuteacherid;
	}

	
}
