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

import edu.northeastern.cs5200.daos.StaffDao;
import edu.northeastern.cs5200.objects.Staff;
import edu.northeastern.cs5200.repositories.StaffRepo;


@RestController
@RequestMapping("/api")
public class StaffService {
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	StaffRepo staffRepo;
	
	@GetMapping("/staff")
	public List<Staff> findAllStaff() {
		return staffDao.findAllStaff();
	}
	
	@PostMapping("/staff")
	public void createStaff(@RequestBody Staff staff) {
		staffDao.createStaff(staff.getFirstName(), staff.getLastName(), staff.getUserName(), staff.getPassword(),
				staff.getEmail(), staff.getDob(), staff.getPhones(), staff.getAddresses());
	}
	
	@GetMapping("/staff/{id}")
	public Staff findStaffById(@PathVariable("id") int id) {
		return staffDao.findStaffById(id);
	}
	
	@DeleteMapping("/staff/{id}")
	public void deleteStaff(@PathVariable("id") int id) {
		staffDao.deleteStaffById(id);
	}
	
	@PutMapping("/staff/{id}")
	public void updateStaff(@PathVariable("id") int id, @RequestBody Staff staff) {
		staffDao.updateStaff(staff, staff.getFirstName(), staff.getLastName(), staff.getUserName(), staff.getPassword(), staff.getEmail(), staff.getDob());
	}

}
