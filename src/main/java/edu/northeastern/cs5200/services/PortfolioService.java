package edu.northeastern.cs5200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.PortfolioDao;
import edu.northeastern.cs5200.objects.Investor;
import edu.northeastern.cs5200.objects.Portfolio;
import edu.northeastern.cs5200.repositories.PortfolioRepo;

@RestController
@RequestMapping("/api")
public class PortfolioService {
	
	@Autowired
	PortfolioDao portfolioDao;
	
	@Autowired
	PortfolioRepo portfolioRepo;
	
	@GetMapping("/portfolio")
	public List<Portfolio> findAllPortfolios() {
		return portfolioDao.findAllPortfolios();
	}
	
	@PostMapping("/portfolio")
	public void createPortfolio(@RequestBody Portfolio portfolio) {
		portfolioDao.createPortfolio(portfolio.getAssets(), portfolio.getInvestor(), portfolio.getManager(), portfolio.getStaff());
	}
	
	@GetMapping("/portfolio/{id}")
	public Portfolio findPortfolioById(@PathVariable("id") int id) {
		return portfolioDao.findPortfolioById(id);
	}
	
	@DeleteMapping("/portfolio/{id}")
	public void deletePortfolioByID(@PathVariable("id") int id) {
		portfolioDao.deletePortfolioById(id);
	}
	
}