package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Course;



public interface CourseRepository  extends JpaRepository<Course,Integer> {

	List<Course>  findAllByCombinationIdAndLevel(int combinationid,int level);

	List<Course> findByCourseprototypeIdAndCombinationIdAndLevel(int courseid, int id, int level);
}
