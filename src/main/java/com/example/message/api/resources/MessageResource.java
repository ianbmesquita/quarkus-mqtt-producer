package com.example.message.api.resources;

import com.example.message.application.MessageService;
import com.example.message.domain.model.Message;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/message")
public class MessageResource {
    @Inject
    private MessageService messageService;
    
    @GET
    @Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    public void send(Message message){
        try {
            messageService.send(message);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
