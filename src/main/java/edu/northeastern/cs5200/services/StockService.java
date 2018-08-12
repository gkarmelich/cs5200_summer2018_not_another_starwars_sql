package edu.northeastern.cs5200.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.StockDao;
import edu.northeastern.cs5200.objects.Stock;
import edu.northeastern.cs5200.repositories.StockRepo;
import edu.northeastern.cs5200.api.APIConnector;


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
	public void createStock(@RequestBody Stock stock) {
		stockDao.createStock(stock.getUnitsPurchased(), stock.getUnitPurchasePrice(), stock.getDatePurchased(), stock.getUnitsSold(),
				stock.getUnitSoldPrice(), stock.getDateSold(), stock.getSecurityName(), stock.getTicker());
	}
	
	@GetMapping("/stock/{id}")
	public Stock findStockById(@PathVariable("id") int id) {
		return stockDao.findStockById(id);
	}
	
    //service to access Alpha Vantage API directly for custom queries (i.e. for stocks not already in a portfolio)
	@GetMapping("/stockrequest/{ticker}")
	public StringBuilder findStockByTicker(@PathVariable("ticker") String ticker) throws Exception {
		APIConnector request = new APIConnector("LRYEV4NT70I96TDA", 2000);
		return request.getStockQuotes(ticker);
	}
	
	@DeleteMapping("/stock/{id}")
	public void deleteStock(@PathVariable("id") int id) {
		stockDao.deleteStockById(id);
	}

}
