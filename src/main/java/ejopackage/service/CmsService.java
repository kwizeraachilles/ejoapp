package ejopackage.service;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ejopackage.helper.Bloomdto;
import ejopackage.helper.Combid;
import ejopackage.helper.CombinationDTO;
import ejopackage.helper.CourseDTO;
import ejopackage.helper.GenericResponse;
import ejopackage.helper.SchoolDTO;
import ejopackage.helper.Tempadminscredentials;
import ejopackage.model.Bloomindex;
import ejopackage.model.Bloomrate;
import ejopackage.model.Bulletinprototype;
import ejopackage.model.Combination;
import ejopackage.model.Combinationprototype;

import ejopackage.model.Coursebulletinprototype;
import ejopackage.model.Coursecategory;
import ejopackage.model.Courseprototype;
import ejopackage.model.Dos;
import ejopackage.model.Levelprototype;
import ejopackage.model.Registrar;
import ejopackage.model.School;
import ejopackage.model.Schoolcalender;
import ejopackage.model.User;
import ejopackage.repository.BloomindexRepository;
import ejopackage.repository.BloommetricsRepository;
import ejopackage.repository.BloomrateRepository;
import ejopackage.repository.BulletinprotoypeRepository;
import ejopackage.repository.CombinationRepository;
import ejopackage.repository.CombinationprototypeRepository;
import ejopackage.repository.CourseBulletinprototypeRepository;
import ejopackage.repository.CoursecategoryRepository;
import ejopackage.repository.CourseprototypeRepository;
import ejopackage.repository.DosRepository;
import ejopackage.repository.LevelPrototypeRepository;
import ejopackage.repository.RegistrarRepsoistory;
import ejopackage.repository.SchoolRepository;
import ejopackage.repository.SchoolcalenderRepository;
import ejopackage.repository.SystemManagerRepository;
import ejopackage.repository.UserRepository;

@Service
public class CmsService {
	@Autowired
   BloomrateRepository  bloomraterepository;
  @Autowired
  SystemManagerRepository systemManagerRepository;
	
	@Autowired
	CoursecategoryRepository coursecategoryRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	SchoolcalenderRepository schoolcalenderRepository;
	
	@Autowired
	CombinationRepository combinationrepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DosRepository dosRepository;
	@Autowired
	RegistrarRepsoistory  registrarRepository;
	@Autowired
	LevelPrototypeRepository levelprototypeRepository;
	
	@Autowired
	CombinationprototypeRepository  combinationprototypeRepository;
	
	 @Autowired
	 CourseprototypeRepository courseprotoypeRepository;
	 
		@Autowired
		BloommetricsRepository bloommetricsRepository;
	
	 @Autowired
	 BloomindexRepository 	bloomindexRepository;
	 
		@Autowired
		BulletinprotoypeRepository bulletinprotoypeRepository;
		
		@Autowired
		CourseBulletinprototypeRepository coursebulletinprototypeRepository;

      
	public void regesterBloomdto(Bloomdto bloomdto) {
		 String sm="ea";
		Bloomrate bloomrate=new Bloomrate();
		bloomrate.setAnalyzing(bloomdto.getAnalyzing());
		bloomrate.setApplying(bloomdto.getApplying());
		bloomrate.setCreating(bloomdto.getCreating());
		bloomrate.setEvaluating(bloomdto.getEvaluating());
		bloomrate.setRemembering(bloomdto.getRemembering());
		bloomrate.setUnderstanding(bloomdto.getUnderstanding());
		bloomrate.setDescription(bloomdto.getName());
		bloomraterepository.saveAndFlush(bloomrate);
		
		Coursecategory coursecategory=new Coursecategory();
		coursecategory.setBloomrate(bloomrate);
		coursecategory.setName(bloomdto.getName());
		
		coursecategory.setSystemmanager(systemManagerRepository.findById(sm).get());
		 
		coursecategoryRepository.saveAndFlush(coursecategory);
		
	}




	public void updateBloomdto(Bloomdto bloomdto, int coursecategoryid) {
		
	Coursecategory cc=coursecategoryRepository.findById(coursecategoryid).get();
	Bloomrate bloomrate=cc.getBloomrate();
	bloomrate.setAnalyzing(bloomdto.getAnalyzing());
	bloomrate.setApplying(bloomdto.getApplying());
	bloomrate.setCreating(bloomdto.getCreating());
	bloomrate.setEvaluating(bloomdto.getEvaluating());
	bloomrate.setRemembering(bloomdto.getRemembering());
	bloomrate.setUnderstanding(bloomdto.getUnderstanding());
	bloomrate.setDescription(bloomdto.getName());
	bloomraterepository.saveAndFlush(bloomrate);
	cc.setName(bloomdto.getName());
	coursecategoryRepository.saveAndFlush(cc);
	}
	
	

