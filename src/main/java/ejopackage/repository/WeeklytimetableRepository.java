package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Weeklytimetable;



public interface WeeklytimetableRepository extends JpaRepository<Weeklytimetable,Integer> {
Weeklytimetable findByTeacherTeacherid(int teacherid );
}
