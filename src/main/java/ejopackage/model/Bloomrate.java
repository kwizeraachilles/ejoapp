package ejopackage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Bloomrate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int bloomrateid;
	@Column(unique=true)
	private String description;
	private double remembering;
	private  double understanding;
	private  double applying;
	private  double analyzing;
	private  double evaluating;
	private  double  creating;
	public Bloomrate(int bloomrateid, String description, double remembering, double understanding, double applying,
			double analyzing, double evaluating, double creating) {
		
		this.bloomrateid = bloomrateid;
		this.description = description;
		this.remembering = remembering;
		this.understanding = understanding;
		this.applying = applying;
		this.analyzing = analyzing;
		this.evaluating = evaluating;
		this.creating = creating;
	}
	public Bloomrate() {
		
	}
	public int getBloomrateid() {
		return bloomrateid;
	}
	public void setBloomrateid(int bloomrateid) {
		this.bloomrateid = bloomrateid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRemembering() {
		return remembering;
	}
	public void setRemembering(double remembering) {
		this.remembering = remembering;
	}
	public double getUnderstanding() {
		return understanding;
	}
	public void setUnderstanding(double understanding) {
		this.understanding = understanding;
	}
	public double getApplying() {
		return applying;
	}
	public void setApplying(double applying) {
		this.applying = applying;
	}
	public double getAnalyzing() {
		return analyzing;
	}
	public void setAnalyzing(double analyzing) {
		this.analyzing = analyzing;
	}
	public double getEvaluating() {
		return evaluating;
	}
	public void setEvaluating(double evaluating) {
		this.evaluating = evaluating;
	}
	public double getCreating() {
		return creating;
	}
	public void setCreating(double creating) {
		this.creating = creating;
	}

	

	


}
