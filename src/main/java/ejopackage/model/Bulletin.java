package ejopackage.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Bulletin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id;
	private int level;
	private double mandatorypermarks;
	private double mainpermarks;
	private double optionalpermarks;
	private boolean signed;
	private  String classinfo;
	private int classid;
	private String combiantioninfo;
	private LocalDateTime updated;
	private LocalDateTime signdate;
	private double per;
	private double onetotcw;
	private double twototcw;
	private double threetotcw;
	private double onetotex;
	private double twototex;
	private double threetotex;


	

	
	@OneToMany
	private List<Coursebulletin>  coursebulletins;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	School school;
	
	public Bulletin() {
	  this.setSigned(false);
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
     
	public List<Coursebulletin> getCoursebulletins() {
		return coursebulletins;
	}
	public void setCoursebulletins(List<Coursebulletin> coursebulletins) {
		this.coursebulletins = coursebulletins;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getClassinfo() {
		return classinfo;
	}
	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}
	public String getCombiantioninfo() {
		return combiantioninfo;
	}
	public void setCombiantioninfo(String combiantioninfo) {
		this.combiantioninfo = combiantioninfo;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public double getOnetotcw() {
		return onetotcw;
	}
	public void setOnetotcw(double onetotcw) {
		this.onetotcw = onetotcw;
	}
	public double getTwototcw() {
		return twototcw;
	}
	public void setTwototcw(double twototcw) {
		this.twototcw = twototcw;
	}
	public double getThreetotcw() {
		return threetotcw;
	}
	public void setThreetotcw(double threetotcw) {
		this.threetotcw = threetotcw;
	}
	public double getOnetotex() {
		return onetotex;
	}
	public void setOnetotex(double onetotex) {
		this.onetotex = onetotex;
	}
	public double getTwototex() {
		return twototex;
	}
	public void setTwototex(double twototex) {
		this.twototex = twototex;
	}
	public double getThreetotex() {
		return threetotex;
	}
	public void setThreetotex(double threetotex) {
		this.threetotex = threetotex;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
    
	
}
