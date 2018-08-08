package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Investor;

public interface InvestorRepo extends CrudRepository<Investor, Integer> {

}
