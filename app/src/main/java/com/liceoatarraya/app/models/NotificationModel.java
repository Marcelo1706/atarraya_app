package com.liceoatarraya.app.models;

import java.util.Date;
import java.util.UUID;

public class NotificationModel {
    private String id;
    private String type;
    private String description;
    private Date datetime;
    private Integer read;

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public NotificationModel(String type, String description, Date datetime, Integer read) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.description = description;
        this.datetime = datetime;
        this.read = read;
    }


}
