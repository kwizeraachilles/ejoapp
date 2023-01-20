package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Bloomindex {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private double rememberingindex;
	private double understandingindex;
	private double applyingindex;
	private double analyzingindex;
	private double evaluatingindex;
	private double creatingindex;
	public Bloomindex() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	public double getRememberingindex() {
		return rememberingindex;
	}
	public void setRememberingindex(double rememberingindex) {
		this.rememberingindex = rememberingindex;
	}
	public double getUnderstandingindex() {
		return understandingindex;
	}
	public void setUnderstandingindex(double understandingindex) {
		this.understandingindex = understandingindex;
	}
	public double getApplyingindex() {
		return applyingindex;
	}
	public void setApplyingindex(double applyingindex) {
		this.applyingindex = applyingindex;
	}
	public double getAnalyzingindex() {
		return analyzingindex;
	}
	public void setAnalyzingindex(double analyzingindex) {
		this.analyzingindex = analyzingindex;
	}
	public double getEvaluatingindex() {
		return evaluatingindex;
	}
	public void setEvaluatingindex(double evaluatingindex) {
		this.evaluatingindex = evaluatingindex;
	}
	public double getCreatingindex() {
		return creatingindex;
	}
	public void setCreatingindex(double creatingindex) {
		this.creatingindex = creatingindex;
	}
	public double getProof() {
		return  rememberingindex + understandingindex + applyingindex + analyzingindex + evaluatingindex + creatingindex;
	}

}
