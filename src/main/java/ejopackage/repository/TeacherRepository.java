package ejopackage.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ejopackage.model.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

	
	Teacher  findByStaffUserId(int userid);

	List<Teacher> findByStaffSchoolId(int schoolid);
}
