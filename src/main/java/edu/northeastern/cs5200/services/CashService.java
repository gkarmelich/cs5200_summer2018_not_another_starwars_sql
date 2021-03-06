package edu.northeastern.cs5200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.CashDao;
import edu.northeastern.cs5200.objects.Cash;
import edu.northeastern.cs5200.repositories.CashRepo;

@RestController
@RequestMapping("/api")
public class CashService {
	
	@Autowired
	CashDao cashDao;
	
	@Autowired
	CashRepo cashRepo;
	
	@GetMapping("/cash")
	public List<Cash> findAllCash() {
		return cashDao.findAllCash();
	}
	
	@PostMapping("/cash")
	public void createCash(@RequestBody Cash cash) {
		cashDao.createCash(cash.getUnitsPurchased(), cash.getUnitPurchasePrice(), cash.getDatePurchased(), cash.getUnitsSold(),
				cash.getUnitSoldPrice(), cash.getDateSold(), cash.getCurrencyName());
	}
	
	@GetMapping("/cash/{id}")
	public Cash findCashById(@PathVariable("id") int id) {
		return cashDao.findCashById(id);
	}
	
	@DeleteMapping("/cash/{id}")
	public void deleteCash(@PathVariable("id") int id) {
		cashDao.deleteCashById(id);
	}

}
