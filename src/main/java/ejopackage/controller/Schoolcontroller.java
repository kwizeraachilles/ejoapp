package ejopackage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejopackage.helper.AClassDTO;
import ejopackage.helper.Affiliation;
import ejopackage.helper.Attendeceinstance;
import ejopackage.helper.BulletinDTO;
import ejopackage.helper.BulletinRequest;
import ejopackage.helper.Combinationcomplete;
import ejopackage.helper.ElStaff;
import ejopackage.helper.Journalrequest;
import ejopackage.helper.Monitordata;
import ejopackage.helper.TeacherGetDTO;
import ejopackage.helper.TemporalCridentials;
import ejopackage.helper.Thestudent;
import ejopackage.helper.Userpatch;
import ejopackage.model.Aclass;
import ejopackage.model.Attendance;
import ejopackage.model.Bulletin;
import ejopackage.model.Bulletinprototype;
import ejopackage.model.Combination;
import ejopackage.model.Combinationprototype;
import ejopackage.model.Coursetime;
import ejopackage.model.Marks;
import ejopackage.model.Parent;
import ejopackage.model.School;
import ejopackage.model.Staff;
import ejopackage.model.Student;
import ejopackage.model.Teacher;
import ejopackage.service.Courseservice;
import ejopackage.service.Schoolservice;



@RestController
@CrossOrigin
@RequestMapping("/school")
public class Schoolcontroller {
    
	@Autowired
	Schoolservice schoolservice;
	
	@Autowired
	Courseservice  courseservice;
	
	
	@GetMapping("/")
	String  welcome(){
		
		return  " \n Welcome  School Sfatff !";
		
		
	}
	

	//School
	@GetMapping("/schools")
	List<School>  getAllSchools(){
		
		return schoolservice.getAllSchools();
		
	}
	@GetMapping("/school")
	School getSchool(@RequestParam ("schoolid") int schoolid){
		
		return schoolservice.getSchool(schoolid);
		
	}
	@GetMapping("/class/timetable")
	List<Coursetime> getClassTimetable(@RequestParam ("classid") int classid){
		
		return schoolservice.getClasstimetable(classid);
		
	}
	//School options

	@GetMapping("/school/option")
	Combination getSchooloption(@RequestParam ("schooloptionid") int schooloptionid){
		
		return schoolservice.getSchooloption(schooloptionid);
		
	}
	@GetMapping("/school/combinationprototypes")
	List<Combinationprototype> getCombinationprototypes(){
		
		return schoolservice.Combinationprototypes();
		
	}
	
	@GetMapping("/school/combination")
Combinationcomplete getCombination(@RequestParam ("combinationid") int combinationid){
      		
		return schoolservice.getCombination(combinationid);
		
	}
	@PostMapping("/school/options")
	void addSchooloptions(@RequestBody List<Combination> schooloptions ,@RequestParam ("schoolid") int schoolid) {
		schoolservice.addSchooloptions(schooloptions,schoolid);
	}
	@GetMapping("/school/options")
	 List<Combination>  getSchooloptions(@RequestParam ("schoolid") int schoolid) {
		return schoolservice.getSchoolSchooloptions(schoolid);
	}
	
	//Classes

	
	@GetMapping("/classes/school")
	List<Aclass>  getAllClassesSchool(@RequestParam ("schoolid") int schoolid){
		
		return schoolservice.getAllClassesSchool(schoolid);
		
	}
	
	
	
	@GetMapping("/class")
	Aclass getAclass(@RequestParam int classid){
		
		return schoolservice.getAclass(classid);
		
	}
	@PostMapping("/class")
	void addCalss(@RequestBody AClassDTO aclassdto ) {
		int c=aclassdto.getCombinationid();
		Aclass  aclass=new Aclass();
		aclass.setClassname(aclassdto.getClassname());
		aclass.setLevel(aclassdto.getLevel());
		aclass.setSession(aclassdto.getSession());
		schoolservice.addClass(aclass,c);
	}
	//Teacher
	
	@GetMapping("/teachers")
	List<Teacher>  getAllTeacher(){
		
		return schoolservice.getAllTeachers();
		
	}
	

	@GetMapping("/teacher")
	Teacher getTaecher(@RequestParam ("teacherid") int teacherid){
		
		return schoolservice.getTeacher(teacherid);	
		}
	
	@GetMapping("/user/teacher")  
	Teacher getTeacherUser(@RequestParam ("userid") int userid){
		
		return schoolservice.getTeacherUser(userid);	
		}
	@GetMapping("/school/teachers")  
	List<TeacherGetDTO> getSchoolTeachers(@RequestParam ("schoolid") int schoolid){
		
		return schoolservice.getSchoolTeachers(schoolid);	
		}

