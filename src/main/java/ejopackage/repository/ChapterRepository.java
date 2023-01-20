package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.curriculum.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter,Integer>{

}
