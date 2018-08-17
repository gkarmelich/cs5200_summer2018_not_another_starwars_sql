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

import edu.northeastern.cs5200.daos.AdminDao;
import edu.northeastern.cs5200.objects.Admin;
import edu.northeastern.cs5200.repositories.AdminRepo;

@RestController
@RequestMapping("/api")
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	AdminRepo adminRepo;
	
	@GetMapping("/admin")
	public List<Admin> findAllAdmins() {
		return adminDao.findAllAdmins();
	}
	
	@PostMapping("/admin")
	public void createAdmin(@RequestBody Admin admin) {
		adminDao.createAdmin(admin.getFirstName(), admin.getLastName(), admin.getUserName(), admin.getPassword(),
				admin.getEmail(), admin.getDob(), admin.getPhones(), admin.getAddresses());
	}
	
	@GetMapping("/admin/{id}")
	public Admin findAdminById(@PathVariable("id") int id) {
		return adminDao.findAdminById(id);
	}
	
	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable("id") int id) {
		adminDao.deleteAdminById(id);
	}

	@PutMapping("/admin/{id}")
	public void updateAdmin(@PathVariable("id") int id, @RequestBody Admin admin) {
		adminDao.updateAdmin(admin, admin.getFirstName(), admin.getLastName(), admin.getUserName(), admin.getPassword(), admin.getEmail(), admin.getDob());
	}

}
