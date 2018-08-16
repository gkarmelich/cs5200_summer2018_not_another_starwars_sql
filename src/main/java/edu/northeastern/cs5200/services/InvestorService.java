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

import edu.northeastern.cs5200.daos.InvestorDao;
import edu.northeastern.cs5200.objects.Investor;
import edu.northeastern.cs5200.repositories.InvestorRepo;


@RestController
@RequestMapping("/api")
public class InvestorService {
	
	@Autowired
	InvestorDao investorDao;
	
	@Autowired
	InvestorRepo investorRepo;
	
	@GetMapping("/investor")
	public List<Investor> findAllInvestors() {
		return investorDao.findAllInvestors();
	}
	
	@PostMapping("/investor")
	public void createInvestor(@RequestBody Investor investor) {
		investorDao.createInvestor(investor.getFirstName(), investor.getLastName(), investor.getUserName(), investor.getPassword(),
				investor.getEmail(), investor.getDob(), investor.getPhones(), investor.getAddresses());
	}
	
	@GetMapping("/investor/{id}")
	public Investor findInvestorById(@PathVariable("id") int id) {
		return investorDao.findInvestorById(id);
	}
	
	@DeleteMapping("/investor/{id}")
	public void deleteInvestor(@PathVariable("id") int id) {
		investorDao.deleteInvestorById(id);
	}
	
	@PutMapping("/investor/{id}")
	public void updateInvestor(@PathVariable("id") int id, @RequestBody Investor investor) {
		investorDao.updateInvestor(investor, investor.getFirstName(), investor.getLastName(), investor.getUserName(), investor.getPassword(), investor.getEmail(), investor.getDob());
	}
	
}

