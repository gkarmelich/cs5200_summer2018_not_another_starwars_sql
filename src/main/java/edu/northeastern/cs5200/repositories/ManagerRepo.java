package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Manager;

public interface ManagerRepo extends CrudRepository<Manager, Integer>{

}