	@PostMapping("/teacher")
	void addCalss(@RequestBody Teacher teacher ) {
		schoolservice.addTeacher(teacher);
	}
	//staff
     @GetMapping("staff/teachers")
     List<Staff>  getIdleTeacher(){
	
	return  schoolservice.getIdleTechears();
     }

     @PostMapping("/staff/patch")
      void patchStaff(@RequestBody Userpatch up){
    	 schoolservice.patchUser(up);
     }
	//parent
	
	
	@GetMapping("/parents")
	List<Parent>  getAllParents(){
		
		return schoolservice.getAllParents();
		
	}
	@GetMapping("/user/parent")
	Parent getUserParent(@RequestParam ("userid") int userid){
		
		return schoolservice.getParentUser(userid);	
		}
	@GetMapping("/parent")
	Parent getParent(@RequestParam ("parentid") int parentid){
		
		return schoolservice.getParent(parentid);	
		}

	@PostMapping("/parent")
	void addParent(@RequestBody Parent parent ) {
		schoolservice.addParent(parent);
	}
	
	//student
	
	
	@GetMapping("/students")
	List<Student>  getAllStudents(){
		
		return schoolservice.getAllStudents();
		
	}
	@GetMapping("/class/students")
	List<Student>  getAllStudents(@RequestParam ("classid") int classid){
		
		return schoolservice.getClassStudents(classid);
		
	}
	@GetMapping("/student")
	Student getStudent(@RequestParam ("studentid") int studentid){
		
		return schoolservice.getStudent(studentid);	
		}

	@PostMapping("/student")
	void addCourse(@RequestBody Student student,@RequestParam ("classid") int classid,@RequestParam ("parentid") int parentid ) {
		schoolservice.addStudent(student,classid,parentid);
	}
	//teacher ,class student apis
	
	@PostMapping("/teacher/students/attendances")
	
	void markAttendences(@RequestBody  List<Attendeceinstance>  attendanceinstances) {
		
		schoolservice.markAttendances( attendanceinstances);
	}
	@PostMapping("/teacher/student/journal") 
	
	void sendJournal(@RequestBody  Journalrequest  journalreq ) {
		
		schoolservice.sendJournal( journalreq);
	}
	
	//Marks
	
	@GetMapping("/student/marks")
	List<Marks>  getSyudentAllmarks(@RequestParam ("studentid") int studentid)
	{
		return courseservice.getAllStudentMarks(studentid);
	}
	
	//student 
	@PostMapping("/registrar/student")
	void  registerStudent(@RequestBody Thestudent  thestudent) {
		schoolservice.registerThestudent(thestudent);
	}
	//staff
	@PostMapping("/registrar/staff")
	TemporalCridentials  registerStaff(@RequestBody ElStaff  thestaff) {
		return schoolservice.registerThestaff(thestaff);  
	}
	//affiliation
	@PostMapping("/registrar")
	void affilate( @RequestBody  Affiliation aff) {
		schoolservice.afiiliate(aff);
	}
	//monitoring
	@GetMapping("monitor/student")
	Monitordata getAverages(@RequestParam ("studentid") int studentid) {
		List<Marks> allmarks=new ArrayList<>();
		double allscore=0;
	allmarks=courseservice.getAllStudentMarks(studentid);
	for(Marks mrk:allmarks) {
		allscore=allscore+mrk.getScore();
	}
		float markrate=0;
		float attendacerate=0;
		
	  List<Attendance> onattendance	=schoolservice.getStudentStateAttendencies(true,studentid,true);
	  List<Attendance> allattendance=schoolservice.getAttendencies(studentid);
	  if(allmarks.size()>0) {
		  markrate=(float) (allscore/allmarks.size());
		
	  }
	  if(allattendance.size()>0) {
		 
		  attendacerate=onattendance.size()/allattendance.size();
	  }
	  
	   Monitordata md=new Monitordata(markrate*100,attendacerate*100);
	 
		return  md;
	}
 //Bulletin
	@GetMapping("/bulletins")
	List<Bulletin> getAllBulletins(){
		
	return	schoolservice.getBulltins();
	}
	
	@PostMapping("/bulletin/student")
	BulletinDTO getBulletin(@RequestBody  BulletinRequest  bulletinrequest) {
		
		
		return courseservice.getBulletin(bulletinrequest.getStudentid(),bulletinrequest.getClassid());
		
	}
	
	@PostMapping("/marks/test")
	List<Marks> getMarksTest(@RequestBody  BulletinRequest  bulletinrequest) {
		
		
		return courseservice.getMarksTest(bulletinrequest.getStudentid(),bulletinrequest.getClassid());
		
	}
}
