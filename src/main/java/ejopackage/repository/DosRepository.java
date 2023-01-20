package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Dos;

public interface DosRepository extends JpaRepository<Dos,Integer> {

	Dos findByUserId(int id);

}
