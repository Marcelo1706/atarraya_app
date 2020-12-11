package com.liceoatarraya.app.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssignmentSingleton {
    private static AssignmentSingleton instance;
    private HashMap<String, AssignmentModel> list = new HashMap<>();

    public HashMap<String, AssignmentModel> getList() {
        return list;
    }

    public void setList(HashMap<String, AssignmentModel> list) {
        this.list = list;
    }

    private void addToList(AssignmentModel object) {
        if (object != null) this.list.put(object.getId(), object);
    }

    public List<AssignmentModel> getAssignments() {
        return new ArrayList<>(list.values());
    }

    private AssignmentSingleton() {
        addToList(new AssignmentModel("Matemática"));
        addToList(new AssignmentModel("Estudios Sociales"));
        addToList(new AssignmentModel("Ciencia, Salud y Medio Ambiente"));
        addToList(new AssignmentModel("Lenguaje y Literatura"));
        addToList(new AssignmentModel("Inglés"));
    }

    public static AssignmentSingleton getInstance() {
        if (instance == null) {
            instance = new AssignmentSingleton();
        }
        return instance;
    }

    public static AssignmentSingleton resetAndRenew() {
        if (instance != null) {
            instance = null;
        }
        instance = new AssignmentSingleton();
        return instance;
    }
}
