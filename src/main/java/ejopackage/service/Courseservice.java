package ejopackage.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejopackage.helper.Acourse;
import ejopackage.helper.Acoursetime;
import ejopackage.helper.BulletinDTO;
import ejopackage.helper.CoursebulletinDTO;
import ejopackage.helper.Coursemarkstrans;
import ejopackage.helper.Dailyplan;
import ejopackage.helper.Days;
import ejopackage.helper.Marksunit;
import ejopackage.model.Aclass;
import ejopackage.model.Bloomindex;
import ejopackage.model.Bloommetrics;
import ejopackage.model.Bulletin;
import ejopackage.model.Bulletinprototype;
import ejopackage.model.Combination;
import ejopackage.model.Combinationprototype;
import ejopackage.model.Course;
import ejopackage.model.Coursebulletin;
import ejopackage.model.Coursebulletinprototype;
import ejopackage.model.Coursecategory;
import ejopackage.model.Coursemarks;
import ejopackage.model.Courseprototype;
import ejopackage.model.Coursetime;
import ejopackage.model.Dailylessonplan;
import ejopackage.model.Levelprototype;
import ejopackage.model.Marks;
import ejopackage.model.Student;
import ejopackage.model.Weeklytimetable;
import ejopackage.model.curriculum.Curriculum;
import ejopackage.repository.AclassRepository;
import ejopackage.repository.AttendanceRepository;
import ejopackage.repository.BloommetricsRepository;
import ejopackage.repository.BulletinRepository;
import ejopackage.repository.BulletinprotoypeRepository;
import ejopackage.repository.CombinationRepository;
import ejopackage.repository.CourseBulletinprototypeRepository;
import ejopackage.repository.CourseRepository;
import ejopackage.repository.CoursebulletinRepository;
import ejopackage.repository.CoursecategoryRepository;
import ejopackage.repository.CoursemarksRepository;
import ejopackage.repository.CourseprototypeRepository;
import ejopackage.repository.CoursetimeRepository;
import ejopackage.repository.CurriculumRepository;
import ejopackage.repository.DailylessonplanRepository;
import ejopackage.repository.JournalRepository;
import ejopackage.repository.LevelPrototypeRepository;
import ejopackage.repository.MarksRepository;
import ejopackage.repository.ParentRepository;
import ejopackage.repository.SchoolRepository;
import ejopackage.repository.StudentRepository;
import ejopackage.repository.StudentnotificationRepository;
import ejopackage.repository.StudentschoolreportRepository;
import ejopackage.repository.TeacherRepository;
import ejopackage.repository.WeeklytimetableRepository;

@Service
public class Courseservice {
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	AclassRepository aclassRepository;
	
	
	@Autowired
	TeacherRepository teacherRepository;
	


	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CoursecategoryRepository coursecategoryRepository;
	
	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Autowired 
	CombinationRepository schooloptionRepository;
	
	
	@Autowired
	AttendanceRepository attendanceRepsoitory;
	
	@Autowired
	JournalRepository journalRepository;
	
	@Autowired 
	StudentnotificationRepository studentnotificationRepository;
	
	@Autowired
	StudentschoolreportRepository studentschoolreportRepsoitory;

	
	@Autowired
	CoursetimeRepository coursetimeRepository;
	@Autowired
	WeeklytimetableRepository weeklytimetableRepository;
	
	@Autowired
	MarksRepository marksRepository;
	
	@Autowired
	CurriculumRepository curriculumRepository;
	
	@Autowired
	CoursemarksRepository coursemarksRepository;
	@Autowired
	BloommetricsRepository bloommetricsRepository;
	
	@Autowired
	DailylessonplanRepository dailylessonplanRepository;
	
	@Autowired
	LevelPrototypeRepository levelprototypeRepository;
	@Autowired
	CourseprototypeRepository  courseprototypeRepository;
	
	@Autowired
	CoursebulletinRepository coursebulletinReposotory;
	@Autowired
	BulletinRepository bullettinrepository;
	
