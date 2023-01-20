package ejopackage.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejopackage.helper.AUser;
import ejopackage.helper.Affiliation;
import ejopackage.helper.Attendeceinstance;
import ejopackage.helper.Combinationcomplete;
import ejopackage.helper.Coursecomplete;
import ejopackage.helper.ElStaff;
import ejopackage.helper.Journalrequest;
import ejopackage.helper.Levelcomplete;
import ejopackage.helper.Quickinfo;
import ejopackage.helper.TeacherGetDTO;
import ejopackage.helper.TemporalCridentials;
import ejopackage.helper.Thestudent;
import ejopackage.helper.Userpatch;
import ejopackage.model.Aclass;
import ejopackage.model.Attendance;
import ejopackage.model.Bloommetrics;
import ejopackage.model.Bulletin;
import ejopackage.model.Bulletinprototype;
import ejopackage.model.Combination;
import ejopackage.model.Combinationprototype;
import ejopackage.model.Course;
import ejopackage.model.Coursebulletin;
import ejopackage.model.Coursebulletinprototype;
import ejopackage.model.Courseprototype;
import ejopackage.model.Coursetime;
import ejopackage.model.Journal;
import ejopackage.model.Levelprototype;
import ejopackage.model.Parent;
import ejopackage.model.School;
import ejopackage.model.Staff;
import ejopackage.model.Student;
import ejopackage.model.Studentnotification;
import ejopackage.model.Studentschoolreport;
import ejopackage.model.Teacher;
import ejopackage.model.User;
import ejopackage.model.Weeklytimetable;
import ejopackage.repository.AclassRepository;
import ejopackage.repository.AttendanceRepository;
import ejopackage.repository.BloommetricsRepository;
import ejopackage.repository.BulletinRepository;
import ejopackage.repository.BulletinprotoypeRepository;
import ejopackage.repository.CombinationRepository;
import ejopackage.repository.CombinationprototypeRepository;
import ejopackage.repository.CourseBulletinprototypeRepository;
import ejopackage.repository.CourseRepository;
import ejopackage.repository.CoursebulletinRepository;
import ejopackage.repository.CourseprototypeRepository;
import ejopackage.repository.CoursetimeRepository;
import ejopackage.repository.JournalRepository;
import ejopackage.repository.LevelPrototypeRepository;
import ejopackage.repository.ParentRepository;
import ejopackage.repository.SchoolRepository;
import ejopackage.repository.StaffRepository;
import ejopackage.repository.StudentRepository;
import ejopackage.repository.StudentnotificationRepository;
import ejopackage.repository.StudentschoolreportRepository;
import ejopackage.repository.TeacherRepository;
import ejopackage.repository.UserRepository;
import ejopackage.repository.WeeklytimetableRepository;





@Service
public class Schoolservice {
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	AclassRepository aclassRepository;
	
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	UserRepository userRepository;


	@Autowired
	CourseRepository courseRepository;
	
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
   BloommetricsRepository  bloommetricsRepository;
	
	
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	WeeklytimetableRepository  weeklytimetableRepository;
	
	@Autowired
	CombinationprototypeRepository combinationprototypeRepository;
	
	@Autowired
	LevelPrototypeRepository levelprototypeRepository;
	
	@Autowired
	CourseprototypeRepository courseprototypeRepository;
	
	@Autowired
	FunctionsService functionsService;
	


	

	
	@Autowired
	CoursebulletinRepository coursebulletinReposotory;
	@Autowired
	BulletinRepository bullettinrepository;
	
@Autowired
CoursetimeRepository coursetimeRepository;
	


	

	
	
	//School
	public List<School> getAllSchools() {
		List<School> AllSchools =new ArrayList<>();
		schoolRepository.findAll().forEach(AllSchools::add);
		return AllSchools;
	}

