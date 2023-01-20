package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.Marks;

public interface MarksRepository extends JpaRepository<Marks,Integer>
{
List<Marks>  findAllByStudentId(int studentId );

}
