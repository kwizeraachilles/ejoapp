package ejopackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejopackage.helper.Quickinfo;
import ejopackage.model.Attendance;
import ejopackage.model.Journal;
import ejopackage.model.Marks;
import ejopackage.model.Student;
import ejopackage.model.Studentnotification;
import ejopackage.model.Studentschoolreport;
import ejopackage.service.Courseservice;
import ejopackage.service.Schoolservice;



@RestController
@CrossOrigin
@RequestMapping("/parent")
public class parentendpiont {
	
	@Autowired
	Schoolservice schoolservice;
	
	
	@Autowired
	Courseservice  courseservice;
	
	
	@GetMapping("/")
	String  welcome(){
		
		return  " \n Welcome  Parent !";
		
		
	}
	
	//parent to  Student 
	

	
	@GetMapping("/students")
	List<Student>  students(@RequestParam ("parentid")  int parentid ){
		
		return  schoolservice.getStudents(parentid);
		
		
	}
	//Attendances ,Journal,Notifications
	@GetMapping("student/attendances")
	List<Attendance>  getAttendences(@RequestParam ("studentid") int studentid){
		return  schoolservice.getAttendencies(studentid);
	}
	@GetMapping("student/journals")
	List<Journal>  getJournals(@RequestParam ("studentid") int studentid){
		return  schoolservice.getJournals(studentid);
	}
	@GetMapping("student/notifications")
	List<Studentnotification>  getNotifications(@RequestParam ("studentid") int studentid){
		return  schoolservice.getNotifications(studentid);
	}
	
	@GetMapping("student/reports")
	List<Studentschoolreport>  getreports(@RequestParam ("studentid") int studentid){
		return  schoolservice.getReports(studentid);
	}
	@GetMapping("student/quick")
	Quickinfo  getquickInfo(@RequestParam ("studentid") int studentid) {
		
		return schoolservice.getQuickinfo(studentid);
	}
	
	@GetMapping("student/journal/view")
	void  viewJournal(@RequestParam ("journalid") int journalid) {
		
		 schoolservice.viewjournal(journalid);
	}
    
//Marks
	
	@GetMapping("/student/marks")
	List<Marks>  getSyudentAllmarks(@RequestParam ("studentid") int studentid)
	{
		return courseservice.getAllStudentMarks(studentid);
	}
	
}
