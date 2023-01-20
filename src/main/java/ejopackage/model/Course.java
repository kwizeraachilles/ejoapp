package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int courseid;
	private String code;
	private String name;
	private int level;
	private int hourz;
	private int importance;
	@ManyToOne
	private Combination combination;
    @ManyToOne
    private Courseprototype courseprototype;


    



	public Course(int courseid, String code, String name, int level, int hourz, int importance, Combination combination,
			Courseprototype courseprototype) {
		super();
		this.courseid = courseid;
		this.code = code;
		this.name = name;
		this.level = level;
		this.hourz = hourz;
		this.importance = importance;
		this.combination = combination;
		this.courseprototype = courseprototype;
	}



	public Course() {
	
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}


  

	public Courseprototype getCourseprototype() {
		return courseprototype;
	}



	public void setCourseprototype(Courseprototype courseprototype) {
		this.courseprototype = courseprototype;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public int getHourz() {
		return hourz;
	}



	public void setHourz(int hourz) {
		this.hourz = hourz;
	}



	public int getImportance() {
		return importance;
	}



	public void setImportance(int importance) {
		this.importance = importance;
	}



	public Combination getCombination() {
		return combination;
	}



	public void setCombination(Combination combination) {
		this.combination = combination;
	}





	

}
