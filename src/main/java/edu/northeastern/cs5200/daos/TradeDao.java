package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import edu.northeastern.cs5200.api.RunAPI;
import edu.northeastern.cs5200.objects.Asset;
import edu.northeastern.cs5200.objects.Buy;
import edu.northeastern.cs5200.objects.Investor;
import edu.northeastern.cs5200.objects.Portfolio;
import edu.northeastern.cs5200.objects.Stock;
import edu.northeastern.cs5200.objects.Sell;
import edu.northeastern.cs5200.objects.Trade;
import edu.northeastern.cs5200.repositories.AssetRepo;
import edu.northeastern.cs5200.repositories.BuyRepo;
import edu.northeastern.cs5200.repositories.PortfolioRepo;
import edu.northeastern.cs5200.repositories.SellRepo;
import edu.northeastern.cs5200.repositories.TradeRepo;

@Component
public class TradeDao {
	
	@Autowired
	TradeRepo tradeRepo;
	
	@Autowired
	BuyRepo buyRepo;
	
	@Autowired
	SellRepo sellRepo;
	
	@Autowired
	PortfolioRepo portfolioRepo;
	
	@Autowired
	PortfolioDao portfolioDao;
	
	@Autowired
	AssetRepo assetRepo;
	
	@Autowired
	StockDao stockDao;
	
	@Autowired
	CashDao cashDao;
	
	RunAPI currentPrice = new RunAPI();
	
	
	
	public List<Trade> findAllTrades() {
		List<Trade> trades = new ArrayList<>();
		trades =  (List<Trade>) tradeRepo.findAll();
		return trades;
	}
	
	public Trade findTradeById(int id) {
		Optional<Trade> trade = tradeRepo.findById(id);
		if (trade != null) {
			return trade.get();
		}
		return null;
	}
	
	
	public void createBuy(Stock asset, int unitsPurchased) throws Exception {
		double unitPurchasePrice = 1.0;
		int unitsHeld = 0;
		Date datePurchased = new Date(System.currentTimeMillis());
		if (asset instanceof Stock) {
			Stock stock = currentPrice.init(((Stock) asset).getTicker());
			unitPurchasePrice = stock.getCurrentUnitValue();
			if (asset.getUnitsPurchased() != 0) {
				unitPurchasePrice = ((asset.getUnitPurchasePrice() * asset.getUnitsPurchased()) + 
						(unitPurchasePrice * unitsPurchased)) / (unitsPurchased + asset.getUnitsPurchased());
			}
		}
		Buy buy = new Buy(asset, unitsPurchased, unitPurchasePrice);
		buyRepo.save(buy);
		asset.setUnitsPurchased(asset.getUnitsPurchased() + unitsPurchased);
		asset.setUnitPurchasePrice(unitPurchasePrice);
		asset.setDatePurchased(datePurchased);
		if (asset instanceof Stock) {
			unitsHeld = asset.getUnitsPurchased() - asset.getUnitsSold();
			((Stock) asset).setUnitsHeld(unitsHeld);
		}
		assetRepo.save(asset);
	}
	
	public void createSell(Stock asset, int unitsSold) throws Exception {
		double unitSoldPrice = 1.0;
		int unitsHeld = 0;
		double profit = 0;
		Date dateSold = new Date(System.currentTimeMillis());
		if (asset instanceof Stock) {
			Stock stock = currentPrice.init(((Stock) asset).getTicker());
			unitSoldPrice = stock.getCurrentUnitValue();
			if (asset.getUnitsSold() != 0) {
				unitSoldPrice = ((asset.getUnitSoldPrice() * asset.getUnitsSold()) + 
						(unitSoldPrice * unitsSold)) / (unitsSold + asset.getUnitsSold());
			}
		}
		Sell sell = new Sell(asset, unitsSold, unitSoldPrice);
		asset.setUnitsSold(unitsSold);
		asset.setUnitSoldPrice(unitSoldPrice);
		asset.setDateSold(dateSold);
		if (asset instanceof Stock) {
			unitsHeld = asset.getUnitsPurchased() - asset.getUnitsSold();
			((Stock) asset).setUnitsHeld(unitsHeld);
			profit = (asset.getUnitSoldPrice() * asset.getUnitsSold()) - (asset.getUnitPurchasePrice() * asset.getUnitsPurchased());
			sell.setProfit(profit);
		}
		sellRepo.save(sell);
		assetRepo.save(asset);
	}
	
	public void updatePortfolioForTrade(Trade trade, Portfolio portfolio ) {
		Optional<Portfolio> thisPortfolio = portfolioRepo.findById(portfolio.getIdPortfolio());
		if (thisPortfolio != null) {
			Portfolio p = thisPortfolio.get();
			List<Trade> trades = p.getTrades();
			trades.add(trade);
			p.setTrades(trades);
			portfolioRepo.save(p);
		}
	}
	
	public void deleteTradeById(int id) {
		Optional<Trade> trade = tradeRepo.findById(id);
		if (trade != null) {
			Trade t = trade.get();
			tradeRepo.deleteById(t.getIdTrade());
		}
	}
	
	
	public void test() throws Exception {
		Stock asset = stockDao.findStockById(2);
		this.createBuy(asset, 100);
		Trade trade = this.findAllTrades().get(0);
		Portfolio portfolio = portfolioDao.findPortfolioById(1);
	
		this.updatePortfolioForTrade(trade, portfolio);
		

		Stock asset2 = stockDao.findStockById(3);
		this.createSell(asset2, 2000);
		Trade trade2 = this.findAllTrades().get(1);
		this.updatePortfolioForTrade(trade2, portfolio);
		
	}

}
