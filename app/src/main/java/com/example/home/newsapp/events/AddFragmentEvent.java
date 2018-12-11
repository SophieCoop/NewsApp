package com.example.home.newsapp.events;

import com.example.home.newsapp.baseline.BasicFragment;

public class AddFragmentEvent {

    private BasicFragment fragment;

    public AddFragmentEvent(BasicFragment fragment) {

        this.fragment = fragment;
    }

    public BasicFragment getFragment() {
        return fragment;
    }
}
