package com.tradeshift;

import java.util.ArrayList;

public class LatestMessages {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    int count; // TODO long? BigInteger?
    ArrayList<Message> messages;
}
