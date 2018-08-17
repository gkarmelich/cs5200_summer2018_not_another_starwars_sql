package edu.northeastern.cs5200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public void createManager(@RequestBody Manager manager) {
		managerDao.createManager(manager.getFirstName(), manager.getLastName(), manager.getUserName(), manager.getPassword(),
				manager.getEmail(), manager.getDob(), manager.getPhones(), manager.getAddresses());
	}
	
	@GetMapping("/manager/{id}")
	public Manager findManagerById(@PathVariable("id") int id) {
		return managerDao.findManagerById(id);
	}
	
	@DeleteMapping("/manager/{id}")
	public void deleteManager(@PathVariable("id") int id) {
		managerDao.deleteManagerById(id);
	}
	
	@PutMapping("/manager/{id}")
	public void updateManager(@PathVariable("id") int id, @RequestBody Manager manager) {
		managerDao.updateManager(manager, manager.getFirstName(), manager.getLastName(), manager.getUserName(), manager.getPassword(), manager.getEmail(), manager.getDob());
	}

}
