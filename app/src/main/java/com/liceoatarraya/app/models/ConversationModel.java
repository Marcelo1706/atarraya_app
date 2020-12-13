package com.liceoatarraya.app.models;

import java.util.Date;
import java.util.UUID;

public class ConversationModel {
    private String id;
    private String user;
    private String content;
    private Date datetimeSend;

    public ConversationModel(String user, String content, Date datetimeSend) {
        this.id = UUID.randomUUID().toString();;
        this.user = user;
        this.content = content;
        this.datetimeSend = datetimeSend;
    }

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

    public Date getDatetimeSend() {
        return datetimeSend;
    }

    public void setDatetimeSend(Date datetimeSend) {
        this.datetimeSend = datetimeSend;
    }
}
