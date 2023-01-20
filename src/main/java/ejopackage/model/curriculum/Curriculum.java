package ejopackage.model.curriculum;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curriculum {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private boolean completed;
	private String name;
	@OneToMany
	private List<Chapter> chapters;
	public Curriculum() {
	
	}
	

	public Curriculum(int id, boolean completed, String name, List<Chapter> chapters) {
	
		this.id = id;
		this.completed = completed;
		this.name = name;
		this.chapters = chapters;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public List<Chapter> getChapters() {
		return chapters;
	}


	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	
	
	
	

}
