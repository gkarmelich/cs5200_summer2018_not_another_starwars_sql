package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Address;

public interface AddressRepo extends CrudRepository<Address, Integer>{

}
