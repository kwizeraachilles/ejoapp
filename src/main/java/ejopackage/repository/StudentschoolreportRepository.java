package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Studentschoolreport;



public interface StudentschoolreportRepository extends JpaRepository<Studentschoolreport,Integer>{

	List<Studentschoolreport> findAllByStudentId(int studentid);

}
