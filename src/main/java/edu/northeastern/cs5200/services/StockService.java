package edu.northeastern.cs5200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.StockDao;
import edu.northeastern.cs5200.objects.Stock;
import edu.northeastern.cs5200.repositories.StockRepo;

@RestController
@RequestMapping("/api")
public class StockService {
	
	@Autowired
	StockDao stockDao;
	
	@Autowired
	StockRepo stockRepo;
	
	@GetMapping("/stock")
	public List<Stock> findAllStock() {
		return stockDao.findAllStock();
	}
	
	@PostMapping("/stock")
	public void createActor(@RequestBody Stock stock) {
		stockDao.createStock(stock.getUnitsPurchased(), stock.getUnitPurchasePrice(), stock.getDatePurchased(), stock.getUnitsSold(),
				stock.getUnitSoldPrice(), stock.getDateSold(), stock.getSecurityName(), stock.getTicker());
	}

}
