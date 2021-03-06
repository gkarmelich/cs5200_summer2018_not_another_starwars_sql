package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.objects.Message;
import edu.northeastern.cs5200.repositories.MessageRepo;

@Component
public class MessageDao {
	
	@Autowired
	MessageRepo messageRepo;
	
	public List<Message> findAllMessages() {
		List<Message> messages = new ArrayList<>();
		messages =  (List<Message>) messageRepo.findAll();
		return messages;
	}
	
	public void createMessage(int idSender, int idReceiver, String messageContent) {
		Message message = new Message(idSender, idReceiver, messageContent);
		messageRepo.save(message);
	}
	
	public void deleteMessageById(int id) {
		Optional<Message> message = messageRepo.findById(id);
		if (message != null) {
			Message m = message.get();
			messageRepo.deleteById(m.getIdMessage());
		}
	}
	
	public Message findMessageById(int id) {
		Optional<Message> message = messageRepo.findById(id);
		if (message != null) {
			return message.get();
		}
		return null;
	}
	
	public void test() {
		this.createMessage(3, 2, "Hi World");
		this.createMessage(2, 3, "Who is this");
	}

}
