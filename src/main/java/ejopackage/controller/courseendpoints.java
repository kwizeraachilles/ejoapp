package ejopackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejopackage.helper.Acourse;
import ejopackage.helper.Acoursetime;
import ejopackage.helper.Dailyplan;
import ejopackage.helper.Marksunit;
import ejopackage.model.Bloommetrics;
import ejopackage.model.Course;
import ejopackage.model.Coursecategory;
import ejopackage.model.Coursemarks;
import ejopackage.model.Coursetime;
import ejopackage.model.Dailylessonplan;
import ejopackage.model.Marks;
import ejopackage.model.Weeklytimetable;
import ejopackage.model.curriculum.Curriculum;
import ejopackage.service.Courseservice;


@RestController
@CrossOrigin
@RequestMapping("/school/studies")
public class courseendpoints {

	
	@Autowired
	Courseservice  courseservice;
	//courses
	
	@GetMapping("/courses")
	List<Course>  getAllCourses(){
		
		return courseservice.getAllCourses();
		
	}
	
	@GetMapping("class/courses")
	List<Course> getCoursesinclass(@RequestParam("classid") int  classid){
		return courseservice.getCourseinClass(classid);
	}
	
	@GetMapping("/course")
	Course getCourse(@RequestParam ("courseid") int courseid){
		
		return courseservice.getCourse(courseid);	
		}

	@PostMapping("/course")
	void addCourse(@RequestBody Acourse course ) {
		courseservice.addCourse(course);
	}
	@GetMapping("courses/categories")
	List<Coursecategory> allcoursecategories(){
	 return	courseservice.getAllCoursecategories();
	}

	@GetMapping("/courses/level")
	List<Course> getCoursesLevel(@RequestParam ("combinationid")  int combinationid ,@RequestParam ("level")  int level )
	{
		return courseservice.getCoursesCombinationLevel(combinationid,level);
	}
	//courseTime
	
	@GetMapping("/coursetimes")
	List<Coursetime> getAllCoursetime(){
		
		return courseservice.getAllCoursetime();
	}
	
	@GetMapping("/coursetimes/weeklytimetable")
	List<Coursetime> getTimetableCoursetimes(@RequestParam ("timetableid") int timetableid){
		
		return courseservice.getTimetableCoursetimes(timetableid);
	}
	@PostMapping("/coursetime")
	boolean addCoursetime(@RequestBody Acoursetime coursetime ) {
	return 	courseservice.addCoursetime(coursetime );
		}

		
	//weeklytimetable
	
	@GetMapping("/weeklytimetables")
	List<Weeklytimetable> getWeeklytimetables( ) {
	return courseservice.getTimetables();
        }
	
	
	@GetMapping("/weeklytimetable")
	Weeklytimetable getWeeklytimetable(@RequestParam ("teacherid") int teacherid) {
	return courseservice.getTimetable(teacherid);
        }
	
	
	//Marks
	
	
	@PostMapping("/marks")
	int markStudents(@RequestBody Marksunit marksuinit )
	{
		 return courseservice.updateStudentsmarks(marksuinit);
	}
	
	@GetMapping("/marks")
	List<Marks>  getAllmarks()
	{   
		return courseservice.getAllMarks();
	}
	@GetMapping("/student/marks")
	List<Marks>  getSyudentAllmarks(@RequestParam ("studentid") int studentid)
	{
		return courseservice.getAllStudentMarks(studentid);
	}
	@GetMapping("/student/coursemarks")
	List<Coursemarks> getStudentCourseMarks(@RequestParam ("studentid")  int studentid)
	{
		return courseservice.getStudentCoursemarks(studentid);
	}
	//Bloom mertics
	
   @GetMapping("/student/bloommetrics")

    Bloommetrics bloommetrics(@RequestParam ("studentid") int studentid)
  {
	 return  courseservice.getBloommetrics(studentid);
}
   
   //Curriculums
   
   
   @GetMapping("/curriculums")
   
   List<Curriculum> getAllCurriculums(){
	  return  courseservice.getAllCurriculums();
   }
   @PostMapping("/curriculum")
   void addACurriculum(@RequestBody Curriculum curriculum) {
	   courseservice.addCurriculum(curriculum);
	   
   }
   //courseplan
   
   @PostMapping("/dailylessonplan")
   void addDailyLessonplan(@RequestBody Dailyplan dailyplan) {
	   
	   courseservice.addDailyplan(dailyplan);
	   
   }
   @GetMapping("/dailylessonplans")
   List<Dailylessonplan> alldailylessonplans(){
	  return courseservice.getAlllessonPlans();  
   }
 }





























