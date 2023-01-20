package ejopackage.model.curriculum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Title {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
   private String name;
   private boolean completed;

public Title() {

}
public Title(int id, String name, boolean completed) {

	this.id = id;
	this.name = name;
	this.completed = completed;
	
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

   


}
