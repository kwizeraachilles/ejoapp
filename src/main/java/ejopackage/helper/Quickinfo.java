package ejopackage.helper;

public class Quickinfo {
	
	   private int journals;
	   private int  attendances;
	   private int  reports;
	public Quickinfo() {
	
	}
	public Quickinfo(int journals, int attendances, int reports) {
		super();
		this.journals = journals;
		this.attendances = attendances;
		this.reports = reports;
	}
	public int getJournals() {
		return journals;
	}
	public void setJournals(int journals) {
		this.journals = journals;
	}
	public int getAttendances() {
		return attendances;
	}
	public void setAttendances(int attendances) {
		this.attendances = attendances;
	}
	public int getReports() {
		return reports;
	}
	public void setReports(int reports) {
		this.reports = reports;
	}
	   
	   
	
}
