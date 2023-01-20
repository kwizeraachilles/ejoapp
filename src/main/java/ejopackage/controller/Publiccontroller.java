package ejopackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejopackage.helper.AUser;
import ejopackage.model.Student;
import ejopackage.service.Schoolservice;

@CrossOrigin
@RestController
@RequestMapping("/public")
public class Publiccontroller {
	@Autowired
	Schoolservice schoolservice;
	
	@PostMapping("/user")
    void register (@RequestBody AUser auser) {
		schoolservice.registerUser(auser);
	}
	
	@GetMapping("/user/students")
   List<Student> getAfficliatesstudents (String nid) {
		return schoolservice.getAffStudents(nid);
	}
   
}
