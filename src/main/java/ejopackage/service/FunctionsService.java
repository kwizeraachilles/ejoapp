package ejopackage.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejopackage.helper.Coursetimer;
import ejopackage.helper.Days;
import ejopackage.helper.Gridtimer;
import ejopackage.model.Aclass;
import ejopackage.model.Combinationprototype;
import ejopackage.model.Course;
import ejopackage.model.Courseprototype;
import ejopackage.model.Coursetime;
import ejopackage.model.Levelprototype;
import ejopackage.model.timetable.Courseunit;
import ejopackage.repository.AclassRepository;
import ejopackage.repository.CourseprototypeRepository;
import ejopackage.repository.CourseunitRepository;
import ejopackage.repository.LevelPrototypeRepository;
@Service
public class FunctionsService {

	@Autowired
	 CourseunitRepository courseunitRepository;
	
	@Autowired
	CourseprototypeRepository courseprototypeRepository;
	
	@Autowired
	AclassRepository aclassRepository;
	
	@Autowired
	 LevelPrototypeRepository  levelPrototypeRepository;
  
	public void addCourseunit(Courseunit courseunit) {
		
		courseunitRepository.save(courseunit);
		
	}

	public List<Courseunit> getCourseunites() {
	
		List<Courseunit> courseunits=new ArrayList<>();
		courseunitRepository.findAll().forEach(courseunits::add);
		return courseunits;
	}
	
	void generateAlgA(int classid){
	
		Combinationprototype comb=aclassRepository.findById(classid).get().getSchooloption().getCombinationprototype();
		int levelid= aclassRepository.findById(classid).get().getLevel();
		List<Levelprototype> lps=levelPrototypeRepository.findAllByCombinationprototypeId(comb.getId());
		for(Levelprototype lp:lps) {
			if(lp.getName()==levelid) {
				
				 List<Courseprototype> courseprototype=	courseprototypeRepository.findAllByLevelprototypeId(lp.getId());
			}
		}
		
		
	}
	List<Coursetime>  timetabler(Aclass aclass){
		List<Coursetime>  coursetimes=new ArrayList<>();
		List<Coursetimer> cts=courseArranger(aclass.getCourses());
		
		gridMaker(cts).stream().map(gm->new Coursetime(gm.getDayindex(),gm.getWeekday(),gm.getCourse(),aclass)).forEach(coursetimes::add);
	
	  
		return coursetimes;
	}
	List<Coursetimer> courseArranger(List<Course> courses){
		List<Course> mc=new ArrayList<>();
		List<Coursetimer> mct=new ArrayList<>();
		int ml=0;
		List<Course> mnc=new ArrayList<>();
		List<Coursetimer> mnct=new ArrayList<>();
		int nl=0;
		List<Course> mo=new ArrayList<>();
		List<Coursetimer> mot=new ArrayList<>();
		int ol=0;
		List<Coursetimer> arrangedCourses=new ArrayList<>();
	for	(Course crs:courses) {
		
		    if(crs.getImportance()==3) { 
		    	ml=crs.getHourz();
		    	mc.add(crs);}
		    else if(crs.getImportance()==2) {
		    	nl=crs.getHourz();
		    	mnc.add(crs);}
		    else if(crs.getImportance()==1) {
		    	ol=crs.getHourz();
		    	mo.add(crs);}
	}
	
	for(int i=0;i<mc.size()*ml;i++) {
		mct.add(new Coursetimer(i,mc.get(0)));
		
	}
	for(int i=0;i<mnc.size()*nl;i++) {
		mnct.add(new Coursetimer(i,mnc.get(0)));
		
	}
	for(int i=0;i<mo.size()*ol;i++) {
		mot.add(new Coursetimer(i,mo.get(0)));
		
	}
	Collections.shuffle(mct);
	Collections.shuffle(mnct);
	Collections.shuffle(mot);
	arrangedCourses.addAll(mct);
	arrangedCourses.addAll(mnct);
	arrangedCourses.addAll(mot);
		
		return arrangedCourses;
	}
	List<Gridtimer> gridMaker(List<Coursetimer> courseslist) {
		List<Gridtimer>  grided=new ArrayList<>();
	   int i=0;
		int x=0;
		int y=0;
		int z=0;
		int v=0;
		int w=0;
		for(Coursetimer ct:courseslist) {
			
			int n=(i%5)+1;
			if(n==1) {
				
				
				grided.add(new Gridtimer(x+1,Days.Monday,ct.getCourse()));
			x++;
			}
			if(n==2) {
			
				
				grided.add(new Gridtimer(y+1,Days.Tuesday,ct.getCourse()));
				y++;
				
			}
			if(n==3) {
				
				
				grided.add(new Gridtimer(z+1,Days.Wednesday,ct.getCourse()));
				z++;
				
			}
			if(n==4) {
			
				
				grided.add(new Gridtimer(v+1,Days.Thursday,ct.getCourse()));
				v++;
				
			}
			if(n==1) {
			
				
				grided.add(new Gridtimer(w+1,Days.Friday,ct.getCourse()));
				w++;
				
			}
	i++;
		}
	
		return grided;
		
	}

	
}
