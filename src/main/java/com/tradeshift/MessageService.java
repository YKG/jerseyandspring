package com.tradeshift;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MessageService {
    public String getMsg(){
        return "YKG";
    }

    public Object getJSON(Message msgIn){
        msgIn.setId(UUID.randomUUID());
        msgIn.setPostedAt(ISO8601Utils.format(Calendar.getInstance().getTime(), true, TimeZone.getTimeZone("UTC")));
        return msgIn;
    }
}
