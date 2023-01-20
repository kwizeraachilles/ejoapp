package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Courseprototype;

public interface CourseprototypeRepository extends JpaRepository <Courseprototype,Integer>{
	
	List<Courseprototype> findAllByLevelprototypeId(int li);

}
