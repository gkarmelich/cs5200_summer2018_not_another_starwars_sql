package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Cash;
import edu.northeastern.cs5200.repositories.AssetRepo;
import edu.northeastern.cs5200.repositories.CashRepo;


@Component
public class CashDao {
	
	@Autowired
	CashRepo cashRepo;
	
	@Autowired
	AssetRepo assetRepo;
	
	public List<Cash> findAllCash() {
		List<Cash> cash = new ArrayList<>();
		cash =  (List<Cash>) cashRepo.findAll();
		return cash;
	}
	
	public void createCash(int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold, String currencyName) {
		Cash cash = new Cash(unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold, currencyName);
		cashRepo.save(cash);
	}
	
	public void deleteCashById(int id) {
		Optional<Cash> cash = cashRepo.findById(id);
		if (cash != null) {
			Cash c = cash.get();
			cashRepo.deleteById(c.getIdAsset());
		}
	}
	
	public Cash findCashById(int id) {
		Optional<Cash> cash = cashRepo.findById(id);
		if (cash != null) {
			return cash.get();
		}
		return null;
	}
	
	public void test() {
		Date datePurchased = new Date(10000);
		this.createCash(100000, 1.0, datePurchased, 0, 0.0, null, "USD");
	}

}
