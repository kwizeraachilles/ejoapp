package ejopackage.helper;

import java.time.LocalTime;



public class Acoursetime {
	
	
	private int timetableid;
	private int lessonid;
	private int  classid;
    private int dayindex;
	private String weekday;
	private LocalTime time;
	public Acoursetime(int timetableid, int lessonid, int classid, int dayindex, String weekday, LocalTime time) {
		
		this.timetableid = timetableid;
		this.lessonid = lessonid;
		this.classid = classid;
		this.dayindex = dayindex;
		this.weekday = weekday;
		this.time = time;
	}
	public Acoursetime() {
		
	}
	public int getTimetableid() {
		return timetableid;
	}
	public void setTimetableid(int timetableid) {
		this.timetableid = timetableid;
	}
	public int getLessonid() {
		return lessonid;
	}
	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getDayindex() {
		return dayindex;
	}
	public void setDayindex(int dayindex) {
		this.dayindex = dayindex;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	
	
	
}
