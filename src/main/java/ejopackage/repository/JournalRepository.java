package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Journal;



public interface JournalRepository extends JpaRepository<Journal,Integer>{

	List<Journal> findAllByStudentId(int studentid);
	List<Journal> findAllByViewedAndStudentId(boolean viewed,int studentid);

}
