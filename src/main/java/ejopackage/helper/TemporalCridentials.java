package ejopackage.helper;

public class TemporalCridentials {
	private String username;
	private String password;
	
	
	public TemporalCridentials(String username, String passowrd) {
	
		this.username = username;
		this.password = passowrd;
	}
	public TemporalCridentials() {

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
	public void setPassword(String passowrd) {
		this.password = passowrd;
	}
	
	

}
