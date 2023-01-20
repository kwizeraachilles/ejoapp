package ejopackage.helper;

public class AUser {

	private String firstname;
	private String lastname;
	private String midlename;
	private String phone;
	private String nationalid;
	private String username;
	private String password;

	public AUser() {
	
	}
	

	public AUser(String firstname, String lastname, String midlename, String phone, String nationalid, String username,
			String password) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.midlename = midlename;
		this.phone = phone;
		this.nationalid = nationalid;
		this.username = username;
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMidlename() {
		return midlename;
	}

	public void setMidlename(String midlename) {
		this.midlename = midlename;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNationalid() {
		return nationalid;
	}

	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
