package ejopackage.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ejopackage.helper.Days;



@Entity
public class Coursetime {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int coursetimeid;
	
	  private LocalTime time;
	   private int dayindex;
	   @Enumerated(EnumType.STRING)
	   private Days weekday;
	   @ManyToOne
	   private Course course;
	   @OneToOne
	   private Aclass currentclass;
	   
	   @ManyToOne
	   private Weeklytimetable weeklytimetable;
     
     


	public Coursetime(int coursetimeid, LocalTime time, int dayindex, Days weekday, Course course, Aclass currentclass,
			Weeklytimetable weeklytimetable) {

		this.coursetimeid = coursetimeid;
		this.time = time;
		this.dayindex = dayindex;
		this.weekday = weekday;
		this.course = course;
		this.currentclass = currentclass;
		this.weeklytimetable = weeklytimetable;
	}
	
	public Coursetime( int dayindex, Days weekday, Course course, Aclass currentclass) {


		this.dayindex = dayindex;
		this.weekday = weekday;
		this.course = course;
		this.currentclass = currentclass;
	
	}

	public Coursetime() {
	}

	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}



	public Days getWeekday() {
		return weekday;
	}

	public void setWeekday(Days weekday) {
		this.weekday = weekday;
	}

	public int getDayindex() {
		return dayindex;
	}

	public void setDayindex(int dayindex) {
		this.dayindex = dayindex;
	}
    


	public Aclass getCurrentclass() {
	  return currentclass;
	 }

	public void setCurrentclass(Aclass currentclass) {
		this.currentclass = currentclass;
	}

   
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getCoursetimeid() {
		return coursetimeid;
	}

	public void setCoursetimeid(int cooursetimeid) {
		this.coursetimeid = cooursetimeid;
	}

	public Weeklytimetable getWeeklytimetable() {
		return weeklytimetable;
	}

	public void setWeeklytimetable(Weeklytimetable weeklytimetable) {
		this.weeklytimetable = weeklytimetable;
	}
	   
	
	   
	   
}
