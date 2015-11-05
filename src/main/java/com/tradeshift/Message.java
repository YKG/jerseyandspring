package com.tradeshift;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Message {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                "}@" + this.hashCode();
    }

    UUID id;
    String user;
    String message;
    String postedAt;
}
