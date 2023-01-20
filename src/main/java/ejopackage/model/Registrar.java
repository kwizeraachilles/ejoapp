package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Registrar {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	@OneToOne
	User user;
	public Registrar() {
	}
	public Registrar(int id, User user) {
	
		this.id = id;
		this.user = user;
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
	
	

}
