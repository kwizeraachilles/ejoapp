package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Registrar;

public interface RegistrarRepsoistory extends JpaRepository<Registrar,Integer>{

	Registrar findByUserId(int id);

}
