package com.liceoatarraya.app.models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class NotificationSingleton {
    private static NotificationSingleton instance;
    private HashMap<String, NotificationModel> list = new HashMap<>();
    ;

    public HashMap<String, NotificationModel> getList() {
        return list;
    }

    public void setList(HashMap<String, NotificationModel> list) {
        this.list = list;
    }

    private void addToList(NotificationModel object) {
        if (object != null) this.list.put(object.getId(), object);
    }

    public List<NotificationModel> getNotifications() {
        return new ArrayList<>(list.values());
    }

    private NotificationSingleton() {
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
        addToList(new NotificationModel("1", "Se ha ingresado una tarea", new Date()));
    }

    public static NotificationSingleton getInstance() {
        if (instance == null) {
            instance = new NotificationSingleton();
        }
        return instance;
    }

    public static NotificationSingleton resetAndRenew() {
        if (instance != null) {
            instance = null;
        }
        instance = new NotificationSingleton();
        return instance;
    }
}
