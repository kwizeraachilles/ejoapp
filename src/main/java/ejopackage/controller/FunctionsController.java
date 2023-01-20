package ejopackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejopackage.model.timetable.Courseunit;
import ejopackage.service.FunctionsService;

@RestController
@RequestMapping("/functions")
public class FunctionsController {

	@Autowired
	FunctionsService functionservice;
	@PostMapping("/courseunit")
	void addCourseunit(@RequestBody Courseunit courseunit)
	{
		functionservice.addCourseunit(courseunit);
	}
	
	@GetMapping("/courseunits")
	List<Courseunit>  getCourseUnit(){
		return functionservice.getCourseunites();
	}
}
