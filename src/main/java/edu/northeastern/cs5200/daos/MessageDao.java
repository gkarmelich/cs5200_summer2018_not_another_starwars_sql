package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

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
	
	public void test() {
		this.createMessage(1, 2, "Hi World");
		this.createMessage(2, 1, "What is this");
		
	}

}