	public School getSchool(int schoolid) {
		School sc=new School();
		School school= schoolRepository.findById(schoolid).get();
		sc=school;
		sc.setLogo(decompressBytes(school.getLogo()));
		
		return sc;
	}




	//Classes



	public List<Aclass> getAllClasses() {
		List<Aclass> AllClasses=new ArrayList<>();
		aclassRepository.findAll().forEach(AllClasses::add);
		return AllClasses;
	}

	public Aclass getAclass(int classid) {
		
		return aclassRepository.findById(classid).get();
	}
//ad  class
	public void addClass(Aclass aclass, int schooloptionid) {
		
		if(schooloptionRepository.findByCombinationprototypeId(schooloptionid)!=null) {
			Combination comb=schooloptionRepository.findByCombinationprototypeId(schooloptionid);
			Combinationprototype cmbpr=comb.getCombinationprototype();
			aclass.setSchooloption(comb);
			
		
			List<Levelprototype> levelprototypes=levelprototypeRepository.findAllByCombinationprototypeId(cmbpr.getId());
			List<Course> courses=new ArrayList<>();
			for(Levelprototype lpr:levelprototypes) {
		
				if(lpr.getName()==aclass.getLevel()) {
					aclass.setMaxhourz(lpr.getMaxhourz());
					List<Courseprototype> cps=courseprototypeRepository.findAllByLevelprototypeId(lpr.getId());
					
					for(Courseprototype cp:cps) {
						Course course=new Course();
						course.setCombination(comb);
						course.setCourseprototype(cp);
						course.setHourz(cp.getHourz());
						course.setImportance(cp.getImportance());
						course.setName(cp.getName());
						course.setLevel(lpr.getName());
						
                       course.setCode(comb.getName()+Integer.toString(lpr.getName())+cp.getName().substring(0,3));
						courses.add(course);
				
			  
						
					}
				  courseRepository.saveAllAndFlush(courses);
               			
				
					
					
					
					
				}
			}
			aclass.setCourses(courses);
		final Aclass ct=aclassRepository.save(aclass);
			coursetimeRepository.saveAll(functionsService.timetabler(ct));
		
			
		}else {
			Combination combi=new Combination();
			Combinationprototype cp=combinationprototypeRepository.findById(schooloptionid).get();
			combi.setCombinationprototype(cp);
			combi.setName(cp.getName());
			aclass.setSchooloption(combi);
			schooloptionRepository.saveAndFlush(combi);
			aclassRepository.save(aclass);
		}
		
		
		
	}

	public List<Teacher> getAllTeachers() {
		List<Teacher> allTeachers=new ArrayList<>();
		teacherRepository.findAll().forEach(allTeachers::add);
		return allTeachers;
	}

	public Teacher getTeacher(int teacherid) {
		Optional<Teacher> teacher=teacherRepository.findById(teacherid);
		if(teacher.isPresent()) {
			return teacher.get();
		}
		else {
			return null;
		}
		
	}

	public void addTeacher(Teacher teacher) {
	   teacherRepository.save(teacher);
	}

	
//Student

	public void addStudent(Student student, int classid, int parentid) {
		Optional<Aclass> aclass=aclassRepository.findById(classid);
		Optional<Parent>  parent=parentRepository.findById(parentid);
		if(aclass.isPresent()&& parent.isPresent()) {
			
			student.setParent(parent.get());
			student.setStudentclass(aclass.get());
			
			studentRepository.save(student);
		}
			
		
		
	}

	public Student getStudent(int studentid) {
	Optional<Student> student=studentRepository.findById(studentid);
	if(student.isPresent()) {
		
		return student.get();
	}
	else {
		return null;
	}
		
	}
	
	public List<Student> getAllStudents() {
		List<Student> AllStudents=new ArrayList<>();
		studentRepository.findAll().forEach(AllStudents::add);
		return AllStudents;
	}
	
	

	public List<Parent> getAllParents() {
		List<Parent> AllParents=new ArrayList<>();
		parentRepository.findAll().forEach(AllParents::add);
		return AllParents;
	}

