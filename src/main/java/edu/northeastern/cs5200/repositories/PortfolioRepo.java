package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Portfolio;

public interface PortfolioRepo extends CrudRepository<Portfolio, Integer>{

}
