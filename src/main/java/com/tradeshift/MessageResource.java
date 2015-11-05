package com.tradeshift;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("messages")
public class MessageResource {
    @Autowired
    private MessageService messageService;

    @GET
    public String getMsg(){
        return messageService.getMsg();
    }
}