	public Parent getParent(int parentid) {
		Optional<Parent> parent=parentRepository.findById(parentid);
		if(parent.isPresent())
		{
			return parent.get();
		}
		else {
			return null;
		}
		
	}

	public void addParent(Parent parent) {
		parentRepository.save(parent);
		
	}

	public List<Combination> getAllSchoolotons() {
		List<Combination> allSchoolotons=new ArrayList<>();
		schooloptionRepository.findAll().forEach(allSchoolotons::add);
		return allSchoolotons;
	}

	public Combination getSchooloption(int schooloptionid) {
	
 Optional<Combination> schooloption=schooloptionRepository.findById(schooloptionid);
    if(schooloption.isPresent()) {
    	return schooloption.get();
    }
    else {
    	return null;	
    }
		
	}

	public void addSchooloptions(List<Combination> schooloptions, int schoolid) {
		Optional<School> school=schoolRepository.findById(schoolid);
		if(school.isPresent()) {
		List<Combination> tempschooloptions=new ArrayList<>();
		for(Combination schooloption :schooloptions) {
			if(schooloptionRepository.save(schooloption)!=null) {
				tempschooloptions.add(schooloption);
			}
		}
		
	
	
			
			schooloptionRepository.flush();
			schoolRepository.saveAndFlush(school.get());
		}
		
	}



	public List<Student> getStudents(int parentid) {
		
		Optional<Parent> optparent=parentRepository.findById(parentid);
		
		if(optparent.isPresent()) {
			
			return studentRepository.findAllByParentId(parentid);
		}
		else {
			return null;
		}
	}
//attendencies
	
	public List<Attendance> getAttendencies(int studentid) {
		
		return attendanceRepsoitory.findAllByStudentId(studentid);
	}
	public List<Attendance> getStudentStateAttendencies(boolean checked,int studentid,boolean state) {
		
		return attendanceRepsoitory.findAllByCheckedAndStudentIdAndAttended(checked,studentid,state);
	}


	public List<Journal> getJournals(int studentid) {
		
		return journalRepository.findAllByStudentId(studentid);
	}

	public List<Studentnotification> getNotifications(int studentid) {
		
		return studentnotificationRepository.findAllByStudentId(studentid);
	}

	public List<Studentschoolreport> getReports(int studentid) {
		
		return studentschoolreportRepsoitory.findAllByStudentId(studentid);
	}

	public List<Student> getClassStudents(int classid) {
		List<Student> allStudents=new ArrayList<>();
		allStudents=studentRepository.findAllByStudentclassClassid(classid);
		return allStudents ;
	}


 		




	public void markAttendances(List<Attendeceinstance> attendanceinstances) {
		for(Attendeceinstance att:attendanceinstances) {
			
			Student student=studentRepository.findById(att.getStudentid()).get();
			Course course=courseRepository.findById(att.getCourseid()).get();
			Attendance attendance=new Attendance();
			attendance.setAttended(att.isStatus());
			attendance.setStudent(student);
			attendance.setCourse(course);
			attendance.setChecked(true);
			attendanceRepsoitory.saveAndFlush(attendance);
			
		}
		
	}

	public void sendJournal(Journalrequest journalreq) {
		Student student=studentRepository.findById(journalreq.getStudentid()).get();
		Teacher teacher=teacherRepository.findById(journalreq.getTeacherid()).get();
		Journal journal=new Journal();
		journal.setStudent(student);
		journal.setTeacher(teacher);
		journal.setTitle(journalreq.getTitle());
		journal.setDetails(journalreq.getDetails());
		
		journalRepository.save(journal);
	}

	public Quickinfo getQuickinfo(int studentid) {
		int journals=journalRepository.findAllByViewedAndStudentId(false, studentid).size();
		
		int attendances=attendanceRepsoitory.findAllByCheckedAndStudentId(false, studentid).size();
		Quickinfo qi=new Quickinfo(journals,attendances,0);
		return qi;
	}

