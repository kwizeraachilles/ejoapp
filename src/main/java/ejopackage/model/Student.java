package ejopackage.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Student {


@Id
@GeneratedValue(strategy=GenerationType.AUTO)		
private int id;
private String firstname;
private String lastname;
private String midlename;
private String gender;
private LocalDate birthdate;
private String guadianonenames;
private String guidianonenid;
private String guidianonecontact;
private String guadiantwonenames;
private String guidiantwonid;
private String guidiantwocontact;
private LocalDateTime registered;
private LocalDateTime updated;
@OneToOne
private Bloommetrics bloommetrics;
@ManyToOne
private Parent parent;
@ManyToOne 
private Aclass studentclass;



public Student(int id, String firstname, String lastname, String midlename, String gender, LocalDate birthdate,
		String guadianonenames, String guidianonenid, String guidianonecontact, LocalDateTime registered,
		LocalDateTime updated, Bloommetrics bloommetrics, Parent parent, Aclass studentclass) {

	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.midlename = midlename;
	this.gender = gender;
	this.birthdate = birthdate;
	this.guadianonenames = guadianonenames;
	this.guidianonenid = guidianonenid;
	this.guidianonecontact = guidianonecontact;
	this.registered = registered;
	this.updated = updated;
	this.bloommetrics = bloommetrics;
	this.parent = parent;
	this.studentclass = studentclass;
}
public Student() {

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

public LocalDate getBirthdate() {
	return birthdate;
}
public void setBirthdate(LocalDate birthdate) {
	this.birthdate = birthdate;
}
public Parent getParent() {
	return parent;
}
public void setParent(Parent parent) {
	this.parent = parent;
}
public Aclass fetchclass() {
	return studentclass;
}
public void setStudentclass(Aclass studentclass) {
	this.studentclass = studentclass;
}

public Aclass getStudentclass() {
	return studentclass;
}

public Bloommetrics getBloommetrics() {
	return bloommetrics;
}
public void setBloommetrics(Bloommetrics bloommetrics) {
	this.bloommetrics = bloommetrics;
}
public String getGuadianonenames() {
	return guadianonenames;
}
public void setGuadianonenames(String guadianonenames) {
	this.guadianonenames = guadianonenames;
}
public String getGuidianonenid() {
	return guidianonenid;
}
public void setGuidianonenid(String guidianonenid) {
	this.guidianonenid = guidianonenid;
}
public String getGuidianonecontact() {
	return guidianonecontact;
}
public void setGuidianonecontact(String guidianonecontact) {
	this.guidianonecontact = guidianonecontact;
}
public LocalDateTime getRegistered() {
	return registered;
}
public void setRegistered(LocalDateTime registered) {
	this.registered = registered;
}
public LocalDateTime getUpdated() {
	return updated;
}
public void setUpdated(LocalDateTime updated) {
	this.updated = updated;
}
public String getGuadiantwonenames() {
	return guadiantwonenames;
}
public void setGuadiantwonenames(String guadiantwonenames) {
	this.guadiantwonenames = guadiantwonenames;
}
public String getGuidiantwonid() {
	return guidiantwonid;
}
public void setGuidiantwonid(String guidiantwonid) {
	this.guidiantwonid = guidiantwonid;
}
public String getGuidiantwocontact() {
	return guidiantwocontact;
}
public void setGuidiantwocontact(String guidiantwocontact) {
	this.guidiantwocontact = guidiantwocontact;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}




}
