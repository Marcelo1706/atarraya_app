package com.liceoatarraya.app.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubjectSingleton {
    private static SubjectSingleton instance;
    private HashMap<String, SubjectModel> list = new HashMap<>();

    public HashMap<String, SubjectModel> getList() {
        return list;
    }

    public void setList(HashMap<String, SubjectModel> list) {
        this.list = list;
    }

    private void addToList(SubjectModel object) {
        if (object != null) this.list.put(object.getId(), object);
    }

    public List<SubjectModel> getSubjects() {
        return new ArrayList<>(list.values());
    }

    private SubjectSingleton() {
        addToList(new SubjectModel("Matemática"));
        addToList(new SubjectModel("Estudios Sociales"));
        addToList(new SubjectModel("Ciencia, Salud y Medio Ambiente"));
        addToList(new SubjectModel("Lenguaje y Literatura"));
        addToList(new SubjectModel("Inglés"));
    }

    public static SubjectSingleton getInstance() {
        if (instance == null) {
            instance = new SubjectSingleton();
        }
        return instance;
    }

    public static SubjectSingleton resetAndRenew() {
        if (instance != null) {
            instance = null;
        }
        instance = new SubjectSingleton();
        return instance;
    }

}