	public void viewjournal(int journalid) {
		Journal journal=journalRepository.findById(journalid).get();
		journal.setViewed(true);
	
		journalRepository.saveAndFlush(journal);
	}

	public Teacher getTeacherUser(int userid) {
		Teacher  teach=teacherRepository.findByStaffUserId(userid);
		return teach;
	}

	public Parent getParentUser(int userid) {
		Parent  parent=parentRepository.findByUserId(userid);
		return parent;
	}

	public void registerThestudent(Thestudent thestudent) {
		Student student=new Student();
		Bloommetrics bm=new Bloommetrics();
		bloommetricsRepository.saveAndFlush(bm);
	 Aclass	aclass=aclassRepository.findById(thestudent.getStudentclass()).get();
		student.setBirthdate(thestudent.getBirthdate());
		student.setBloommetrics(bm);
		student.setFirstname(thestudent.getFirstname());
		student.setGender(thestudent.getGender());
		student.setLastname(thestudent.getLastname());
		student.setMidlename(thestudent.getMidlename());
		 student.setStudentclass(aclass);
		 student.setGuadianonenames(thestudent.getGuadianonenames());
		 student.setGuidianonenid(thestudent.getGuidianonenid());
		 student.setGuidianonecontact(thestudent.getGuidianonecontact());
		 student.setGuadiantwonenames(thestudent.getGuadiantwonenames());
		 student.setGuidiantwonid(thestudent.getGuidiantwonid());
		 student.setGuidiantwocontact(thestudent.getGuidiantwocontact());
		 student.setRegistered(LocalDateTime.now());
		 
		
		 
		
		studentRepository.save(student);
          //bulletin
	;
			  Combinationprototype compr=  aclass.getSchooloption().getCombinationprototype();
	List<Levelprototype>  lvlps=levelprototypeRepository.findAllByCombinationprototypeId(compr.getId());
			Levelprototype	lvlp=new Levelprototype();
	for(Levelprototype	lp:lvlps) {
		if(lp.getName()==aclass.getLevel()) {
			lvlp=lp;
		}
	}
			
	Bulletinprototype blpr=lvlp.getBulletinprototype();
	List<Coursebulletin> coursebullettins=new ArrayList<>();
	for(Coursebulletinprototype cbp:blpr.getCoursebulletinprototypes()) {
		  Coursebulletin coursebulletin =new Coursebulletin();
		  Aclass thisclass=student.getStudentclass();
		  List<Course> scs=courseRepository.findByCourseprototypeIdAndCombinationIdAndLevel(
				  cbp.getCourseid(),thisclass.getSchooloption().getId(),thisclass.getLevel());
		  
		  for(Course sc:scs) {
			  if (thisclass.getCourses().contains(sc)) {
				  coursebulletin.setCourseid(sc.getCourseid());
			  }else {
				  coursebulletin.setCourseid(cbp.getCourseid());
			  }
		  }
		 
		  coursebulletin.setCoursename(cbp.getCoursename());
		  coursebulletin.setImportance(cbp.getImportance());
		  coursebulletin.setStudent(student);
		
		  coursebulletinReposotory.saveAndFlush(coursebulletin);
		  
		  coursebullettins.add(coursebulletin);
		  
	}
	Bulletin bulletin=new Bulletin();
	  bulletin.setLevel(blpr.getLevel());
	  bulletin.setPer(blpr.getPer());
	  bulletin.setMainpermarks(blpr.getMainpermarks());
	  bulletin.setMandatorypermarks(blpr.getMandatorypermarks());
	  bulletin.setOptionalpermarks(blpr.getOptionalpermarks());
	  bulletin.setStudent(student);
	  bulletin.setSchool(student.getStudentclass().getSchooloption().getSchool());
	  bulletin.setClassinfo(student.getStudentclass().getClassname());
	  bulletin.setClassid(student.getStudentclass().getCalssid());
	  bulletin.setCombiantioninfo(student.getStudentclass().getSchooloption().getName());
	  bulletin.setCoursebulletins(coursebullettins);
	  bullettinrepository.save(bulletin);
		
	}

