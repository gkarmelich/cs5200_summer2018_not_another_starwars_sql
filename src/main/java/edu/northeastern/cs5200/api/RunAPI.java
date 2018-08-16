package edu.northeastern.cs5200.api;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.daos.StockDao;
import edu.northeastern.cs5200.objects.Stock;



public class RunAPI {
	
	@Autowired
	StockDao stockDao;
	
	// API Call to Return Current Price Of One Stock
	public Stock init(String ticker) throws Exception {
		APIConnector request = new APIConnector("H6ATTFFWD1WB597R", 2000);
		List<String> tickers = new ArrayList<>();
		tickers.add(ticker);
		return request.getBatchStockQuotes(tickers).get(0);	
	}
}
