package ejopackage.model.sytem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Systemstaff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private String firstname;
	private String lastname;
	private String midlename;
    private String nid;
    private String phones;
    private String email;
    private String address;
	private String title;
	private String username;
	private String password;
	private String role;
	@ManyToOne
	private Systemmanager system;
	public Systemstaff(int id, String firstname, String lastname, String midlename, String nid, String phones,
			String email, String address, String title, String username, String password, String role, Systemmanager system) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.midlename = midlename;
		this.nid = nid;
		this.phones = phones;
		this.email = email;
		this.address = address;
		this.title = title;
		this.username = username;
		this.password = password;
		this.role = role;
		this.system = system;
	}
	public Systemstaff() {
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
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Systemmanager getSystem() {
		return system;
	}
	public void setSystem(Systemmanager system) {
		this.system = system;
	}
	
	
	
	

}
