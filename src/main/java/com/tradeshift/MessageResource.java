package com.tradeshift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.UUID;

@Component
@Path("m")
public class MessageResource {
    @Autowired
    private MessageService messageService;

    @GET
    @Path("")
    public String getMsg(){
        return messageService.getMsg();
    }

    @GET
    @Path("{name}")
    public String getName(@PathParam("name") String name){
        System.out.println("====> " + name);
        System.out.println(URI.create("a%2Fb").toString());
        return name;
    }

    @GET
    @Path("x/{name}")
    public Response getX(@PathParam("name") String name){
        String str = "=?UTF-8?Q?123=E4=BD=A0=E5=A5=BD=22A=27foo-=C3=A4-=E2=82=AC=2Ehtml?=";
        return Response.ok()
//                .header("Content-Disposition", "attachment; filename=\"Ex y z10 !@#$<>{3}[]+&^*.`\\'\":test_*().,.pdf\"")
                .header("Content-Disposition",
                        "attachment; filename=\"" + str + "\"")
                .build();
    }

    @GET
    @Path("{name}/{name2}")
    public String getName(@PathParam("name") String name, @PathParam("name2") String name2){
        System.out.println("====> " + name + " name2: " + name2);
        return name + name2;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getJSON(Message msgIn){
        System.out.println("in: " + msgIn);
        return Response.status(200).entity(messageService.getJSON(msgIn)).build();
    }
}
