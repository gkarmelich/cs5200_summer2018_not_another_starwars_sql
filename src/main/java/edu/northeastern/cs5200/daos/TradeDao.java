package edu.northeastern.cs5200.daos;

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
	
	
	public void createBuy(Asset asset, int unitsPurchased) throws Exception {
		double unitPurchasePrice = 1.0;
		if (asset instanceof Stock) {
			Stock stock = currentPrice.init(((Stock) asset).getTicker());
			unitPurchasePrice = stock.getCurrentUnitValue();
		}
		Buy buy = new Buy(asset, unitsPurchased, unitPurchasePrice);
		buyRepo.save(buy);
		asset.setUnitsPurchased(unitsPurchased);
		asset.setUnitPurchasePrice(unitPurchasePrice);
		assetRepo.save(asset);
	}
	
	public void createSell(Asset asset, int unitsSold) throws Exception {
		double unitSoldPrice = 1.0;
		if (asset instanceof Stock) {
			Stock stock = currentPrice.init(((Stock) asset).getTicker());
			unitSoldPrice = stock.getCurrentUnitValue();
		}
		Sell sell = new Sell(asset, unitsSold, unitSoldPrice);
		sellRepo.save(sell);
		asset.setUnitsSold(unitsSold);
		asset.setUnitSoldPrice(unitSoldPrice);
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
		Asset asset = stockDao.findStockById(2);
		this.createBuy(asset, 100);
		Trade trade = this.findAllTrades().get(0);
		Portfolio portfolio = portfolioDao.findPortfolioById(1);
	
		this.updatePortfolioForTrade(trade, portfolio);
		
		Asset asset2 = stockDao.findStockById(3);
		this.createSell(asset2, 75);
		Trade trade2 = this.findAllTrades().get(1);
		this.updatePortfolioForTrade(trade2, portfolio);
	}

}
