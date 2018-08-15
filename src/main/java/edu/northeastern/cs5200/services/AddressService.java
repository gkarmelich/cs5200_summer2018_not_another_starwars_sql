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

import edu.northeastern.cs5200.daos.AddressDao;
import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.AddressRepo;

@RestController
@RequestMapping("/api")
public class AddressService {
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	AddressRepo addressRepo;
	
	@GetMapping("/address")
	public List<Address> findAllAddresses() {
		return addressDao.findAllAddresses();
	}
	
	@PostMapping("/address")
	public void createAddress(@RequestBody Address address) {
		addressDao.createAddress(address.getStreet1(), address.getStreet2(), address.getCity(), address.getState(), address.getZip(), address.isPrimary());
	}
	
	@GetMapping("/address/{id}")
	public Address findAddressById(@PathVariable("id") int id) {
		return addressDao.findAddressById(id);
	}
	
	@DeleteMapping("/address/{id}")
	public void deleteAddress(@PathVariable("id") int id) {
		addressDao.deleteAddressById(id);
	}
	
	@PutMapping("/address/{id}")
	public void updateUserAddress(@PathVariable("id") int id, @RequestBody User user) {
		addressDao.updateUserAddress(user, user.getAddresses());
	}

}
