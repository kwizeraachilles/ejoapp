package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Coursemarks;

public interface CoursemarksRepository extends JpaRepository<Coursemarks,Integer>{

	List<Coursemarks> findAllByStudentId(int studentid);
}
