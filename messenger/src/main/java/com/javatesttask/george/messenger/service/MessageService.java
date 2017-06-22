package com.javatesttask.george.messenger.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javatesttask.george.messenger.database.DatabaseClass;
import com.javatesttask.george.messenger.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1l, new Message(1,"Message1","joro"));
		messages.put(2l, new Message(2,"Message2","joro"));
		messages.put(3l, new Message(3,"Message3","joro"));
	}
	
 public List<Message> getAllMessages(){
	 
	 return new ArrayList<Message>(messages.values());
	} 
 
 public Message getMessage(long id){
	return messages.get(id);
	
	}
 public Message addMessage(Message message){
	 message.setId(messages.size()+1);
	 messages.put(message.getId(),message);
	 return message;
	
	}
 public Message updateMessage(Message message){
	 if (message.getId()<=0){
		 return null;
	 }
	 messages.put(message.getId(), message);
	 return message;
	
	}
 public Message removeMessage(long id){
	return messages.remove(id);
	
	}
}
