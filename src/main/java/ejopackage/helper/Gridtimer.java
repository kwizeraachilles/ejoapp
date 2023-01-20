package ejopackage.helper;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import ejopackage.model.Course;

public class Gridtimer {
    private int dayindex;
    @Enumerated(EnumType.STRING)
	   private Days weekday;
         private Course course;
	public Gridtimer() {
	}
	
   
	public Gridtimer(int dayindex, Days weekday, Course course) {
	
		this.dayindex = dayindex;
		this.weekday = weekday;
		this.course = course;
	}

	public int getDayindex() {
		return dayindex;
	}

	public void setDayindex(int dayindex) {
		this.dayindex = dayindex;
	}

	public Days getWeekday() {
		return weekday;
	}
	public void setWeekday(Days weekday) {
		this.weekday = weekday;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	

}
