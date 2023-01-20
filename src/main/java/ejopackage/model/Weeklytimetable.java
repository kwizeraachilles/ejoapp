package ejopackage.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Weeklytimetable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;

    
	@OneToOne
	private Teacher teacher;

	
	public Weeklytimetable(int id, Teacher teacher) {
	
		this.id = id;
		
		this.teacher = teacher;
	}
	public Weeklytimetable() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	
	
	
	
	
}