	@Autowired
	BulletinprotoypeRepository bulletinprotoypeRepository;
	
	@Autowired
	CourseBulletinprototypeRepository coursebulletinprototypeRepository;
	
	
	
	//Course
	 

	public List<Course> getAllCourses() {
		List<Course> AllCourses=new ArrayList<>();
		courseRepository.findAll().forEach(AllCourses::add);
		
		return  AllCourses;
	}

	public Course getCourse(int courseid) {
		Optional<Course> course=courseRepository.findById(courseid);
		if(course.isPresent()) {
			return course.get();
		}
		else
		{
			return null;
		}
		
	}

	public void addCourse(Acourse acourse) {
	
		Combination combination=schooloptionRepository.findById(acourse.getCombinationid()).get();
		Combinationprototype cmbpr=combination.getCombinationprototype();
		List<Levelprototype> lps=levelprototypeRepository.findAllByCombinationprototypeId(cmbpr.getId());
		Levelprototype thislp=new Levelprototype();
		for(Levelprototype lpr:lps) {
			if(lpr.getName()==acourse.getLevel()) {
				List<Courseprototype>  cpts=courseprototypeRepository.findAllByLevelprototypeId(lpr.getId());
				
				for(Courseprototype cp:cpts) {
					 String  code="";
						Course course=new Course();
						String cn=acourse.getName().substring(0,2);
						String cc=cp.getName().substring(0,3);
						long coursenumber=courseRepository.count();
						code=code.concat(cc);
						 String numero= String.format("%02d", (coursenumber+1));
						code=code.concat(numero);
						code=code.concat(cn);
						code=code.toUpperCase();
				      course.setCode(code);
				      course.setName(acourse.getName());
				      course.setHourz(acourse.getHourz());
				      course.setLevel(acourse.getLevel());
				      course.setImportance(acourse.getImportance());
				      course.setCourseprototype(cp);
				      course.setCombination(combination);
						
						
					
						courseRepository.save(course);

					
				}
			}
			
		}
		
		 	}



	public List<Coursetime> getAllCoursetime() {
		
		List<Coursetime> allCoursetime=new ArrayList<>();
		coursetimeRepository.findAll().forEach(allCoursetime::add);
		return allCoursetime;
	}

	public Weeklytimetable getTimetable(int teacherid) {

		return 	weeklytimetableRepository.findByTeacherTeacherid(teacherid);
	}

	public boolean addCoursetime(Acoursetime coursetime) {

		Weeklytimetable wktb=weeklytimetableRepository.findById(coursetime.getTimetableid()).get();
		Coursetime newcoursetime=new Coursetime();
		List<Coursetime> allCoursetime=new ArrayList<>();
		coursetimeRepository.findAllByWeeklytimetableId(coursetime.getTimetableid()).forEach(allCoursetime::add);
	    boolean timetableslot=false;
		String aday=coursetime.getWeekday();
        for(Coursetime previouscoursetime : allCoursetime) {
        	if(
        			(previouscoursetime.getDayindex() !=  coursetime.getDayindex()) 
        			||
        			(!previouscoursetime.getWeekday().equals(Days.valueOf(coursetime.getWeekday())))
        			
        
        	   ){
        		
        		timetableslot=true;
        		
        	}
        	else {
        		timetableslot=false;
        	}
        }
        if(timetableslot) {
        
    		newcoursetime.setWeekday(Days.valueOf(aday));
    		newcoursetime.setTime(coursetime.getTime());
    		newcoursetime.setCourse(courseRepository.findById(coursetime.getLessonid()).get());
    		newcoursetime.setCurrentclass(aclassRepository.findById(coursetime.getClassid()).get());
    		newcoursetime.setDayindex(coursetime.getDayindex());

    		 newcoursetime.setWeeklytimetable(wktb);
    			boolean processed=false;
    			if(coursetimeRepository.saveAndFlush(newcoursetime)!=null) {
    				processed=true;
    			};
    		
    			timetableslot=processed & timetableslot;
        }
     return timetableslot;
	}

