package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.objects.Message;

public interface MessageRepo extends CrudRepository<Message, Integer>{

}
