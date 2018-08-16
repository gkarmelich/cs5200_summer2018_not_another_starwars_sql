package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Asset;
import edu.northeastern.cs5200.objects.Portfolio;
import edu.northeastern.cs5200.objects.Investor;
import edu.northeastern.cs5200.objects.Manager;
import edu.northeastern.cs5200.objects.Staff;
import edu.northeastern.cs5200.objects.Trade;
import edu.northeastern.cs5200.repositories.AssetRepo;
import edu.northeastern.cs5200.repositories.PortfolioRepo;

@Component
public class PortfolioDao {
	
	@Autowired
	PortfolioRepo portfolioRepo;
	
	@Autowired
	AssetRepo assetRepo;
	
	@Autowired
	InvestorDao investorDao;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	StaffDao staffDao;
	
	public void createPortfolio(List<Asset> assets, Investor investor, Manager manager, List<Staff> staff) {
		Portfolio portfolio = new Portfolio(assets, null, investor, manager, staff);
		portfolioRepo.save(portfolio);
	}
	
	public List<Portfolio> findAllPortfolios() {
		List<Portfolio> portfolio = new ArrayList<>();
		portfolio =  (List<Portfolio>) portfolioRepo.findAll();
		return portfolio;
	}
	
	public void deletePortfolioById(int id) {
		Optional<Portfolio> portfolio = portfolioRepo.findById(id);
		if (portfolio != null) {
			Portfolio p = portfolio.get();
			portfolioRepo.deleteById(p.getIdPortfolio());
		}
	}
	
	public void deletePortfolioByInvestor(Investor investor) {
		Portfolio portfolio = this.findPortfolioByInvestor(investor);
		if (portfolio != null) {
			portfolioRepo.deleteById(portfolio.getIdPortfolio());
		}
		
	}
	
	public Portfolio findPortfolioByInvestor(Investor investor) {
		Optional<Portfolio> portfolio = portfolioRepo.findPortfolioByInvestor(investor);
		if (portfolio != null) {
			return portfolio.get();
		}
		return null;
	}
	
	public Portfolio findPortfolioById(int id) {
		Optional<Portfolio> portfolio = portfolioRepo.findById(id);
		if (portfolio != null) {
			return portfolio.get();
		}
		return null;
	}
	
	public List<Trade> findTradesByPortfolio(Portfolio portfolio) {
		Optional<Portfolio> thisPortfolio = portfolioRepo.findById(portfolio.getIdPortfolio());
		if (thisPortfolio != null) {
			Portfolio p = thisPortfolio.get();
			return p.getTrades();
		}
		return null;
	}
	
	public void test() {
		List<Asset> assets = (List<Asset>) assetRepo.findAll();
		Investor investor = investorDao.findInvestorByName("George", "Karmelich");
		Manager manager = managerDao.findManagerByName("Ryan", "Kalla");
		Staff staff = staffDao.findStaffByName("Jose", "Annunziato");
		List<Staff> staffList = new ArrayList<>();
		staffList.add(staff);
		this.createPortfolio(assets, investor, manager, staffList);

		
	}

}
