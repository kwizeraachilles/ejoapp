package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Coursetime;




public interface CoursetimeRepository extends JpaRepository<Coursetime,Integer> {

	List<Coursetime> findAllByWeeklytimetableId(int weeklytimetableid);

	List<Coursetime> findByCurrentclassClassid(int classid);
}
