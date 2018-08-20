package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.Staff;
import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.StaffRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class StaffDao {
	
	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	PhoneDao phoneDao;
	
	public List<Staff> findAllStaff() {
		List<Staff> staff = new ArrayList<>();
		staff =  (List<Staff>) staffRepo.findAll();
		return staff;
	}
	
	public void createStaff(String firstName, String lastName, String userName, String password, String email,
			Date dob, List<Phone> phones, List<Address> addresses) {
		Staff staff = new Staff(firstName, lastName, userName, password, email, dob, phones, addresses);
		staffRepo.save(staff);
	}
	
	public Staff findStaffByName(String firstName, String lastName) {
		User user = userRepo.findPersonByName(firstName, lastName);
		Optional<Staff> staff = staffRepo.findById(user.getIdPerson());
		if (staff != null) {
			return staff.get();
		}
		return null;
	}
	
	public void deleteStaffById(int id) {
		Optional<Staff> staff = staffRepo.findById(id);
		if (staff != null) {
			Staff inv = staff.get();
			staffRepo.deleteById(inv.getIdPerson());
		}
	}
	
	public Staff findStaffById(int id) {
		Optional<Staff> staff = staffRepo.findById(id);
		if (staff != null) {
			return staff.get();
		}
		return null;
	}
	
	public void updateStaff(Staff staff, String firstName, String lastName, String userName, String password, String email, Date dob) {
		staff = this.findStaffById(staff.getIdPerson());
		if (staff != null) {
			staff.setFirstName(firstName);
			staff.setLastName(lastName);
			staff.setUserName(userName);
			staff.setPassword(password);
			staff.setEmail(email);
			staff.setDob(dob);
		}
		userRepo.save(staff);
	}
	
	public void test() {
		Date dob = new Date(100000000);
		List<Phone> phones = new ArrayList<>();
		List<Address> addresses = new ArrayList<>();
		phones.add(phoneDao.findPhoneById(4));
		addresses.add(addressDao.findAddressById(4));
		this.createStaff("Charlie", "Brown", "charlie", "charlie", "charlie@hotmail.com", dob, phones, addresses);
		
		Date dob1 = new Date(100000000);
		List<Phone> phones1 = new ArrayList<>();
		List<Address> addresses1 = new ArrayList<>();
		phones1.add(phoneDao.findPhoneById(1));
		addresses1.add(addressDao.findAddressById(1));
		this.createStaff("Jose", "Annunziato", "admin", "admin", "ja@hotmail.com", dob1, phones1, addresses1);
		
	}

}
