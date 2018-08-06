package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Stock;
import edu.northeastern.cs5200.repositories.StockRepo;

@Component
public class StockDao {
	
	@Autowired
	StockRepo stockRepo;

	public void createStock(int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold, String securityName, String ticker) {
		Stock stock = new Stock(unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold, securityName, ticker);
		stockRepo.save(stock);
	}
	
	public List<Stock> findAllStock() {
		List<Stock> stock = new ArrayList<>();
		stock =  (List<Stock>) stockRepo.findAll();
		return stock;
	}
	
	public void test() {
		Date datePurchased = new Date(3000000);
		this.createStock(10000, 87.55, datePurchased, 0, 0.0, null, "Microsoft", "MSFT");
	}

}
