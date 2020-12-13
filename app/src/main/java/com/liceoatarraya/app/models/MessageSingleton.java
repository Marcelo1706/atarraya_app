package com.liceoatarraya.app.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MessageSingleton {
    private static MessageSingleton instance;
    private HashMap<String, MessageModel> list = new HashMap<>();
    

    public HashMap<String, MessageModel> getList() {
        return list;
    }

    public void setList(HashMap<String, MessageModel> list) {
        this.list = list;
    }

    private void addToList(MessageModel object) {
        if (object != null) this.list.put(object.getId(), object);
    }

    public List<MessageModel> getMessages() {
        return new ArrayList<>(list.values());
    }

    private MessageSingleton() {
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Hola buenos días", new Date()));
        addToList(new MessageModel("Juan Perez", "Un mensaje nuevo", new Date()));
        addToList(new MessageModel("Juan Perez", "Un mensaje nuevo", new Date()));
        addToList(new MessageModel("Juan Perez", "Un mensaje nuevo", new Date()));
    }

    public static MessageSingleton getInstance() {
        if (instance == null) {
            instance = new MessageSingleton();
        }
        return instance;
    }

    public static MessageSingleton resetAndRenew() {
        if (instance != null) {
            instance = null;
        }
        instance = new MessageSingleton();
        return instance;
    }
}
