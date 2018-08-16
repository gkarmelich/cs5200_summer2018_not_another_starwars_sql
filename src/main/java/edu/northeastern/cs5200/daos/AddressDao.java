package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.derby.impl.sql.execute.UserDefinedAggregator;
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
	
	public void createAddress(String street1, String street2, String city, String state, String zip, boolean primary) {
		Address a = new Address(street1, street2, city, state, zip, primary);
		addressRepo.save(a);
	}
	
	public List<Address> findAllAddresses() {
		List<Address> address = new ArrayList<>();
		address =  (List<Address>) addressRepo.findAll();
		return address;
	}
	
	public List<Address> findUserAddresses(User user) {
		Optional<User> thisUser = userRepo.findById(user.getIdPerson());
		if (thisUser != null) {
			User u = thisUser.get();
			return u.getAddresses();
		}
		
		return null;
	}
	
	public void updateUserAddress(User user, List<Address> addresses) {
		Optional<User> thisUser = userRepo.findById(user.getIdPerson());
		if (thisUser != null) {
			User u = thisUser.get();
			this.deleteAllUserAddresses(u);
			u.setAddresses(addresses);
			userRepo.save(u);
		}
	}
	
	public void deleteAddressById(int id) {
		Optional<Address> address = addressRepo.findById(id);
		if (address != null) {
			Address m = address.get();
			addressRepo.deleteById(m.getIdAddress());
		}
	}
	
	public void deleteAllUserAddresses(User user) {
		List<Address> addresses = user.getAddresses();
		if (addresses != null) {
			for (Address address : addresses) {
				addressRepo.deleteById(address.getIdAddress());
				user.setAddresses(null);
				userRepo.save(user);
			}
		}
	}
	
	public Address findAddressById(int id) {
		Optional<Address> address = addressRepo.findById(id);
		if (address != null) {
			return address.get();
		}
		return null;
	}
	
	
	public void test() {
		this.createAddress("505 Congress Street", "Unit 3", "Boston", "MA", "02130", true);
		this.createAddress("515 Congress Street", null, "Boston", "MA", "02130", true);
		this.createAddress("525 Congress Street", "Unit 3", "Boston", "MA", "02130", true);
		this.createAddress("535 Congress Street", null, "Boston", "MA", "02130", true);
		this.createAddress("545 Congress Street", "Unit 3", "Boston", "MA", "02130", true);
		this.createAddress("2007 Beecham Drive", "Unit 3", "Boston", "MA", "02130", true);
	}

}
