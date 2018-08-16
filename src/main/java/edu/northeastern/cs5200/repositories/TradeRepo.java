package edu.northeastern.cs5200.repositories;


import org.springframework.data.repository.CrudRepository;
import edu.northeastern.cs5200.objects.Trade;

public interface TradeRepo extends CrudRepository<Trade, Integer>{
	
	
}
