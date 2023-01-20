package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Aclass;
import ejopackage.model.School;



public interface AclassRepository extends JpaRepository<Aclass,Integer>{

	List<Aclass> findAllBySchooloptionSchoolId(int schoolid);

}
