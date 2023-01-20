package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Courseprototype {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int    id;
	private String code;
	private String name;
	private int hourz;
	private int importance;
    @ManyToOne
    private Coursecategory coursecategory;
    @ManyToOne
    private Levelprototype levelprototype;

	public Courseprototype() {	
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Coursecategory getCoursecategory() {
		return coursecategory;
	}

	public void setCoursecategory(Coursecategory coursecategory) {
		this.coursecategory = coursecategory;
	}

	public Levelprototype getLevelprototype() {
		return levelprototype;
	}

	public void setLevelprototype(Levelprototype levelprototype) {
		this.levelprototype = levelprototype;
	}
	

}
