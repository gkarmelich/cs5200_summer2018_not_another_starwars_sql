package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Investor;
import edu.northeastern.cs5200.repositories.InvestorRepo;
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
			Date dob) {
		Investor investor = new Investor(firstName, lastName, userName, password, email, dob, null, null);
		investorRepo.save(investor);
	}
	
	public void test() {
		Date dob = new Date(100000000);
		this.createInvestor("George", "Karmelich", "george", "password1", "gkarmelich@hotmail.com", dob);
		
	}

}
