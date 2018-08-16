package edu.northeastern.cs5200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.northeastern.cs5200.daos.PhoneDao;
import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.PhoneRepo;

public class PhoneService {
	
	@Autowired
	PhoneDao phoneDao;
	
	@Autowired
	PhoneRepo phoneRepo;
	
	@GetMapping("/phone")
	public List<Phone> findAllPhones() {
		return phoneDao.findAllPhones();
	}
	
	@PostMapping("/phone")
	public void createPhone(@RequestBody Phone phone) {
		phoneDao.createPhone(phone.getPhone(), phone.isPrimary());
	}
	
	@GetMapping("/phone/{id}")
	public Phone findPhoneById(@PathVariable("id") int id) {
		return phoneDao.findPhoneById(id);
	}
	
	@DeleteMapping("/phone/{id}")
	public void deletePhone(@PathVariable("id") int id) {
		phoneDao.deletePhoneById(id);
	}
	
	@PutMapping("/phone/{id}")
	public void updateUserPhone(@PathVariable("id") int id, @RequestBody User user) {
		phoneDao.updateUserPhone(user, user.getPhones());
	}

}
