package ejopackage.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Aclass {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int classid;
	private int level;
	private String session;
	private String classname;
	private int  maxhourz;
	

	
	@ManyToOne
	private Combination schooloption;
	
	
	@OneToMany
	private List<Course> courses;
	
	





	public Aclass(int classid, int level, String session, String classname, int maxperiods, Combination schooloption,
			List<Course> courses) {

		this.classid = classid;
		this.level = level;
		this.session = session;
		this.classname = classname;
		this.schooloption = schooloption;
		this.courses = courses;
		
	}



	public Aclass() {
	
	}
  
	
	
	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Combination getSchooloption() {
		return schooloption;
	}

	public void setSchooloption(Combination school) {
		this.schooloption = school;
	}

	public int getCalssid() {
		return classid;
	}

	public void setCalssid(int calssid) {
		this.classid = calssid;
	}





	public String getSession() {
		return session;
	}



	public void setSession(String section) {
		this.session = section;
	}



	public int getMaxhourz() {
		return maxhourz;
	}



	public void setMaxhourz(int maxhourz) {
		this.maxhourz = maxhourz;
	}





 


  
	
	

	
}