	public GenericResponse<Object, Integer> addSchool(SchoolDTO schooldto) {
		String sm="ea";
		School school=new School();
		User userdos=new User();
		userdos.setRoles("dos");
		userdos.setNationalid(codemaker(schooldto.getName(),schooldto.getAddress())+"_DOS");
		userdos.setPhone(schooldto.getContact());
		userdos.setInitiated(LocalDateTime.now());
		userdos.setFirstname(schooldto.getName()+"_DOS");
		String du=codemaker(schooldto.getName(),schooldto.getAddress())+"DOS";
		userdos.setUsername(du);
		String dpass=passmaker(schooldto.getName(),schooldto.getAddress(),schooldto.getEmail());
		userdos.setPassword(dpass);
		
		User useradmin=new User();
		useradmin.setRoles("admin");
		useradmin.setNationalid(codemaker(schooldto.getName(),schooldto.getAddress())+"_ADMIN");
		useradmin.setPhone(schooldto.getContact());
		useradmin.setInitiated(LocalDateTime.now());
		useradmin.setFirstname(schooldto.getName()+"_ADMIN");
		String au=codemaker(schooldto.getName(),schooldto.getAddress())+"ADMIN";
		useradmin.setUsername(au);
		String apass=passmaker(schooldto.getName(),schooldto.getAddress(),schooldto.getEmail());
		useradmin.setPassword(apass);
		
		school.setAddress(schooldto.getAddress());
		school.setContact(schooldto.getContact());
		school.setEmail(schooldto.getEmail());
		school.setName(schooldto.getName());
		school.setWebsite(schooldto.getWebsite());
		school.setSystemmanager(systemManagerRepository.findById(sm).get());
		school.setSystemaccountname(schooldto.getName());
		school.setSystempassword(passmaker(schooldto.getName(),schooldto.getAddress(),schooldto.getEmail()));
		school.setSytemcode(codemaker(schooldto.getName(),schooldto.getAddress()));
		Schoolcalender sc=new Schoolcalender();
		schoolcalenderRepository.saveAndFlush(sc);
        userRepository.saveAndFlush(userdos);
        userRepository.saveAndFlush(useradmin);
        Registrar registrar=new Registrar();
        Dos dos=new Dos();
        registrarRepository.saveAndFlush(registrar);
        dosRepository.saveAndFlush(dos);
        dos.setUser(userdos);
        registrar.setUser(useradmin);
        
        school.setRegistrar(registrar);
        school.setDos(dos);
		school.setSchoolcalender(sc);
  
		//intiialization of classes and  courses
		
	
		
		
		
		schoolRepository.saveAndFlush(school);
	
		
		if(!schooldto.getCombinationsids().isEmpty()) {
		
			List<Integer> tempcombids=new ArrayList<>();
			Set<Combid> tset=new HashSet<>();
			
			for(Combid tci:schooldto.getCombinationsids()) {
			
				if(!tempcombids.contains(tci.getCombid())) {
					tset.add(tci);
					tempcombids.add(tci.getCombid());
				}
			}
			for(Combid  ci:tset) {
				Optional<Combinationprototype> oc=combinationprototypeRepository.findById(ci.getCombid());
			
				
				if(oc.isPresent()) {
				
						Combinationprototype co=oc.get();	
					
					Combination  newc=new Combination();
					newc.setName(co.getName());
					newc.setCombinationprototype(co);
					newc.setSchool(school);
					combinationrepository.save(newc);
				   
		    
				
				}
			}
			
			
		}
	
		
	
		
	
		
	return	new GenericResponse<Object, Integer>(true,school.getId(),"Schoolregistrered ",school);
	}

