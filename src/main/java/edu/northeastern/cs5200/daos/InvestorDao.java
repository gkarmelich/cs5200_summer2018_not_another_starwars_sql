package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.Investor;
import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.repositories.AddressRepo;
import edu.northeastern.cs5200.repositories.InvestorRepo;
import edu.northeastern.cs5200.repositories.PhoneRepo;
import edu.northeastern.cs5200.repositories.UserRepo;

@Component
public class InvestorDao {
	
	@Autowired
	InvestorRepo investorRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public List<Investor> findAllInvestors() {
		List<Investor> investors = new ArrayList<>();
		investors =  (List<Investor>) investorRepo.findAll();
		return investors;
	}
	
	public void createInvestor(String firstName, String lastName, String userName, String password, String email,
			Date dob, List<Phone> phones, List<Address> addresses) {
		Investor investor = new Investor(firstName, lastName, userName, password, email, dob, phones, addresses);
		investorRepo.save(investor);
	}
	
	public Investor findInvestorByName(String firstName, String lastName) {
		User user = userRepo.findPersonByName(firstName, lastName);
		Optional<Investor> investor = investorRepo.findById(user.getIdPerson());
		if (investor != null) {
			return investor.get();
		}
		return null;
	}
	
	public void test() {
		Date dob = new Date(100000000);
		List<Phone> phones = new ArrayList<>();
		List<Address> addresses = new ArrayList<>();
		this.createInvestor("George", "Karmelich", "george", "password1", "gkarmelich@hotmail.com", dob, phones, addresses);
		
	}

}
