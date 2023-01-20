package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Bulletin;

public interface BulletinRepository extends JpaRepository<Bulletin,Long>{
	
	Bulletin findByStudentIdAndClassidAndSigned(int studentid,int level,boolean signed);

	Bulletin findByStudentId(int studentid);

}
