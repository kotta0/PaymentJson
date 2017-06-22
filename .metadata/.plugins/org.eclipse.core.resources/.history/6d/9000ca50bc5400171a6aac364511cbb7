package com.georgetask.messageloader.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.georgetask.messageloader.database.DatabaseClass;
import com.georgetask.messageloader.model.Message;

@XmlRootElement
public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1,"Message1","joro"));
		 messages.put(2L, new Message(2,"Message2","joro"));
		 messages.put(3L, new Message(3,"Message3","joro"));
		
	}
	
 public List<Message> getAllMessages(){
	 
	 List<Message> listMessages = new ArrayList<Message>(messages.values());
	 return listMessages;
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