package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Levelprototype;

public interface LevelPrototypeRepository  extends JpaRepository<Levelprototype,Integer>{
List<Levelprototype>  findAllByCombinationprototypeId(int cp);
}
