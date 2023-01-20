package ejopackage.model.timetable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Courseunit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private int level;
	private int optionid;
	private int courseid;
	private int hourz;
	private int priority;
	public Courseunit(int id, int level, int optionid, int courseid, int hourz, int priority) {
	
		this.id = id;
		this.level = level;
		this.optionid = optionid;
		this.courseid = courseid;
		this.hourz = hourz;
		this.priority = priority;
	}
	public Courseunit() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getOptionid() {
		return optionid;
	}
	public void setOptionid(int optionid) {
		this.optionid = optionid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getHourz() {
		return hourz;
	}
	public void setHourz(int hourz) {
		this.hourz = hourz;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	

}