	String passmaker(String name,String address ,String email) {
		int anyumber =(int) Math.floor(Math.random()*1000000);
		Integer namecode=name.hashCode();
		Integer addresscode=address.hashCode();
		Integer emailcode=email.hashCode();
	return	Integer.toHexString((namecode & addresscode |namecode & emailcode)^anyumber);
	
	}
	String codemaker(String name,String address) {
		
		String addresscode=address.replaceAll("\\s+","").substring(0,3);
		String namecode=name.replaceAll("\\s+","").substring(0,2);
		
	return	  addresscode.toUpperCase()+namecode.toUpperCase();
	
	}




	public void addCombination(CombinationDTO combinationdto) {
	
		Combinationprototype combinationprototype=new  	Combinationprototype();
		combinationprototype.setName(combinationdto.getName());
		combinationprototype.setDescription(combinationdto.getDescription());
		combinationprototypeRepository.save(combinationprototype);

		 if(!combinationdto.getLevelOne().isEmpty()) {
			 Levelprototype lp=new Levelprototype();
			 lp.setName(1);
			 lp.setCreated(LocalDateTime.now());
			 lp.setDescription("Level One");
			 lp.setCombinationprototype(combinationprototype);

	
			 
			 
			 List<Coursebulletinprototype>  coursebulletinprotoype=new ArrayList<>();
			 levelprototypeRepository.saveAndFlush(lp);
			 List<Courseprototype> courseprototypes=new ArrayList<>();
			
				for(CourseDTO cdto:combinationdto.getLevelOne()) {
					Optional<Coursecategory>  oct=coursecategoryRepository.findById(cdto.getCoursecategoryid());
					if(oct.isPresent()) {
						
						Courseprototype cp=new Courseprototype();
						cp.setCoursecategory(oct.get());
						cp.setHourz(cdto.getHourz());
						cp.setImportance(cdto.getImportance());
						cp.setName(cdto.getCoursename());
						cp.setLevelprototype(lp);
						courseprotoypeRepository.saveAndFlush(cp);
						  Coursebulletinprototype coursebulletinprototype =new Coursebulletinprototype();
						  coursebulletinprototype.setCourseid(cp.getId());
						  coursebulletinprototype.setCoursename(cp.getName());
						  coursebulletinprototype.setImportance(cp.getImportance());
						  coursebulletinprototype.setUpdated(LocalDateTime.now());
						  courseprototypes.add(cp);
						  coursebulletinprototypeRepository.saveAndFlush(coursebulletinprototype);
						  coursebulletinprotoype.add(coursebulletinprototype);
						  
						
			//	bulletinprotoypeRepository;
							
				
				
						  
						
					}
			  
			
				                                            }
				lp.setMaxhourz(getMaxhours(courseprototypes));
				 Bulletinprototype bulletinprototype=new Bulletinprototype();
				 bulletinprototype.setLevel(1);
				 bulletinprototype.setMainpermarks(70);
				 bulletinprototype.setMandatorypermarks(40);
				 bulletinprototype.setOptionalpermarks(20);
				 bulletinprototype.setSigned(false);
				 bulletinprototype.setUpdated(LocalDateTime.now());
				 bulletinprototype.setCoursebulletinprototypes(coursebulletinprotoype);
				
				 bulletinprotoypeRepository.save( bulletinprototype);
				 lp.setBulletinprototype(bulletinprototype);
				 levelprototypeRepository.saveAndFlush(lp);
				
				
				//making bloomindexes
				Bloomindex bi=new Bloomindex();
				List<Courseprototype> coprots=courseprotoypeRepository.findAllByLevelprototypeId(lp.getId());
				double analyz=0;
				double applz=0;
				double rembz=0;
				double undz=0;
				double crez=0;
				double evalz=0;
				if(!coprots.isEmpty()) {
				
					for(Courseprototype copro:coprots) {
						double az=copro.getCoursecategory().getBloomrate().getAnalyzing();
						double appl=copro.getCoursecategory().getBloomrate().getApplying();
						double remb=copro.getCoursecategory().getBloomrate().getRemembering();
						double und=copro.getCoursecategory().getBloomrate().getUnderstanding();
						double cre=copro.getCoursecategory().getBloomrate().getCreating();
						double eval=copro.getCoursecategory().getBloomrate().getEvaluating();
						analyz=analyz+az;
						applz=applz+appl;
						rembz=rembz+remb;
						undz=undz+und;
						crez=crez+cre;
						evalz=evalz+eval;
						
					}
					
				
		
				}
				
				
				bi.setAnalyzingindex(normalize(analyz));
				bi.setApplyingindex(normalize(applz));
				bi.setCreatingindex(normalize(crez));
				bi.setEvaluatingindex(normalize(evalz));
				bi.setRememberingindex(normalize(rembz));
				bi.setUnderstandingindex(normalize(undz));
				
				bloomindexRepository.save(bi);
				
				lp.setBloomindex(bi);
				levelprototypeRepository.saveAndFlush(lp);
				
		          }
		 if(!combinationdto.getLevelTwo().isEmpty()) {
			 Levelprototype lp=new Levelprototype();
			 lp.setName(2);
			 lp.setCreated(LocalDateTime.now());
			 lp.setDescription("Level Two");
			 lp.setCombinationprototype(combinationprototype);
			 levelprototypeRepository.save(lp);
			 List<Coursebulletinprototype>  coursebulletinprotoype=new ArrayList<>();
			 List<Courseprototype> courseprototypes=new ArrayList<>();
			 
				for(CourseDTO cdto:combinationdto.getLevelTwo()) {
					
					Optional<Coursecategory>  oct=coursecategoryRepository.findById(cdto.getCoursecategoryid());
					if(oct.isPresent()) {
						Courseprototype cp=new Courseprototype();
						cp.setCoursecategory(oct.get());
						cp.setHourz(cdto.getHourz());
						cp.setImportance(cdto.getImportance());
						cp.setName(cdto.getCoursename());
						cp.setLevelprototype(lp);
						courseprotoypeRepository.save(cp);
						  Coursebulletinprototype coursebulletinprototype =new Coursebulletinprototype();
						  coursebulletinprototype.setCourseid(cp.getId());
						  coursebulletinprototype.setCoursename(cp.getName());
						  coursebulletinprototype.setImportance(cp.getImportance());
						  coursebulletinprototype.setUpdated(LocalDateTime.now());
						  courseprototypes.add(cp);
						  coursebulletinprototypeRepository.saveAndFlush(coursebulletinprototype);
						  coursebulletinprotoype.add(coursebulletinprototype);
					}
				                                           }
				
				lp.setMaxhourz(getMaxhours(courseprototypes));
				 Bulletinprototype bulletinprototype=new Bulletinprototype();
				 bulletinprototype.setLevel(2);
				 bulletinprototype.setMainpermarks(70);
				 bulletinprototype.setMandatorypermarks(40);
				 bulletinprototype.setOptionalpermarks(20);
				 bulletinprototype.setSigned(false);
				 bulletinprototype.setUpdated(LocalDateTime.now());
				 bulletinprototype.setCoursebulletinprototypes(coursebulletinprotoype);
				 bulletinprotoypeRepository.save( bulletinprototype);
				 lp.setBulletinprototype(bulletinprototype);
				 levelprototypeRepository.saveAndFlush(lp);
				
				
				//making bloomindexes
				Bloomindex bi=new Bloomindex();
				List<Courseprototype> coprots=courseprotoypeRepository.findAllByLevelprototypeId(lp.getId());
				double analyz=0;
				double applz=0;
				double rembz=0;
				double undz=0;
				double crez=0;
				double evalz=0;
				if(!coprots.isEmpty()) {
				
					for(Courseprototype copro:coprots) {
						double az=copro.getCoursecategory().getBloomrate().getAnalyzing();
						double appl=copro.getCoursecategory().getBloomrate().getApplying();
						double remb=copro.getCoursecategory().getBloomrate().getRemembering();
						double und=copro.getCoursecategory().getBloomrate().getUnderstanding();
						double cre=copro.getCoursecategory().getBloomrate().getCreating();
						double eval=copro.getCoursecategory().getBloomrate().getEvaluating();
						analyz=analyz+az;
						applz=applz+appl;
						rembz=rembz+remb;
						undz=undz+und;
						crez=crez+cre;
						evalz=evalz+eval;
						
					}
					
				
		
				}
				
				
				bi.setAnalyzingindex(normalize(analyz));
				bi.setApplyingindex(normalize(applz));
				bi.setCreatingindex(normalize(crez));
				bi.setEvaluatingindex(normalize(evalz));
				bi.setRememberingindex(normalize(rembz));
				bi.setUnderstandingindex(normalize(undz));
				
				bloomindexRepository.save(bi);
				
				lp.setBloomindex(bi);
				levelprototypeRepository.saveAndFlush(lp);
		          }
		 
		 if(!combinationdto.getLevelThree().isEmpty()) {
			 Levelprototype lp=new Levelprototype();
			 lp.setName(3);
			 lp.setCreated(LocalDateTime.now());
			 lp.setDescription("Level Three");
			 lp.setCombinationprototype(combinationprototype);
			 levelprototypeRepository.save(lp);
			 List<Coursebulletinprototype>  coursebulletinprotoype=new ArrayList<>();
			 List<Courseprototype> courseprototypes=new ArrayList<>();
				for(CourseDTO cdto:combinationdto.getLevelThree()) {
					
					Optional<Coursecategory>  oct=coursecategoryRepository.findById(cdto.getCoursecategoryid());
					if(oct.isPresent()) {
						Courseprototype cp=new Courseprototype();
						cp.setCoursecategory(oct.get());
						cp.setHourz(cdto.getHourz());
						cp.setImportance(cdto.getImportance());
						cp.setName(cdto.getCoursename());
						cp.setLevelprototype(lp);
						courseprotoypeRepository.save(cp);
						  Coursebulletinprototype coursebulletinprototype =new Coursebulletinprototype();
						  coursebulletinprototype.setCourseid(cp.getId());
						  coursebulletinprototype.setCoursename(cp.getName());
						  coursebulletinprototype.setImportance(cp.getImportance());
						  coursebulletinprototype.setUpdated(LocalDateTime.now());
						  courseprototypes.add(cp);
						  coursebulletinprototypeRepository.saveAndFlush(coursebulletinprototype);
						  coursebulletinprotoype.add(coursebulletinprototype);
					}
				                                           }
				
				
				lp.setMaxhourz(getMaxhours(courseprototypes));
				 Bulletinprototype bulletinprototype=new Bulletinprototype();
				 bulletinprototype.setLevel(3);
				 bulletinprototype.setMainpermarks(70);
				 bulletinprototype.setMandatorypermarks(40);
				 bulletinprototype.setOptionalpermarks(20);
				 bulletinprototype.setSigned(false);
				 bulletinprototype.setUpdated(LocalDateTime.now());
				 bulletinprototype.setCoursebulletinprototypes(coursebulletinprotoype);
				 bulletinprotoypeRepository.save( bulletinprototype);
				 lp.setBulletinprototype(bulletinprototype);
				 levelprototypeRepository.saveAndFlush(lp);
				
				
				//making bloomindexes
				Bloomindex bi=new Bloomindex();
				List<Courseprototype> coprots=courseprotoypeRepository.findAllByLevelprototypeId(lp.getId());
				double analyz=0;
				double applz=0;
				double rembz=0;
				double undz=0;
				double crez=0;
				double evalz=0;
				if(!coprots.isEmpty()) {
				
					for(Courseprototype copro:coprots) {
						double az=copro.getCoursecategory().getBloomrate().getAnalyzing();
						double appl=copro.getCoursecategory().getBloomrate().getApplying();
						double remb=copro.getCoursecategory().getBloomrate().getRemembering();
						double und=copro.getCoursecategory().getBloomrate().getUnderstanding();
						double cre=copro.getCoursecategory().getBloomrate().getCreating();
						double eval=copro.getCoursecategory().getBloomrate().getEvaluating();
						analyz=analyz+az;
						applz=applz+appl;
						rembz=rembz+remb;
						undz=undz+und;
						crez=crez+cre;
						evalz=evalz+eval;
						
					}
					
				
		
				}
				
				
				bi.setAnalyzingindex(normalize(analyz));
				bi.setApplyingindex(normalize(applz));
				bi.setCreatingindex(normalize(crez));
				bi.setEvaluatingindex(normalize(evalz));
				bi.setRememberingindex(normalize(rembz));
				bi.setUnderstandingindex(normalize(undz));
				
				bloomindexRepository.save(bi);
				
				lp.setBloomindex(bi);
				levelprototypeRepository.saveAndFlush(lp);
		          }
		 
		 if(!combinationdto.getLevelFour().isEmpty()) {
			 Levelprototype lp=new Levelprototype();
			 lp.setName(4);
			 lp.setCreated(LocalDateTime.now());
			 lp.setDescription("Level Four");
			 lp.setCombinationprototype(combinationprototype);
			 levelprototypeRepository.save(lp);
			 
			 List<Coursebulletinprototype>  coursebulletinprotoype=new ArrayList<>();
			 List<Courseprototype> courseprototypes=new ArrayList<>();
				for(CourseDTO cdto:combinationdto.getLevelFour()) {
					
					Optional<Coursecategory>  oct=coursecategoryRepository.findById(cdto.getCoursecategoryid());
					if(oct.isPresent()) {
						Courseprototype cp=new Courseprototype();
						cp.setCoursecategory(oct.get());
						cp.setHourz(cdto.getHourz());
						cp.setImportance(cdto.getImportance());
						cp.setName(cdto.getCoursename());
						cp.setLevelprototype(lp);
						courseprotoypeRepository.save(cp);
						  Coursebulletinprototype coursebulletinprototype =new Coursebulletinprototype();
						  coursebulletinprototype.setCourseid(cp.getId());
						  coursebulletinprototype.setCoursename(cp.getName());
						  coursebulletinprototype.setImportance(cp.getImportance());
						  coursebulletinprototype.setUpdated(LocalDateTime.now());
						  courseprototypes.add(cp);
						  coursebulletinprototypeRepository.saveAndFlush(coursebulletinprototype);
						  coursebulletinprotoype.add(coursebulletinprototype);
					}    }
				lp.setMaxhourz(getMaxhours(courseprototypes));
				 Bulletinprototype bulletinprototype=new Bulletinprototype();
				 bulletinprototype.setLevel(4);
				 bulletinprototype.setMainpermarks(70);
				 bulletinprototype.setMandatorypermarks(40);
				 bulletinprototype.setOptionalpermarks(20);
				 bulletinprototype.setSigned(false);
				 bulletinprototype.setUpdated(LocalDateTime.now());
				 bulletinprototype.setCoursebulletinprototypes(coursebulletinprotoype);
				 bulletinprotoypeRepository.save( bulletinprototype);
				 lp.setBulletinprototype(bulletinprototype);
				 levelprototypeRepository.saveAndFlush(lp);
				
				
				//making bloomindexes
				Bloomindex bi=new Bloomindex();
				List<Courseprototype> coprots=courseprotoypeRepository.findAllByLevelprototypeId(lp.getId());
				double analyz=0;
				double applz=0;
				double rembz=0;
				double undz=0;
				double crez=0;
				double evalz=0;
				if(!coprots.isEmpty()) {
				
					for(Courseprototype copro:coprots) {
						double az=copro.getCoursecategory().getBloomrate().getAnalyzing();
						double appl=copro.getCoursecategory().getBloomrate().getApplying();
						double remb=copro.getCoursecategory().getBloomrate().getRemembering();
						double und=copro.getCoursecategory().getBloomrate().getUnderstanding();
						double cre=copro.getCoursecategory().getBloomrate().getCreating();
						double eval=copro.getCoursecategory().getBloomrate().getEvaluating();
						analyz=analyz+az;
						applz=applz+appl;
						rembz=rembz+remb;
						undz=undz+und;
						crez=crez+cre;
						evalz=evalz+eval;
						
					}
					
				
		
				}
				
				
				bi.setAnalyzingindex(normalize(analyz));
				bi.setApplyingindex(normalize(applz));
				bi.setCreatingindex(normalize(crez));
				bi.setEvaluatingindex(normalize(evalz));
				bi.setRememberingindex(normalize(rembz));
				bi.setUnderstandingindex(normalize(undz));
				
				bloomindexRepository.save(bi);
				
				lp.setBloomindex(bi);
				levelprototypeRepository.saveAndFlush(lp);
		          }
		 
		 if(!combinationdto.getLevelFive().isEmpty()) {
			 Levelprototype lp=new Levelprototype();
			 lp.setName(5);
			 lp.setCreated(LocalDateTime.now());
			 lp.setDescription("Level Five");
			 lp.setCombinationprototype(combinationprototype);
			 levelprototypeRepository.save(lp);
			 
			 List<Coursebulletinprototype>  coursebulletinprotoype=new ArrayList<>();
			 List<Courseprototype> courseprototypes=new ArrayList<>();
				for(CourseDTO cdto:combinationdto.getLevelFive()) {
					
					Optional<Coursecategory>  oct=coursecategoryRepository.findById(cdto.getCoursecategoryid());
					if(oct.isPresent()) {
						Courseprototype cp=new Courseprototype();
						cp.setCoursecategory(oct.get());
						cp.setHourz(cdto.getHourz());
						cp.setImportance(cdto.getImportance());
						cp.setName(cdto.getCoursename());
						cp.setLevelprototype(lp);
						courseprotoypeRepository.save(cp);
						  Coursebulletinprototype coursebulletinprototype =new Coursebulletinprototype();
						  coursebulletinprototype.setCourseid(cp.getId());
						  coursebulletinprototype.setCoursename(cp.getName());
						  coursebulletinprototype.setImportance(cp.getImportance());
						  coursebulletinprototype.setUpdated(LocalDateTime.now());
						  courseprototypes.add(cp);
						  coursebulletinprototypeRepository.saveAndFlush(coursebulletinprototype);
						  coursebulletinprotoype.add(coursebulletinprototype);
					}
				                                           }
				lp.setMaxhourz(getMaxhours(courseprototypes));
				 Bulletinprototype bulletinprototype=new Bulletinprototype();
				 bulletinprototype.setLevel(5);
				 bulletinprototype.setMainpermarks(70);
				 bulletinprototype.setMandatorypermarks(40);
				 bulletinprototype.setOptionalpermarks(20);
				 bulletinprototype.setSigned(false);
				 bulletinprototype.setUpdated(LocalDateTime.now());
				 bulletinprototype.setCoursebulletinprototypes(coursebulletinprotoype);
				 bulletinprotoypeRepository.save( bulletinprototype);
				 lp.setBulletinprototype(bulletinprototype);
				 levelprototypeRepository.saveAndFlush(lp);
				
				
				//making bloomindexes
				Bloomindex bi=new Bloomindex();
				List<Courseprototype> coprots=courseprotoypeRepository.findAllByLevelprototypeId(lp.getId());
				double analyz=0;
				double applz=0;
				double rembz=0;
				double undz=0;
				double crez=0;
				double evalz=0;
				if(!coprots.isEmpty()) {
				
					for(Courseprototype copro:coprots) {
						double az=copro.getCoursecategory().getBloomrate().getAnalyzing();
						double appl=copro.getCoursecategory().getBloomrate().getApplying();
						double remb=copro.getCoursecategory().getBloomrate().getRemembering();
						double und=copro.getCoursecategory().getBloomrate().getUnderstanding();
						double cre=copro.getCoursecategory().getBloomrate().getCreating();
						double eval=copro.getCoursecategory().getBloomrate().getEvaluating();
						analyz=analyz+az;
						applz=applz+appl;
						rembz=rembz+remb;
						undz=undz+und;
						crez=crez+cre;
						evalz=evalz+eval;
						
					}
					
				
		
				}
				
				
				bi.setAnalyzingindex(normalize(analyz));
				bi.setApplyingindex(normalize(applz));
				bi.setCreatingindex(normalize(crez));
				bi.setEvaluatingindex(normalize(evalz));
				bi.setRememberingindex(normalize(rembz));
				bi.setUnderstandingindex(normalize(undz));
				
				bloomindexRepository.save(bi);
				
				lp.setBloomindex(bi);
				levelprototypeRepository.saveAndFlush(lp);
		          }
		 if(!combinationdto.getLevelSix().isEmpty()) {
			 Levelprototype lp=new Levelprototype();
			 lp.setName(6);
			 lp.setCreated(LocalDateTime.now());
			 lp.setDescription("Level Six");
			 lp.setCombinationprototype(combinationprototype);
			 levelprototypeRepository.save(lp);
			 
			 List<Coursebulletinprototype>  coursebulletinprotoype=new ArrayList<>();
			 List<Courseprototype> courseprototypes=new ArrayList<>();
				double per=0;
				for(CourseDTO cdto:combinationdto.getLevelSix()) {
				
					Optional<Coursecategory>  oct=coursecategoryRepository.findById(cdto.getCoursecategoryid());
					if(oct.isPresent()) {
						Courseprototype cp=new Courseprototype();
					
						cp.setCoursecategory(oct.get());
						cp.setHourz(cdto.getHourz());
						cp.setImportance(cdto.getImportance());
						cp.setName(cdto.getCoursename());
						cp.setLevelprototype(lp);
						  courseprototypes.add(cp);
						courseprotoypeRepository.save(cp);
						  Coursebulletinprototype coursebulletinprototype =new Coursebulletinprototype();
						  coursebulletinprototype.setCourseid(cp.getId());
						  coursebulletinprototype.setCoursename(cp.getName());
						  coursebulletinprototype.setImportance(cp.getImportance());
						  if(cp.getImportance()==3) {
							  per=per+70;
						  }
						  else  if(cp.getImportance()==2) {
							  per=per+40;
						  }
						  else  if(cp.getImportance()==1) {
							  per=per+20;
						  }
						  coursebulletinprototype.setUpdated(LocalDateTime.now());
						  coursebulletinprototypeRepository.saveAndFlush(coursebulletinprototype);
						  coursebulletinprotoype.add(coursebulletinprototype);
					}
				        
				}
				lp.setMaxhourz(getMaxhours(courseprototypes));
				 Bulletinprototype bulletinprototype=new Bulletinprototype();
				 bulletinprototype.setLevel(6);
				 bulletinprototype.setMainpermarks(70);
				 bulletinprototype.setMandatorypermarks(40);
				 bulletinprototype.setOptionalpermarks(20);
				 bulletinprototype.setSigned(false);
				 bulletinprototype.setPer(per);
				 bulletinprototype.setUpdated(LocalDateTime.now());
				 bulletinprototype.setCoursebulletinprototypes(coursebulletinprotoype);
				 
				 bulletinprotoypeRepository.save( bulletinprototype);
				 lp.setBulletinprototype(bulletinprototype);
				 levelprototypeRepository.saveAndFlush(lp);
				
				
				//making bloomindexes
				Bloomindex bi=new Bloomindex();
				List<Courseprototype> coprots=courseprotoypeRepository.findAllByLevelprototypeId(lp.getId());
				double analyz=0;
				double applz=0;
				double rembz=0;
				double undz=0;
				double crez=0;
				double evalz=0;
				if(!coprots.isEmpty()) {
				
					for(Courseprototype copro:coprots) {
						double az=copro.getCoursecategory().getBloomrate().getAnalyzing();
						double appl=copro.getCoursecategory().getBloomrate().getApplying();
						double remb=copro.getCoursecategory().getBloomrate().getRemembering();
						double und=copro.getCoursecategory().getBloomrate().getUnderstanding();
						double cre=copro.getCoursecategory().getBloomrate().getCreating();
						double eval=copro.getCoursecategory().getBloomrate().getEvaluating();
						analyz=analyz+az;
						applz=applz+appl;
						rembz=rembz+remb;
						undz=undz+und;
						crez=crez+cre;
						evalz=evalz+eval;
						
					}
					
				
		
				}
				
				
				bi.setAnalyzingindex(normalize(analyz));
				bi.setApplyingindex(normalize(applz));
				bi.setCreatingindex(normalize(crez));
				bi.setEvaluatingindex(normalize(evalz));
				bi.setRememberingindex(normalize(rembz));
				bi.setUnderstandingindex(normalize(undz));
				
				bloomindexRepository.save(bi);
				
				lp.setBloomindex(bi);
				levelprototypeRepository.saveAndFlush(lp);
				
		          }
		 
	
				
	}




