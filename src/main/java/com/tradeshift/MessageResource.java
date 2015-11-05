package com.tradeshift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Component
@Path("messages")
public class MessageResource {
    @Autowired
    private MessageService messageService;

    @GET
    public String getMsg(){
        return messageService.getMsg();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getJSON(Message msgIn){
        System.out.println("in: " + msgIn);
        return Response.status(200).entity(messageService.getJSON(msgIn)).build();
    }
}
