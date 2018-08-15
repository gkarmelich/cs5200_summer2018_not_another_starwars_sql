package edu.northeastern.cs5200.api;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.daos.StockDao;


public class RunAPI {
	
	@Autowired
	StockDao stockDao;
	
	// method to run API for every minute to update all stock values in real time
	public void init(List<String> tickers) {
		APIConnector request = new APIConnector("LRYEV4NT70I96TDA", 2000);
		
		// Create runnable so that API call is executed on a schedule
		// FYI, the API limits calls to 5 requests per minute
		
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					request.getBatchStockQuotes(tickers);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		// Call API every minute for real time stock quotes
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.SECONDS);
		}

}
