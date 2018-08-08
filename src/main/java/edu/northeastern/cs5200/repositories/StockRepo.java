package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Stock;

public interface StockRepo extends CrudRepository<Stock, Integer>{

}
