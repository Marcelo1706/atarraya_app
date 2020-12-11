package com.liceoatarraya.app.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class NotificationSingleton {
    private static NotificationSingleton instance;
    private HashMap<String, NotificationModel> list = new HashMap<>();


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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        try {
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/11/2010 14:10:20"), 0));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/11/2010 14:10:19"), 1));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/11/2010 14:09:20"), 0));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("25/10/2010 14:10:20"), 0));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/10/2010 14:10:20"), 1));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/11/2010 14:10:20"), 0));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/09/2010 14:10:20"), 1));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/11/2010 13:10:20"), 0));
            addToList(new NotificationModel("1", "Se ha ingresado una tarea", sdf.parse("01/11/2010 12:10:20"), 0));
        } catch (ParseException pe){
            System.out.println(pe.getMessage());
        }
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
