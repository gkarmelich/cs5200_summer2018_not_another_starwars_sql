package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Sell;

public interface SellRepo extends CrudRepository<Sell, Integer> {

}
