package com.tradeshift;

import java.util.ArrayList;
import java.util.List;

public class LatestMessages {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    int count; // TODO long? BigInteger?
    List<Message> messages;
}
