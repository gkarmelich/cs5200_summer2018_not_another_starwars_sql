package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.api.APIConnector;
import edu.northeastern.cs5200.objects.Stock;
import edu.northeastern.cs5200.repositories.AssetRepo;
import edu.northeastern.cs5200.repositories.SecurityRepo;
import edu.northeastern.cs5200.repositories.StockRepo;

@Component
public class StockDao {
	
	@Autowired
	StockRepo stockRepo;
	
	@Autowired
	SecurityRepo securityRepo;
	
	@Autowired
	AssetRepo assetRepo;

	public void createStock(int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold, String securityName, String ticker) {
		Stock stock = new Stock(unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold, securityName, 0, 0.0, ticker);
		stockRepo.save(stock);
	}
	
	// method to update stock current unit value 
	public void updateStockPrice(String ticker, double currentUnitValue) {
		Stock stock = this.findStockByTicker(ticker);
		stock.setCurrentUnitValue(currentUnitValue);
		stockRepo.save(stock);	
	}
	
	public List<Stock> findAllStock() {
		List<Stock> stock = new ArrayList<>();
		stock =  (List<Stock>) stockRepo.findAll();
		return stock;
	}
	
	public void deleteStockById(int id) {
		Optional<Stock> stock = stockRepo.findById(id);
		if (stock != null) {
			Stock s = stock.get();
			stockRepo.deleteById(s.getIdAsset());
		}
	}
	
	public Stock findStockById(int id) {
		Optional<Stock> stock = stockRepo.findById(id);
		if (stock != null) {
			return stock.get();
		}
		return null;
	}
	
	public Stock findStockByTicker(String ticker) {
		Optional<Stock> stock = stockRepo.findStockByTicker(ticker);
		if (stock != null) {
			return stock.get();
		}
		return null;
	}
	
	public void test() throws Exception {
		Date datePurchased = new Date(3000000);
		
		List<String> tickers = new ArrayList<>();
		tickers.add("MSFT");
		tickers.add("TWTR");
		tickers.add("FB");
		this.createStock(10000, 87.55, datePurchased, 0, 0.0, null, "Microsoft", "MSFT");
		this.createStock(5000, 87.55, datePurchased, 0, 0.0, null, "Twitter", "TWTR");
		this.createStock(100, 87.55, datePurchased, 0, 0.0, null, "Facebook", "FB");
		
		APIConnector request = new APIConnector("LRYEV4NT70I96TDA", 2000);
		
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					List<String> allTickers = new ArrayList<>();
					for (Stock s : findAllStock()) {
						allTickers.add(s.getTicker());
						
					}
					List<Stock> stocks = request.getBatchStockQuotes(allTickers);
					for (Stock stock : stocks) {
						updateStockPrice(stock.getTicker(), stock.getCurrentUnitValue());
						
					}
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
