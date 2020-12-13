package com.liceoatarraya.app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ConversationSingleton {

    private static ConversationSingleton instance;
    private HashMap<String, ConversationModel> list = new HashMap<>();

    private ConversationSingleton() {
        addToList(new ConversationModel("juan", "Gracias igualmente", new Date()));
        addToList(new ConversationModel("Luis", "Okay, pasa un buen día", new Date()));
        addToList(new ConversationModel("Luis", "Perfecto, gracias por el aviso", new Date()));
        addToList(new ConversationModel("juan", "Okay entendido", new Date()));
        addToList(new ConversationModel("Luis", "Sería al encargado del comite", new Date()));
        addToList(new ConversationModel("juan", "¿La entrega se te realizaría a ti o al encargado del comite?", new Date()));
        addToList(new ConversationModel("juan", "Muy bien, gracias. Quería comentarte que el día lunes se realizará la entrega de insumos para el evento del próximo sábado.", new Date()));
        addToList(new ConversationModel("Luis", "Buenos días Juan como te va?", new Date()));
        addToList(new ConversationModel("juan", "Hola", new Date()));
    }

    public static ConversationSingleton getInstance(){
        if (instance == null) {
            instance = new ConversationSingleton();
        }
        return instance;
    }

    public static void resetAndRenew(){
        if (instance != null) instance = null;
        instance = new ConversationSingleton();
    }

    public HashMap<String, ConversationModel> getList() {
        return list;
    }

    public void setList(HashMap<String, ConversationModel> list) {
        this.list = list;
    }

    private void addToList(ConversationModel object) {
        if (object != null) this.list.put(object.getId(), object);
    }

    public List<ConversationModel> getMessages() {
        return new ArrayList<>(list.values());
    }
}
