package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.curriculum.Subchapter;

public interface SubchapterRepository  extends JpaRepository<Subchapter,Integer> {

}
