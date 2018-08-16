package edu.northeastern.cs5200.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.objects.Investor;
import edu.northeastern.cs5200.objects.Portfolio;

public interface PortfolioRepo extends CrudRepository<Portfolio, Integer>{
	
	@Query("SELECT x FROM Portfolio x WHERE x.investor=:investor")
	Optional<Portfolio> findPortfolioByInvestor (
			@Param("investor") Investor investor);


}
