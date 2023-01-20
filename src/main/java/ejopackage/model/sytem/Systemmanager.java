package ejopackage.model.sytem;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ejopackage.model.School;

@Entity
public class Systemmanager {
	  @Id
	  private String  smid;
	   private String educationsytem;
	 



	public Systemmanager(String smid, String educationsytem) {
	
		this.smid = smid;
		this.educationsytem = educationsytem;
	}

	public Systemmanager() {

	}

	public String getEducationsytem() {
		return educationsytem;
	}

	public void setEducationsytem(String educationsytem) {
		this.educationsytem = educationsytem;
	}

	public String getSmid() {
		return smid;
	}

	public void setSmid(String smid) {
		this.smid = smid;
	}



	
	  
	  
	  

}