	public void registerUser(AUser auser) {
		
		User user=new User();
		user.setFirstname(auser.getFirstname());
		user.setLastname(auser.getLastname());
		user.setNationalid(auser.getNationalid());
		user.setPhone(auser.getPhone());
		user.setUsername(auser.getUsername());
		user.setPassword(auser.getPassword());
		user.setInitiated(LocalDateTime.now());
		user.setRoles("user");
		userRepository.save(user);
		
	}

	public List<Student> getAffStudents(String nid) {
		
		return studentRepository.findAllByGuidianonenidOrGuidiantwonid(nid,nid);
	}

	public void afiiliate(Affiliation aff) {
		User user=userRepository.findById(aff.getUserid()).get();
		if(!aff.getStudentids().isEmpty()) {
			Parent  parent=new Parent();
			
			parent.setUser(user);
			
			user.setRoles("user,parent");
			userRepository.saveAndFlush(user);
		parentRepository.saveAndFlush(parent);
		  
		
		for(int s : aff.getStudentids()) {
			Student student=studentRepository.findById(s).get();
			student.setParent(parent);
			studentRepository.saveAndFlush(student);
		}
			
		}
	
		
	

		
	}

	public TemporalCridentials registerThestaff(ElStaff thestaff) {
		int anyumber =(int) Math.floor(Math.random()*1000);
		String pass=org.apache.logging.log4j.util.Strings.toRootUpperCase(Integer.toHexString(anyumber));
		User user=new User();
		Staff staff=new Staff();
		user.setActive(false);
		user.setAddress(thestaff.getAddress());
		user.setFirstname(thestaff.getFirstname());
		user.setInitiated(LocalDateTime.now());
		user.setLastname(thestaff.getLastname());
		user.setMidlename(thestaff.getMidlename());
		user.setNationalid(thestaff.getNid());
		user.setPhone(thestaff.getPhone());
		user.setRoles(thestaff.getRoles());
		user.setUsername(thestaff.getUsername());
		user.setPassword(pass);
	
		userRepository.save(user);
		staff.setSchool(schoolRepository.findById(thestaff.getSchoolid()).get());
		staff.setUser(user);
		staffRepository.saveAndFlush(staff);
		if(user.getRoles().contains("teacher")) {
			Teacher teacher=new Teacher();
			teacher.setAstutor(false);
			teacher.setStaff(staff);
			
			Weeklytimetable wt=new Weeklytimetable();
			teacherRepository.saveAndFlush(teacher);
			wt.setTeacher(teacher);
			
			weeklytimetableRepository.saveAndFlush(wt);
		}
		TemporalCridentials tc=new TemporalCridentials(thestaff.getUsername(),pass);
		return tc;
	}

	public List<Staff> getIdleTechears() {
		List<Staff> idleTechears=new ArrayList<>();
		staffRepository.findAllByUserRolesOrUserRolesAndUserActive("user,teacher","teacher",false).forEach(idleTechears::add);
		
		return idleTechears;
	}

	public void patchUser(Userpatch up) {
	User user=userRepository.findById(up.getId()).get();
	user.setActive(true);
	user.setPhone(up.getPhone());
	user.setPassword(up.getPassword());
	userRepository.saveAndFlush(user);
	}

	public List<Combination> getSchoolSchooloptions(int schoolid) {
		
		List<Combination> combinations=new ArrayList<>();
		schooloptionRepository.findAllBySchoolId(schoolid).forEach(combinations::add);
		return combinations;
	}

