package com.liceoatarraya.app.models;

import java.util.Date;
import java.util.UUID;

public class MessageModel {
    private String id;
    private String user;
    private String content;
    private Date datetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public MessageModel(String user, String content, Date datetime) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.content = content;
        this.datetime = datetime;
    }
}