	public List<Combinationprototype> getAllCombinationprotos() {
		List<Combinationprototype> combinationreposotories=new ArrayList<>();
		combinationprototypeRepository.findAll().forEach(combinationreposotories::add);
		return combinationreposotories;
	}
  double normalize(double sum) {
	  if(sum==0) {
		  return 0;
	  }
	  else {
		  return 1/sum;
	  }
  }

//additional  calssses
  
  
  private int  getMaxhours(List<Courseprototype>  cps) {
	  
	 int maxhourz=0;
	    for(Courseprototype cp:cps) {
	    	maxhourz=maxhourz+cp.getHourz();
	    }
	  
	  return maxhourz;
	  
  }





public GenericResponse<Object, Integer> addSchoolLogo(int schoolid, MultipartFile schoollogo) throws IOException {
	

	School school=schoolRepository.findById(schoolid).get();
	byte[] logodata=compressBytes(schoollogo.getBytes());
	school.setLogo(logodata);
	if(schoolRepository.save(school)!=null) {

	return new  GenericResponse<Object, Integer>(true,0,"logo updated",null);
	
	} else {
		
		return new GenericResponse<Object, Integer>(false,0,"logo fial to update",null);
		
	}
}

public static byte[] compressBytes(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setInput(data);
    deflater.finish();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!deflater.finished()) {
        int count = deflater.deflate(buffer);
        outputStream.write(buffer, 0, count);
    }
    try {
        outputStream.close();
    } catch (IOException e) {
    }
    System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

    return outputStream.toByteArray();
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
}
