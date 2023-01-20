package ejopackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ejopackage.helper.Authenticationrequest;
import ejopackage.helper.StaffDTO;
import ejopackage.model.User;
import ejopackage.service.Authservice;

@RestController
public class Home {

	@Autowired
	Authservice systemservice;
	@GetMapping("/")
	String welcome() {
		
		return "\n <html> <h1>  WELCOME  TO  EJO  AFRICA  INITIATIVE  2</h1>  <p>   testing page  </p> ";
		
	}
	
	
	//parent to  Student 
	
	@PostMapping("/authentication")
	@CrossOrigin
	User getUserEntity(@RequestBody Authenticationrequest authReq) {
		
		return  systemservice.getTheUser(authReq);
	}
	@PostMapping("/authentication/staff")
	@CrossOrigin
	StaffDTO getStaffEntity(@RequestBody Authenticationrequest authReq) {
		
		return  systemservice.getTheUserStaff(authReq);
	}
	
	/*
	@GetMapping("/authentication")
	@CrossOrigin
	User getUser(@RequestParam ("username") String username,@RequestParam ("password") String password) {
		 Authenticationrequest  authenticationRequest=new Authenticationrequest(username,password);
		return systemservice.getTheUser(authenticationRequest);
	}
	*/
}
