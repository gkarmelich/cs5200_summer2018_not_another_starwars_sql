package edu.northeastern.cs5200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.MessageDao;
import edu.northeastern.cs5200.objects.Message;
import edu.northeastern.cs5200.repositories.MessageRepo;

@RestController
@RequestMapping("/api")
public class MessageService {
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	MessageRepo messageRepo;
	
	@GetMapping("/message")
	public List<Message> findAllMessages() {
		return messageDao.findAllMessages();
	}
	
	@PostMapping("/message")
	public void createMessage(@RequestBody Message message) {
		messageDao.createMessage(message.getIdSender(), message.getIdSender(), message.getMessageContent());
	}
	
	@GetMapping("/message/{id}")
	public Message findMessageById(@PathVariable("id") int id) {
		return messageDao.findMessageById(id);
	}
	
	@DeleteMapping("/message/{id}")
	public void deleteMessage(@PathVariable("id") int id) {
		messageDao.deleteMessageById(id);
	}
}
