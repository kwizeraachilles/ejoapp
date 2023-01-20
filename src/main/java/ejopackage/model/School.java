package ejopackage.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ejopackage.model.sytem.Systemmanager;

@Entity
public class School {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private String name;
	private String address;
	private String website;
	private String contact;
	private String email;
	private String systemaccountname;
	private String systempassword;
	private String sytemcode;
	private boolean active;
	private LocalDateTime  created;
	private LocalDateTime updated;
	@Column(name = "logo", length = 1000000)
	private byte[] logo;
	
	
	@OneToOne
    private  Schoolcalender  schoolcalender;
	
	@OneToOne
	private Dos dos;
	@OneToOne
	private Registrar registrar;
   @ManyToOne
   private Systemmanager  systemmanager;
	public School() {
	this.active=false;
	}

	public School(int id, String name, String address, String website, String contact, String email,
			String systemaccountname, String systempassword, String sytemcode, Schoolcalender schoolcalender,
			Systemmanager systemmanager) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.website = website;
		this.contact = contact;
		this.email = email;
		this.systemaccountname = systemaccountname;
		this.systempassword = systempassword;
		this.sytemcode = sytemcode;
		this.schoolcalender = schoolcalender;
		this.systemmanager = systemmanager;
		this.active=false;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Schoolcalender getSchoolcalender() {
		return schoolcalender;
	}


	public void setSchoolcalender(Schoolcalender schoolcalender) {
		this.schoolcalender = schoolcalender;
	}






	public String getSystemaccountname() {
		return systemaccountname;
	}

	public void setSystemaccountname(String systemaccountname) {
		this.systemaccountname = systemaccountname;
	}

	public String getSystempassword() {
		return systempassword;
	}

	public void setSystempassword(String systempassword) {
		this.systempassword = systempassword;
	}

	public String getSytemcode() {
		return sytemcode;
	}

	public void setSytemcode(String sytemcode) {
		this.sytemcode = sytemcode;
	}

	public Systemmanager getSystemmanager() {
		return systemmanager;
	}

	public void setSystemmanager(Systemmanager systemmanager) {
		this.systemmanager = systemmanager;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Dos getDos() {
		return dos;
	}

	public void setDos(Dos dos) {
		this.dos = dos;
	}

	public Registrar getRegistrar() {
		return registrar;
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	
	

}
