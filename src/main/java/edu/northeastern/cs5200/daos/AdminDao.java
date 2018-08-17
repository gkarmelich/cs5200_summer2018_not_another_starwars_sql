package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.Admin;
import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.AdminRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class AdminDao {
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	PhoneDao phoneDao;
	
	public List<Admin> findAllAdmins() {
		List<Admin> admins = new ArrayList<>();
		admins =  (List<Admin>) adminRepo.findAll();
		return admins;
	}
	
	public void createAdmin(String firstName, String lastName, String userName, String password, String email,
			Date dob, List<Phone> phones, List<Address> addresses) {
		Admin admin = new Admin(firstName, lastName, userName, password, email, dob, phones, addresses);
		adminRepo.save(admin);
	}
	
	public Admin findAdminByName(String firstName, String lastName) {
		User user = userRepo.findPersonByName(firstName, lastName);
		Optional<Admin> admin = adminRepo.findById(user.getIdPerson());
		if (admin != null) {
			return admin.get();
		}
		return null;
	}
	
	public void updateAdmin(Admin admin, String firstName, String lastName, String userName, String password, String email, Date dob) {
		admin = this.findAdminById(admin.getIdPerson());
		if (admin != null) {
			admin.setFirstName(firstName);
			admin.setLastName(lastName);
			admin.setUserName(userName);
			admin.setPassword(password);
			admin.setEmail(email);
			admin.setDob(dob);
		}
		userRepo.save(admin);
	}
	
	public void deleteAdminById(int id) {
		Optional<Admin> admin = adminRepo.findById(id);
		if (admin != null) {
			Admin ad = admin.get();
			adminRepo.deleteById(ad.getIdPerson());
		}
	}
	
	public Admin findAdminById(int id) {
		Optional<Admin> admin = adminRepo.findById(id);
		if (admin != null) {
			return admin.get();
		}
		return null;
	}
	
	public void test() {
		Date dob = new Date(100000000);
		List<Phone> phones = new ArrayList<>();
		List<Address> addresses = new ArrayList<>();
		phones.add(phoneDao.findPhoneById(1));
		addresses.add(addressDao.findAddressById(1));
		this.createAdmin("Mark", "Karmelich", "mark", "password1", "mkarmelich@hotmail.com", dob, phones, addresses);
		
	}

}
