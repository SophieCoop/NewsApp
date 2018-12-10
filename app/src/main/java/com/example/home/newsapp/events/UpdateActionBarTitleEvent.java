package com.example.home.newsapp.events;

public class UpdateActionBarTitleEvent {

    private final String title;

    public UpdateActionBarTitleEvent(String title){

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
