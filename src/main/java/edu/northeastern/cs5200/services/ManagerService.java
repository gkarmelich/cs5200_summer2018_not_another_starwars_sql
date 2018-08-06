package edu.northeastern.cs5200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.ManagerDao;
import edu.northeastern.cs5200.objects.Manager;
import edu.northeastern.cs5200.repositories.ManagerRepo;

@RestController
@RequestMapping("/api")
public class ManagerService {
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ManagerRepo managerRepo;
	
	@GetMapping("/manager")
	public List<Manager> findAllManagers() {
		return managerDao.findAllManagers();
	}
	
	@PostMapping("/manager")
	public void createActor(@RequestBody Manager manager) {
		managerDao.createManager(manager.getFirstName(), manager.getLastName(), manager.getUserName(), manager.getPassword(),
				manager.getEmail(), manager.getDob());
	}

}
