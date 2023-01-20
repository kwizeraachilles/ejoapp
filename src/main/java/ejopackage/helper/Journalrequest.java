package ejopackage.helper;

public class Journalrequest {

	private int studentid;
	private int teacherid;
    private String title;
    private String details;
	public Journalrequest() {
	
	}
    
	public Journalrequest(int studentid, int teacherid, String title, String details) {
		super();
		this.studentid = studentid;
		this.teacherid = teacherid;
		this.title = title;
		this.details = details;
	}

	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
 
    
}
