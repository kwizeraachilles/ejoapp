package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Student;



public interface StudentRepository extends JpaRepository<Student,Integer>{

	
	List<Student> findAllByParentId(int parentid);

	List<Student> findAllByStudentclassClassid(int classid);
	
	List<Student> findAllByGuidianonenidOrGuidiantwonid(String nid,String nid2);
}
