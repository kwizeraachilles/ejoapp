package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Staff;

public interface StaffRepository  extends JpaRepository<Staff,Integer> {
	List<Staff> findAllByUserRolesOrUserRolesAndUserActive(String rol1,String ro2,boolean active);
	 Staff findByUserId(int userid);
}
