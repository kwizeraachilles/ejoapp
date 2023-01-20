package ejopackage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ejopackage.model.sytem.Systemmanager;
@Entity
public class Coursecategory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	@Column(unique=true)
	private String name;
	@OneToOne
    private Bloomrate  bloomrate;
	@ManyToOne
	Systemmanager  systemmanager;

	public Coursecategory(int coursecategoryid, String name, Bloomrate bloomrate, Systemmanager systemmanager) {
	
		this.id = coursecategoryid;
		this.name = name;
		this.bloomrate = bloomrate;
		this.systemmanager = systemmanager;
	}
	public Coursecategory() {

	}
	public int getId() {
		return id;
	}
	public void setId(int coursecategoryid) {
		this.id = coursecategoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bloomrate getBloomrate() {
		return bloomrate;
	}
	public void setBloomrate(Bloomrate bloomrate) {
		this.bloomrate = bloomrate;
	}
	public Systemmanager getSystemmanager() {
		return systemmanager;
	}
	public void setSystemmanager(Systemmanager systemmanager) {
		this.systemmanager = systemmanager;
	}
	
	
	
}
