package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.AddressRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class AddressDao {
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public void createAddress(String street1, String street2, String city, String state, String zip, boolean primary, User user) {
		Address a = new Address(street1, street2, city, state, zip, primary, user);
		addressRepo.save(a);
	}
	
	public void updateUserAddress(String firstName, String lastName, List<Address> addresses) {
		User user = userRepo.findPersonByName(firstName, lastName);
		user.setAddresses(addresses);
		userRepo.save(user);
	}
	
	public void test() {
		User user = userRepo.findPersonByName("George", "Karmelich");
		this.createAddress("505 Congress Street", "Unit 3", "Boston", "MA", "02130", true, user);
	}

}
