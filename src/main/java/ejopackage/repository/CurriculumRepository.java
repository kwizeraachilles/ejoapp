package ejopackage.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.curriculum.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum,Integer>{

}
