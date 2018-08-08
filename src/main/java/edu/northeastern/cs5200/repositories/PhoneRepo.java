package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Phone;

public interface PhoneRepo extends CrudRepository<Phone, Integer>{

}
