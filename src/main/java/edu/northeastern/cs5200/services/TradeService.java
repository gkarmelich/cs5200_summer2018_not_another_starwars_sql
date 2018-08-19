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

import edu.northeastern.cs5200.daos.TradeDao;
import edu.northeastern.cs5200.objects.Buy;
import edu.northeastern.cs5200.objects.Portfolio;
import edu.northeastern.cs5200.objects.Sell;
import edu.northeastern.cs5200.objects.Trade;
import edu.northeastern.cs5200.repositories.TradeRepo;

@RestController
@RequestMapping("/api")
public class TradeService {
	
	@Autowired
	TradeDao tradeDao;
	
	@Autowired
	TradeRepo tradeRepo;
	
	@GetMapping("/trade")
	public List<Trade> findAllTrades() {
		return tradeDao.findAllTrades();
	}
	
	
	@PostMapping("/buy")
	public Buy createBuy(@RequestBody Buy buy) throws Exception {
		return tradeDao.createBuy(buy.getStock(), buy.getUnitsPurchased());
	}
	
	@PostMapping("/sell")
	public Sell createSell(@RequestBody Sell sell) throws Exception {
		return tradeDao.createSell(sell.getStock(), sell.getUnitsSold());
	}
	
	@GetMapping("/trade/{id}")
	public Trade findTradeById(@PathVariable("id") int id) {
		return tradeDao.findTradeById(id);
	}
	
	@DeleteMapping("/trade/{id}")
	public void deleteTradeByID(@PathVariable("id") int id) {
		tradeDao.deleteTradeById(id);
	}
	
	@PutMapping("/trade/{id}")
	public void updatePortfolioForTrades(@PathVariable("id") int id, @RequestBody Portfolio portfolio) {
		tradeDao.updatePortfolioForTrade(tradeDao.findTradeById(id), portfolio);
		
	}

}