	public List<Weeklytimetable> getTimetables() {
		List<Weeklytimetable> timetables=new ArrayList<>();
		weeklytimetableRepository.findAll().forEach(timetables::add);
		return timetables;
	}

	public List<Coursetime> getTimetableCoursetimes(int timetableid) {
		List<Coursetime> allCoursetime=new ArrayList<>();
		coursetimeRepository.findAllByWeeklytimetableId(timetableid).forEach(allCoursetime::add);
		return allCoursetime;
	}

	public int updateStudentsmarks(Marksunit marksunit) {
		int count=0;
		//List<Marks>  allmarks=new ArrayList<>();
     
		for(Coursemarkstrans km : marksunit.getCoursemarks()) {
			Student student=studentRepository.findById(km.getStudentid()).get();
			Marks m=new Marks();
			m.setCourse(courseRepository.findById(marksunit.getLessonid()).get());
			m.setDate(LocalDate.now());
			m.setStudent(student);
			m.setPeriod(marksunit.getSemester());
			m.setScore(km.getMarks()/marksunit.getPer());
			m.setType(marksunit.getType());
			m.setYear(marksunit.getYear());
			
		//	allmarks.add(m);
			marksRepository.save(m);
			Bloommetrics bmt=getBloommetrics(student.getId());
			
			student.setBloommetrics(bmt);
			studentRepository.save(student);
			count++;		}
		//marksRepository.saveAllAndFlush(allmarks);
	     
		return count;
	}
	public List<Marks> getAllMarks() {
		List<Marks> allMarks=new ArrayList<>();
		marksRepository.findAll().forEach(allMarks::add);
		return allMarks;
	}
	
	public List<Marks> getAllStudentMarks(int studentid) {
		List<Marks> allStudentMarks=new ArrayList<>();
		marksRepository.findAllByStudentId(studentid).forEach(allStudentMarks::add);
		return allStudentMarks;
	}

	//  Just get  blooms   non recultants
	public Bloommetrics getBloommetrics(int studentid) {
		Bloommetrics bmtr=new Bloommetrics();
		
		//marks details
		List<Marks>  studentMarks=marksRepository.findAllByStudentId(studentid);
	
	
		//marks details  by  bloomparameter
		
		

		Student student=studentRepository.findById(studentid).get();
		Combinationprototype  comprot=student.getStudentclass().getSchooloption().getCombinationprototype();
		List<Levelprototype>lps=levelprototypeRepository.findAllByCombinationprototypeId(comprot.getId());
		Levelprototype lp=new Levelprototype() ;
		for(Levelprototype l:lps) {
			if(l.getName()==student.getStudentclass().getLevel()) {
				lp=l;
			}
			Double rs=0.0;
			Double als=0.0;
			Double aps=0.0;
			Double es=0.0;
			Double cs=0.0;
			Double us=0.0;
			Bloomindex bi=lp.getBloomindex();
			
				List<Courseprototype> courseprototypes=courseprototypeRepository.findAllByLevelprototypeId(lp.getId());
				

			      if(!courseprototypes.isEmpty()) {
			    	  
			  		for(Courseprototype coursp:courseprototypes){
						
						
						Double aver=studentMarks.stream().filter(x->x.getCourse().getCourseprototype().getCoursecategory()==coursp.getCoursecategory())
								.map(x->x.getScore()).collect(Collectors.averagingDouble(Double::doubleValue));
						
						
						Double r=aver*coursp.getCoursecategory().getBloomrate().getRemembering()*bi.getRememberingindex();
						rs=rs+r;
						Double a=aver*coursp.getCoursecategory().getBloomrate().getAnalyzing()*bi.getAnalyzingindex();
						als=als+a;
						Double ap=aver*coursp.getCoursecategory().getBloomrate().getApplying()*bi.getApplyingindex();
						aps=aps+ap;
					
						Double c=aver*coursp.getCoursecategory().getBloomrate().getCreating()*bi.getCreatingindex();
						cs=cs+c;
						Double e=aver*coursp.getCoursecategory().getBloomrate().getEvaluating()*bi.getEvaluatingindex();
						es=es+e;
						Double u=aver*coursp.getCoursecategory().getBloomrate().getUnderstanding()*bi.getUnderstandingindex();
						us=us+u;
						
						
					}
					
			    	  
			      
				
			}
		
	
	

		
			     
	
		
	    bmtr.setAnalyzing(als);
	    bmtr.setApplying(aps);
	    bmtr.setCreating(cs);
	    bmtr.setEvaluating(es);
	    bmtr.setRemembering(rs);
	    bmtr.setUnderstanding(us);
	
	    bloommetricsRepository.saveAndFlush(bmtr);
	    
	  
		}
		student.setBloommetrics(bmtr);
		studentRepository.save(student);
		return bmtr;
	}
//Curiculums
	
