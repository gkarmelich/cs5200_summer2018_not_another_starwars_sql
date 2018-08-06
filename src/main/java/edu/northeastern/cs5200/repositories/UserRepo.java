package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.objects.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	@Query("SELECT x FROM User x WHERE x.firstName=:firstName AND x.lastName=:lastName")
	User findPersonByName (
			@Param("firstName") String firstName,
			@Param("lastName") String lastName);

}
