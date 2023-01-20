package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Bloommetrics {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private double remembering;
	private double understanding;
	private double applying;
	private double analyzing;

	private double evaluating;
	private double  creating;
	
	
	
	public Bloommetrics(int id, double remembering, double understanding, double applying, double analyzing,
			double evaluating, double creating) {
	
		this.id = id;
		this.remembering = remembering;
		this.understanding = understanding;
		this.applying = applying;
		this.analyzing = analyzing;
		this.evaluating = evaluating;
		this.creating = creating;
	}
	



	public Bloommetrics() {
	
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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




	public double getSumming() {
		return remembering+understanding+applying+analyzing+evaluating+creating;
	}
	
	
}
