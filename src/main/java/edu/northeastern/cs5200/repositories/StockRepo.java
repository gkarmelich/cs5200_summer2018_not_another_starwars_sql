package edu.northeastern.cs5200.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.objects.Stock;

public interface StockRepo extends CrudRepository<Stock, Integer>{
	
	@Query("SELECT x FROM Stock x WHERE x.ticker=:ticker")
	Optional<Stock> findStockByTicker (
			@Param("ticker") String ticker);

}
