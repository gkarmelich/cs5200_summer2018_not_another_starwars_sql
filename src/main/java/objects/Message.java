package objects;

public class Message {
	private int idMessage;
	private int idSender;
	private int idReceiver;
	private String messageContent;
	
	public Message(int idMessage, int idSender, int idReceiver, String messageContent) {
		super();
		this.idMessage = idMessage;
		this.idSender = idSender;
		this.idReceiver = idReceiver;
		this.messageContent = messageContent;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public int getIdSender() {
		return idSender;
	}

	public void setIdSender(int idSender) {
		this.idSender = idSender;
	}

	public int getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}



}
