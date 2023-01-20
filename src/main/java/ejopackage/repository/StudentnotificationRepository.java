package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Studentnotification;



public interface StudentnotificationRepository extends JpaRepository<Studentnotification,Integer>{

	List<Studentnotification> findAllByStudentId(int studentid);

}
