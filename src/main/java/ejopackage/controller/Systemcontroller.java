package ejopackage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ejopackage.helper.Bloomdto;
import ejopackage.helper.CombinationDTO;
import ejopackage.helper.GenericResponse;
import ejopackage.helper.SchoolDTO;
import ejopackage.helper.Tempadminscredentials;
import ejopackage.model.Aclass;
import ejopackage.model.Combinationprototype;
import ejopackage.service.CmsService;
import ejopackage.service.Schoolservice;

@RestController
@CrossOrigin
@RequestMapping("/school/system")
public class Systemcontroller {
     @Autowired
	CmsService  cmsservice;
     
     @Autowired
 	Schoolservice schoolservice;

	@PostMapping("/coursecategory")
	void addCoursecategory(@RequestBody Bloomdto bloomdto)  {
		
		cmsservice.regesterBloomdto(bloomdto);
	}
	

	@PutMapping("/coursecategory")
	void editCoursecategory(@RequestBody Bloomdto bloomdto ,@RequestParam ("coursecategoryid") int coursecategoryid)  {
		
		cmsservice.updateBloomdto(bloomdto, coursecategoryid);
	}
	
	
	//schools

	@PostMapping("/school")
	GenericResponse<Object,Integer> addSchool(@RequestBody SchoolDTO school) {
		return cmsservice.addSchool(school);
		
	}
	
	@PostMapping("/school/logo")
GenericResponse <Object,Integer>attachLogo(@RequestParam int schoolid , @RequestParam  MultipartFile    schoollogo) throws IOException {
	
	return cmsservice.addSchoolLogo(schoolid,schoollogo);
}
     
	//Combinations  
	
	@PostMapping("/combination")
	void addCombination(@RequestBody CombinationDTO combinationdto) {
		 cmsservice.addCombination(combinationdto);
		
	}
	@GetMapping("/combinations")
	List<Combinationprototype> getAllCombinations(){
		
		return  cmsservice.getAllCombinationprotos();
	}
	@GetMapping("/classes")
	List<Aclass>  getAllClasses(){
		
		return schoolservice.getAllClasses();
		
	}
}
