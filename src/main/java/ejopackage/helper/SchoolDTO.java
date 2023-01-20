package ejopackage.helper;

import java.util.List;

public class SchoolDTO {

	
	private String name;
	private String address;
	private String website;
	private String contact;
	private String email;
	private String systemaccountname;
	private List<Combid> combinationsids;

	public SchoolDTO() {
	
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

	public String getSystemaccountname() {
		return systemaccountname;
	}

	public void setSystemaccountname(String systemaccountname) {
		this.systemaccountname = systemaccountname;
	}

	public List<Combid> getCombinationsids() {
		return combinationsids;
	}

	public void setCombinationsids(List<Combid> combinationsinds) {
		this.combinationsids = combinationsinds;
	}
	
	

}
