package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Attendance;



public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{

	List<Attendance> findAllByStudentId(int studentid);
	List<Attendance> findAllByCheckedAndStudentId(boolean checked,int studentid);
	List<Attendance> findAllByCheckedAndStudentIdAndAttended(boolean checked,int studentid,boolean state);
}