	public List<Curriculum> getAllCurriculums() {
		List<Curriculum> allCurriculums=new ArrayList<>();
		curriculumRepository.findAll().forEach(allCurriculums::add);
		return allCurriculums;
	}

	public void addCurriculum(Curriculum curriculum) {
		curriculumRepository.save(curriculum);
	}



	
	//courses categories
	public List<Coursecategory> getAllCoursecategories() {
		List<Coursecategory> coursecategories=new ArrayList<>();
		coursecategoryRepository.findAll().forEach(coursecategories::add);
		return coursecategories;
	}

	public List<Course> getCourseinClass(int classid) {
	
		return null;
	}

	public List<Course> getCoursesCombinationLevel(int combinationid, int level) {
	
		List<Course> courses=new ArrayList<>();
		courseRepository.findAllByCombinationIdAndLevel(combinationid, level).forEach(courses::add);
		return courses;
	}

	public List<Coursemarks> getStudentCoursemarks(int studentid) {
	    
		List<Coursemarks> studentCoursemarks=new ArrayList<>();
		coursemarksRepository.findAllByStudentId(studentid).forEach(studentCoursemarks::add);
		return studentCoursemarks;
	}
 
	public void addDailyplan(Dailyplan dailyplan) {
		Aclass aclass=aclassRepository.findById(dailyplan.getCurrentclassid()).get();
		Dailylessonplan dailylessonplan=new Dailylessonplan();
		dailylessonplan.setCourse(courseRepository.findById(dailyplan.getCourseid()).get());
		dailylessonplan.setCurrentclass(aclass);
		dailylessonplan.setYear(aclass.getSchooloption().getSchool().getSchoolcalender().getStartYear());
		dailylessonplan.setTrimester(aclass.getSchooloption().getSchool().getSchoolcalender().getCurrentsemester());
		dailylessonplan.setTime(LocalDateTime.now());
		dailylessonplan.setTeacher(teacherRepository.findById(dailyplan.getTeacherid()).get());
		dailylessonplan.setLessontitle(dailyplan.getLessontitle());
		dailylessonplan.setLessonintroduction(dailyplan.getLessonintroduction());
		dailylessonplan.setLessondescription(dailyplan.getLessondescription());
		dailylessonplan.setLessonexemples(dailyplan.getLessonexemples());
		dailylessonplan.setObervation(dailyplan.getObservation());
		 dailylessonplanRepository.save(dailylessonplan);
		
	}

	public List<Dailylessonplan> getAlllessonPlans() {
		List<Dailylessonplan> alllessonPlans=new ArrayList<>();
		dailylessonplanRepository.findAll().forEach(alllessonPlans::add);
		
		return alllessonPlans;
	}

