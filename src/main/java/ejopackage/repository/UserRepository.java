package ejopackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
User findByUsernameAndPassword(String username,String password);

}
