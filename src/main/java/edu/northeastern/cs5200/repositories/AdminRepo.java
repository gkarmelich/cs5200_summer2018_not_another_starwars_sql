package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer>{

}
