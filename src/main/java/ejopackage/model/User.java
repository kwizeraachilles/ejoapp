package ejopackage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nationalid","username"})})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private String firstname;
	private String lastname;
	private String midlename;
	private String phone;
	private String address;
	 @NonNull
	private String username;
	private String password;
	private String roles;
	private boolean active;
	private LocalDateTime initiated;
	private String updatedby;
	private LocalDateTime updated;


	 @NonNull
 	private String nationalid;

   

	public User(int id, String firstname, String lastname, String midlename, String phone, String address,
			String username, String password, String roles,  LocalDateTime initiated, String updatedby,
			LocalDateTime updated, String nationalid) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.midlename = midlename;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.active = false;
		this.initiated = initiated;
		this.updatedby = updatedby;
		this.updated = updated;
		this.nationalid = nationalid;
	}

	public User() {
	  this.active=false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMidlename() {
		return midlename;
	}

	public void setMidlename(String midlename) {
		this.midlename = midlename;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getNationalid() {
		return nationalid;
	}

	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}

	public LocalDateTime getInitiated() {
		return initiated;
	}

	public void setInitiated(LocalDateTime initiated) {
		this.initiated = initiated;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	
	

}
