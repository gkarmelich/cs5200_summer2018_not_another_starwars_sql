package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.Manager;
import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.AddressRepo;
import edu.northeastern.cs5200.repositories.ManagerRepo;
import edu.northeastern.cs5200.repositories.PhoneRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class ManagerDao {
	
	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	PhoneDao phoneDao;
	
	public List<Manager> findAllManagers() {
		List<Manager> managers = new ArrayList<>();
		managers =  (List<Manager>) managerRepo.findAll();
		return managers;
	}
	
	public void createManager(String firstName, String lastName, String userName, String password, String email,
			Date dob, List<Phone> phones, List<Address> addresses) {
		Manager manager = new Manager(firstName, lastName, userName, password, email, dob, phones, addresses);
		managerRepo.save(manager);
	}
	
	public Manager findManagerByName(String firstName, String lastName) {
		User user = userRepo.findPersonByName(firstName, lastName);
		Optional<Manager> manager = managerRepo.findById(user.getIdPerson());
		if (manager != null) {
			return manager.get();
		}
		return null;
	}
	
	public void deleteManagerById(int id) {
		Optional<Manager> manager = managerRepo.findById(id);
		if (manager != null) {
			Manager inv = manager.get();
			managerRepo.deleteById(inv.getIdPerson());
		}
	}
	
	public Manager findManagerById(int id) {
		Optional<Manager> manager = managerRepo.findById(id);
		if (manager != null) {
			return manager.get();
		}
		return null;
	}
	
	
	public void test() {
		Date dob = new Date(10000000);
		List<Phone> phones = new ArrayList<>();
		List<Address> addresses = new ArrayList<>();
		this.createManager("Ryan", "Kalla", "rkalla", "password1", "rkalla@hotmail.com", dob, phones, addresses);
		
	}

}
