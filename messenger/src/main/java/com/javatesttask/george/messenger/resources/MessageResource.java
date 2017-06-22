	package com.javatesttask.george.messenger.resources;

import java.util.List;
import com.javatesttask.george.messenger.model.*;
import com.javatesttask.george.messenger.service.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.javatesttask.george.messenger.model.Message;
import com.javatesttask.george.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Message> getMessages(){
		return messageService.getAllMessages();
		
	}
	@POST
	//@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
    public String addMessage(){
		return "Post Works";
	}
	
	@GET
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long id){		
		return messageService.getMessage(id);
	
	}

}
