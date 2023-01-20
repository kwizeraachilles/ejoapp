package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Combination;



public interface CombinationRepository extends JpaRepository<Combination,Integer> {
List<Combination>  findAllBySchoolId(int schoolid);
Combination findByCombinationprototypeId(int comprotoid);
}
