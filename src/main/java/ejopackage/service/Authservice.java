package ejopackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejopackage.helper.Authenticationrequest;
import ejopackage.helper.StaffDTO;
import ejopackage.model.Dos;
import ejopackage.model.Registrar;
import ejopackage.model.School;
import ejopackage.model.User;
import ejopackage.repository.DosRepository;
import ejopackage.repository.RegistrarRepsoistory;
import ejopackage.repository.SchoolRepository;
import ejopackage.repository.StaffRepository;
import ejopackage.repository.UserRepository;

@Service
public class Authservice {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	DosRepository dosRepository;

	@Autowired
	RegistrarRepsoistory  registrarRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	public User getTheUser(Authenticationrequest authReq) {
		User TheUser=userRepository.findByUsernameAndPassword(authReq.getUsername(), authReq.getPassword());
		return TheUser;
	}

	public StaffDTO getTheUserStaff(Authenticationrequest authReq) {
		 School school;
		 StaffDTO  staffdto=new StaffDTO();
		User TheUser=userRepository.findByUsernameAndPassword(authReq.getUsername(), authReq.getPassword());
		if(TheUser!=null) {
			  Dos dos=dosRepository.findByUserId(TheUser.getId());
			  Registrar reg=registrarRepository.findByUserId(TheUser.getId());
				
				if(dos!=null)
				{
					school=schoolRepository.findByDosId(dos.getId());
				
					 staffdto.setFname(TheUser.getFirstname());
					 staffdto.setLname(TheUser.getLastname());
					 staffdto.setSchooladdress(school.getAddress());
					 staffdto.setSchoolcontact(school.getContact());
					 staffdto.setSchoolwebsite(school.getWebsite());
					 
					 staffdto.setUserid(TheUser.getId());
					 staffdto.setSchoolname(school.getName());
					 staffdto.setSchoolid(school.getId());
					 staffdto.setRoles(TheUser.getRoles());
				
				}
				else if(reg!=null) {
					school=schoolRepository.findByRegistrarId(reg.getId());
					
					 staffdto.setFname(TheUser.getFirstname());
					 staffdto.setLname(TheUser.getLastname());
					 staffdto.setSchooladdress(school.getAddress());
					 staffdto.setSchoolcontact(school.getContact());
					 staffdto.setSchoolwebsite(school.getWebsite());
					 staffdto.setSchoolname(school.getName());
					 staffdto.setUserid(TheUser.getId());
					 
					 staffdto.setSchoolid(school.getId());
					 staffdto.setRoles(TheUser.getRoles());
					
					
					
				}
			
			
		}else {
			staffdto=null;
		}
		return staffdto;
	}
	
	

}
