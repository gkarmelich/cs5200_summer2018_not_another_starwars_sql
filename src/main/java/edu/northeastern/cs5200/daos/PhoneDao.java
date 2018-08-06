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
	
	public void createPhone(String phone, boolean primary, User user) {
		Phone p = new Phone(phone, primary, user);
		List<Phone> phones = new ArrayList<>();
		phoneRepo.save(p);
		phones.add(p);
		this.updateUserPhone(user.getFirstName(), user.getLastName(), phones);
	}
	
	public void updateUserPhone(String firstName, String lastName, List<Phone> phones) {
		User user = userRepo.findPersonByName(firstName, lastName);
		user.setPhones(phones);
		userRepo.save(user);
	}
	
	public void test() {
		User user = userRepo.findPersonByName("George", "Karmelich");
		this.createPhone("555123456", true, user);
	}

}
