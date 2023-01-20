package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.sytem.Systemmanager;

public interface SystemManagerRepository extends JpaRepository<Systemmanager,String> {

	Systemmanager	  findByEducationsytem(String Systemmanager);
}
