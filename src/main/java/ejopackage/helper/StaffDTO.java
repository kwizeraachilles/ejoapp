package ejopackage.helper;

public class StaffDTO {
     public  String fname;
     public  String lname;
     public String schoolname;
     public String schooladdress;
     public String schoolcontact;
     public String schoolwebsite;
     public String roles;
     
     public int schoolid;
     public int userid;
	public StaffDTO() {
			}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getSchooladdress() {
		return schooladdress;
	}
	public void setSchooladdress(String schooladdress) {
		this.schooladdress = schooladdress;
	}
	public String getSchoolcontact() {
		return schoolcontact;
	}
	public void setSchoolcontact(String schoolcontact) {
		this.schoolcontact = schoolcontact;
	}
	public String getSchoolwebsite() {
		return schoolwebsite;
	}
	public void setSchoolwebsite(String schoolwebsite) {
		this.schoolwebsite = schoolwebsite;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	

	
	
}
