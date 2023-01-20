package ejopackage.model.sytem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeneralSettings {
	@Id
	private String id="singeltonin";
  private   int  maxhours;
 
 private static  GeneralSettings generalSettings;
	private  GeneralSettings() {}
	 

	public  static GeneralSettings  getGeneralSetting() {
		if(generalSettings!=null) {
			 generalSettings=new GeneralSettings();
		}
		return generalSettings;
	}



   
	public String getId() {
		return id;
	}





	public void setMaxhours(int maxhours) {
		this.maxhours = maxhours;
	}


	public   int  getMaxhours() {
		
		return maxhours;
	}
	

}

