package ejopackage.helper;

public class Attendeceinstance {
  private int studentid;
  private int courseid;
  private boolean status;
public Attendeceinstance(int studentid, int courseid, boolean status) {

	this.studentid = studentid;
	this.courseid = courseid;
	this.status = status;
}
public Attendeceinstance() {

}
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
  
  
}
