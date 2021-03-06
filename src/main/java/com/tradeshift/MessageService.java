package com.tradeshift;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MessageService {
    @Autowired
    MessagesDAO messagesDAO;

    public String getMsg(){
        return "YKG";
    }

    public Message getJSON(Message msgIn){
        msgIn.setId(UUID.randomUUID());
        msgIn.setPostedAt(ISO8601Utils.format(Calendar.getInstance().getTime(), true, TimeZone.getTimeZone("UTC")));
        messagesDAO.saveMessage(msgIn);
        return msgIn;
    }

    public LatestMessages getLatestMessages(int limit){
        List<Message> messages = messagesDAO.getMessages(limit);
        LatestMessages latestMessages = new LatestMessages();
        latestMessages.setCount(messages.size());
        latestMessages.setMessages(messages);
        return latestMessages;
    }
}
