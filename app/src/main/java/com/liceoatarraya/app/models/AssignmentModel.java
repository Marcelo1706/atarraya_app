package com.liceoatarraya.app.models;

import java.util.UUID;

public class AssignmentModel {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AssignmentModel(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
