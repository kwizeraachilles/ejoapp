package ejopackage.helper;

public class Monitordata {

	private float average;
	private float attendancerate;
	public Monitordata() {
		
	}
	
	public Monitordata(float average, float attendancerate) {
		this.average = average;
		this.attendancerate = attendancerate;
	}

	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public float getAttendancerate() {
		return attendancerate;
	}
	public void setAttendancerate(float attendancerate) {
		this.attendancerate = attendancerate;
	}
	

}
