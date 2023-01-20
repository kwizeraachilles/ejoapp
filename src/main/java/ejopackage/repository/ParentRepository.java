package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Parent;


public interface ParentRepository extends JpaRepository<Parent,Integer>{

	Parent findByUserId(int userid);
	
	

}
