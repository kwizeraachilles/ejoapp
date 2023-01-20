package ejopackage.helper;

import java.util.List;

public class Levelcomplete {
	private int id;
	private int level;
	private List<Coursecomplete>  levelcourses;
	public Levelcomplete() {
	
		
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
	public List<Coursecomplete> getLevelcourses() {
		return levelcourses;
	}
	public void setLevelcourses(List<Coursecomplete> levelcourses) {
		this.levelcourses = levelcourses;
	}
	
	

}
