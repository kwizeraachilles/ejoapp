package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.School;



public interface SchoolRepository  extends JpaRepository<School,Integer> {

	School findByDosId(int id);

	School findByRegistrarId(int id);

}