	public List<Combinationprototype> Combinationprototypes() {
		List<Combinationprototype> combinationprototypes=new ArrayList<>(); 
		combinationprototypeRepository.findAll().forEach(combinationprototypes::add);
		return combinationprototypes;
	}

	public Combinationcomplete getCombination(int combinationid) {
		Combinationcomplete cm_tp=new Combinationcomplete();
		Combinationprototype	combinationprototype=combinationprototypeRepository.findById(combinationid).get();
		if(combinationprototype!=null) {
			
			cm_tp.setId(combinationprototype.getId());
			cm_tp.setDescription(combinationprototype.getDescription());
			cm_tp.setName(combinationprototype.getName());
			List<Levelprototype> lps=levelprototypeRepository.findAllByCombinationprototypeId(combinationid);
			List<Levelcomplete> l_tps=new ArrayList<>();
			for(Levelprototype lp:lps) {
				Levelcomplete l_pt=new Levelcomplete();
			List<Courseprototype>	cps=courseprototypeRepository.findAllByLevelprototypeId(lp.getId());
			List<Coursecomplete> c_tps=new ArrayList<>();
			    for(Courseprototype cp:cps) {
			    	Coursecomplete c_pt=new Coursecomplete();
			    	c_pt.setHourz(cp.getHourz());
			    	c_pt.setId(cp.getId());
			    	c_pt.setLevel(lp.getName());
			    	c_pt.setName(cp.getName());
			    	c_pt.setImportance(cp.getImportance());
			    	c_tps.add(c_pt);
			    }
			    l_pt.setId(lp.getId());
			    l_pt.setLevel(lp.getName());
			    l_pt.setLevelcourses(c_tps);
			   l_tps.add(l_pt); 
			}
			cm_tp.setCombinationlevels(l_tps);
		}
		
		return cm_tp;
	}

	public List<Aclass> getAllClassesSchool(int schoolid) {
		List<Aclass> schoolclasses=aclassRepository.findAllBySchooloptionSchoolId(schoolid);
		
		return  schoolclasses;
	}

	public List<Bulletin> getBulltins() {
		
		List<Bulletin> bulletins=new ArrayList<>();
		bullettinrepository.findAll().forEach(bulletins::add);
		return bulletins;
	}


	public static byte[] decompressBytes(byte[] data) {
	    Inflater inflater = new Inflater();
	    inflater.setInput(data);
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	    byte[] buffer = new byte[1024];
	    try {
	        while (!inflater.finished()) {
	            int count = inflater.inflate(buffer);
	            outputStream.write(buffer, 0, count);
	        }
	        outputStream.close();
	    } catch (IOException ioe) {
	    } catch (DataFormatException e) {
	    }
	    return outputStream.toByteArray();
	}

	public List<Coursetime> getClasstimetable(int classid) {
		
		return coursetimeRepository.findByCurrentclassClassid(classid);
	}

	public List<TeacherGetDTO> getSchoolTeachers(int schoolid) {
		
		List<TeacherGetDTO> schoolTeachersGet=new ArrayList<>();
		List<Teacher> schoolTeachers=new ArrayList<>();
		teacherRepository.findByStaffSchoolId(schoolid).stream().forEach(schoolTeachers::add);
		
		for(Teacher teacher:schoolTeachers) {
			Weeklytimetable wkttb=weeklytimetableRepository.findByTeacherTeacherid(teacher.getTeacherid());
		   List<Coursetime>  coursetimes=coursetimeRepository.findAllByWeeklytimetableId(wkttb.getId()); 
		
			TeacherGetDTO techergetdto=new TeacherGetDTO(teacher.getTeacherid(),teacher.getStaff().getUser().getFirstname(),
					
					teacher.getStaff().getUser().getLastname(),teacher.getStaff().getUser().getMidlename(),wkttb
					,coursetimes,45);
			schoolTeachersGet.add(techergetdto);
		}
		return schoolTeachersGet;
	}
	

}
