package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Manager;
import edu.northeastern.cs5200.repositories.ManagerRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class ManagerDao {
	
	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public List<Manager> findAllManagers() {
		List<Manager> managers = new ArrayList<>();
		managers =  (List<Manager>) managerRepo.findAll();
		return managers;
	}
	
	public void createManager(String firstName, String lastName, String userName, String password, String email,
			Date dob) {
		Manager manager = new Manager(firstName, lastName, userName, password, email, dob, null, null);
		managerRepo.save(manager);
	}
	
	
	public void test() {
		Date dob = new Date(10000000);
		this.createManager("Ryan", "Kalla", "rkalla", "password1", "rkalla@hotmail.com", dob);
		
	}

}
