package ejopackage.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bulletinprototype {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id;
	private int level;
	private double mandatorypermarks;
	private double mainpermarks;
	private double optionalpermarks;
	private boolean signed;
	private double per;
	private LocalDateTime updated;
	private LocalDateTime signdate;
	

	
	@OneToMany
	private List<Coursebulletinprototype>  coursebulletinprototypes;



	public Bulletinprototype() {
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public double getMandatorypermarks() {
		return mandatorypermarks;
	}



	public void setMandatorypermarks(double mandatorypermarks) {
		this.mandatorypermarks = mandatorypermarks;
	}



	public double getMainpermarks() {
		return mainpermarks;
	}



	public void setMainpermarks(double mainpermarks) {
		this.mainpermarks = mainpermarks;
	}



	public double getOptionalpermarks() {
		return optionalpermarks;
	}



	public void setOptionalpermarks(double optionalpermarks) {
		this.optionalpermarks = optionalpermarks;
	}



	public boolean isSigned() {
		return signed;
	}



	public void setSigned(boolean signed) {
		this.signed = signed;
	}



	public LocalDateTime getUpdated() {
		return updated;
	}



	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}



	public LocalDateTime getSigndate() {
		return signdate;
	}



	public void setSigndate(LocalDateTime signdate) {
		this.signdate = signdate;
	}



	public List<Coursebulletinprototype> getCoursebulletinprototypes() {
		return coursebulletinprototypes;
	}



	public void setCoursebulletinprototypes(List<Coursebulletinprototype> coursebulletinprototypes) {
		this.coursebulletinprototypes = coursebulletinprototypes;
	}



	public double getPer() {
		return per;
	}



	public void setPer(double per) {
		this.per = per;
	}
	
	

	

}
