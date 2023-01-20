package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Director {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	@ManyToOne
     private User user;
	private String qualification;
	private String direction;

	
	@ManyToOne
	private School school;


	public Director(int id, User user, String qualification, String direction, School school) {
		
		this.id = id;
		this.user = user;
		this.qualification = qualification;
		this.direction = direction;
		this.school = school;
	}


	public Director() {
		}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}
    
	


}
