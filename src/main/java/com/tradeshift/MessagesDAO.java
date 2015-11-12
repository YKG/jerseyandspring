package com.tradeshift;

import java.util.List;

public interface MessagesDAO {
    List<Message> getMessages(int limit);
    void saveMessage(Message msg);
}
