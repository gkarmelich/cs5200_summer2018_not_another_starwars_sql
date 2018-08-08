package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.PhoneRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class PhoneDao {
	
	@Autowired
	PhoneRepo phoneRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public void createPhone(String phone, boolean primary) {
		Phone p = new Phone(phone, primary);
		phoneRepo.save(p);
	}
	
	public List<Phone> findAllPhones() {
		List<Phone> phones = new ArrayList<>();
		phones =  (List<Phone>) phoneRepo.findAll();
		return phones;
	}
	
	public void test() {
		this.createPhone("555123456", true);
	}

}
