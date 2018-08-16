package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public List<Phone> findUserPhones(User user) {
		Optional<User> thisUser = userRepo.findById(user.getIdPerson());
		if (thisUser != null) {
			User u = thisUser.get();
			return u.getPhones();
		}
		
		return null;
	}
	
	public void updateUserPhone(User user, List<Phone> phones) {
		Optional<User> thisUser = userRepo.findById(user.getIdPerson());
		if (thisUser != null) {
			User u = thisUser.get();
			this.deleteAllUserPhones(u);
			u.setPhones(phones);
			userRepo.save(u);
		}
	}
	
	public void deletePhoneById(int id) {
		Optional<Phone> phone = phoneRepo.findById(id);
		if (phone != null) {
			Phone m = phone.get();
			phoneRepo.deleteById(m.getIdPhone());
		}
	}
	
	public void deleteAllUserPhones(User user) {
		List<Phone> phones = user.getPhones();
		if (phones != null) {
			for (Phone phone : phones) {
				phoneRepo.deleteById(phone.getIdPhone());
				user.setPhones(null);
				userRepo.save(user);
			}
		}
	}
	
	public Phone findPhoneById(int id) {
		Optional<Phone> phone = phoneRepo.findById(id);
		if (phone != null) {
			return phone.get();
		}
		return null;
	}
	
	public void test() {
		this.createPhone("555123456", true);
		this.createPhone("555123456", true);
		this.createPhone("555123456", true);
		this.createPhone("555123456", true);
		this.createPhone("555123456", true);
		this.createPhone("123456", true);
	}

}
