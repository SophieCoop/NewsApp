package com.example.home.newsapp.repository.retrofit.model;

public class SorceModel {

    private final String id;
    private final String name;

    public SorceModel(String id, String name){

        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
