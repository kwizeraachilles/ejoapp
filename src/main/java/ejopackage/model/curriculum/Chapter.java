package ejopackage.model.curriculum;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Chapter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private int number;
   private String name;
   private boolean completed;
   @OneToMany
   private List<Subchapter> subchapters;
public Chapter() {

}



public Chapter(int id, int number, String name, boolean completed, List<Subchapter> subchapters) {

	this.id = id;
	this.number = number;
	this.name = name;
	this.completed = completed;
	this.subchapters = subchapters;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getNumber() {
	return number;
}



public void setNumber(int number) {
	this.number = number;
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

public List<Subchapter> getSubchapters() {
	return subchapters;
}

public void setSubchapters(List<Subchapter> subchapters) {
	this.subchapters = subchapters;
}

   
   
}
