package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Staff;
import edu.northeastern.cs5200.repositories.StaffRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class StaffDao {
	
	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public List<Staff> findAllStaff() {
		List<Staff> staff = new ArrayList<>();
		staff =  (List<Staff>) staffRepo.findAll();
		return staff;
	}
	
	public void createStaff(String firstName, String lastName, String userName, String password, String email,
			Date dob) {
		Staff staff = new Staff(firstName, lastName, userName, password, email, dob, null, null);
		staffRepo.save(staff);
	}
	
	public void test() {
		Date dob = new Date(100000000);
		this.createStaff("Jose", "Annunziato", "annunziato", "password1!", "jannunz@hotmail.com", dob);
		
	}

}
