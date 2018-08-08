package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Staff;

public interface StaffRepo extends CrudRepository<Staff, Integer>{

}
