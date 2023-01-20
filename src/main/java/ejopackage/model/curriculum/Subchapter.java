package ejopackage.model.curriculum;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subchapter {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
   private String name;
   private boolean completed;
   @OneToMany
   private List<Title> titles;
public Subchapter() {

}



public Subchapter(int id, String name, boolean completed, List<Title> titles) {

	this.id = id;
	this.name = name;
	this.completed = completed;
	this.titles = titles;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public boolean isCompleted() {
	return completed;
}
public void setCompleted(boolean completed) {
	this.completed = completed;
}



public List<Title> getTitles() {
	return titles;
}



public void setTitles(List<Title> titles) {
	this.titles = titles;
}

   

}