	public BulletinDTO getBulletin(int studentid, int classid) {
		
		BulletinDTO bulletindto=new BulletinDTO();
		Bulletin bulletin=generateBullettin(studentid, classid);
		if(bulletin!=null) {
			
			List<CoursebulletinDTO>  coursesbulletindtos=new ArrayList<>();
			bulletindto.setClassinfo(bulletin.getClassinfo());
			bulletindto.setCombiantioninfo(bulletin.getCombiantioninfo());
			bulletindto.setLevel(bulletin.getLevel());
			bulletindto.setMainpermarks(bulletin.getMainpermarks());
			bulletindto.setMandatorypermarks(bulletin.getMandatorypermarks());
			bulletindto.setOptionalpermarks(bulletin.getOptionalpermarks());
			bulletindto.setSigned(bulletin.isSigned());
			bulletindto.setUpdated(bulletin.getUpdated());
			bulletindto.setSigndate(bulletin.getSigndate());
			bulletindto.setOnetotcw(bulletin.getOnetotcw());
			bulletindto.setOnetotex(bulletin.getOnetotex());
			bulletindto.setTwototcw(bulletin.getTwototcw());
			bulletindto.setTwototex(bulletin.getTwototex());
			bulletindto.setThreetotcw(bulletin.getThreetotcw());
			bulletindto.setThreetotex(bulletin.getThreetotex());
			bulletindto.setPer(bulletin.getPer());
			
		
			bulletin.getCoursebulletins().stream().map(cb->new CoursebulletinDTO(cb.getCourseid(),cb.getCoursename(),cb.getImportance(),
					cb.getOnecw(),cb.getOneex(),cb.getOnetot(),cb.getTwocw(),cb.getTwoex(),cb.getTwotot(),cb.getThreecw(),cb.getThreeex(),cb.getThreetot(), cb.getAnnual(),cb.getUpdated())).forEach(coursesbulletindtos::add);
			
			bulletindto.setCoursebulletindtos(coursesbulletindtos);
		}

		return bulletindto;
	}

	Bulletin generateBullettin(int studentid,int classid) {
		List<Marks> allmarks=marksRepository.findAllByStudentId(studentid);
		List<Marks> relaventmarks=allmarks.stream().filter(m->(m.getStudent().getStudentclass().getCalssid()==classid)).toList();
		Bulletin bulletin=bullettinrepository.findByStudentId(studentid);
		double onetotcw=0;
		double onetotexam=0;
		double twototcw=0;
		double twototexam=0;
		double threetotcw=0;
		double threetotexam=0;
		
		for(Coursebulletin cbllt:bulletin.getCoursebulletins()) {
			double importancemarkx=1;
			if(cbllt.getImportance()==3) {
				importancemarkx=bulletin.getMainpermarks();
			}
			else if(cbllt.getImportance()==2) {
				importancemarkx=bulletin.getMandatorypermarks();
			}
			else if(cbllt.getImportance()==1) {
				importancemarkx=bulletin.getOptionalpermarks();
			}

	List<Double> lesconec =  relaventmarks.stream().filter(m->(m.getCourse().getCourseid()==cbllt.getCourseid() && m.getPeriod()==1)).filter(m->m.getType().equals("test")).map(s->s.getScore()).toList();
           // double oc=(oncw.isPresent()) ? oncw.get().getScore() : 0;   
	  double  oncw=0;
	   for(double dc:lesconec) {
		   oncw=oncw+dc; }
	   if(lesconec.size()>0) {
		   cbllt.setOnecw((oncw/lesconec.size())*importancemarkx);
		   onetotcw=onetotcw + oncw/lesconec.size()*importancemarkx;
		   
	   }
  
  List<Double> lesconee=relaventmarks.stream().filter(m->(m.getCourse().getCourseid()==cbllt.getCourseid() && m.getPeriod()==1)).filter(m->m.getType().equals("exam")).map(s->s.getScore()).toList();
		  
		
  double  oneex=0;
  for(double de:lesconee) {
	  oneex=oneex+de;
	  }
  if(lesconee.size()>0) {
	  cbllt.setOneex(oneex/lesconee.size()*importancemarkx);
	  onetotexam=onetotexam+oneex/lesconee.size()*importancemarkx;
	 }

     //double oe=(oneex.isPresent()) ? oneex.get().getScore() : 0; 
     
 
  List<Double> lestwoc=relaventmarks.stream().filter(m->(m.getCourse().getCourseid()==cbllt.getCourseid() && m.getPeriod()==2)).filter(m->m.getType().equals("test")).map(s->s.getScore()).toList();
  
  double  twoc=0;
  for(double dtc:lestwoc) {
	  twoc=twoc+dtc;
	  }
  if(lestwoc.size()>0) {
	  cbllt.setTwocw(twoc/lestwoc.size()*importancemarkx);

	   twototcw=twototcw+ twoc/lestwoc.size()*importancemarkx;
	  
	 }


  List<Double>  lestwoe=relaventmarks.stream().filter(m->(m.getCourse().getCourseid()==cbllt.getCourseid() && m.getPeriod()==2)).filter(m->m.getType().equals("exam")).map(s->s.getScore()).toList();
   
  double  twoe=0;
  for(double dte:lestwoe) {
	  twoe=twoe+dte;
	  }
  if(lestwoe.size()>0) {

		twototexam=twototexam+ twoe/lestwoe.size()*importancemarkx;
	  
	 }

  List<Double>  lesthreec=relaventmarks.stream().filter(m->(m.getCourse().getCourseid()==cbllt.getCourseid() && m.getPeriod()==3)).filter(m->m.getType().equals("test")).map(s->s.getScore()).toList();

  double  threec=0;
  for(double dthc: lesthreec) {
	  threec=threec+dthc;
	  }
  if( lesthreec.size()>0) {
	  

	  cbllt.setThreecw(threec/lesthreec.size()*importancemarkx);
	  threetotcw=threetotcw+ threec/lesthreec.size()*importancemarkx;
	  
	 }

 List<Double>  lesthreeex=relaventmarks.stream().filter(m->(m.getCourse().getCourseid()==cbllt.getCourseid() && m.getPeriod()==3)).filter(m->m.getType().equals("exam")).map(s->s.getScore()).toList();
 double  threex=0;
 for(double dthe:lesthreeex) {
	 threex=threex+dthe;
	  }
 if(lesthreeex.size()>0) {
	
	  cbllt.setThreeex(threex/lesthreeex.size()*importancemarkx);
	  threetotexam=threetotexam+ threec/threex/lesthreeex.size()*importancemarkx;
	  
	 }
 
          cbllt.setOnetot(cbllt.getOnecw()+cbllt.getOneex());
          cbllt.setTwotot(cbllt.getTwocw()+cbllt.getTwoex());
          cbllt.setThreetot(cbllt.getThreecw()+cbllt.getThreeex());
							coursebulletinReposotory.saveAndFlush(cbllt);
			
		}
		
		bulletin.setOnetotcw(onetotcw);
		bulletin.setOnetotex(onetotexam);
		bulletin.setTwototcw(twototcw);
		bulletin.setTwototex(twototexam);
		bulletin.setThreetotcw(threetotcw);
		bulletin.setTwototex(twototexam);
	
		bullettinrepository.saveAndFlush(bulletin);
		return bulletin;
		
	}

	public List<Marks> getMarksTest(int studentid, int classid) {
	
		List<Marks> allmarks=marksRepository.findAllByStudentId(studentid);
		List<Marks> relaventmarks=allmarks.stream().filter(m->(m.getStudent().getStudentclass().getCalssid()==classid && m.getCourse().getCourseid()==studentid && m.getType().equals("testi") ))
		.toList();
		//.filter(m->m.getType()=="test").filter(m->m.getPeriod()==1)
		//Bulletin bulletin=bullettinrepository.findByStudentId(studentid);
	
		return relaventmarks;
	}




}
