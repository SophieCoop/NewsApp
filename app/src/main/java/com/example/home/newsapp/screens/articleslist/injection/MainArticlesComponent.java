package com.example.home.newsapp.screens.articleslist.injection;

import com.example.home.newsapp.screens.articleslist.MainArticlesFragment;

import dagger.Subcomponent;

@Subcomponent(modules = MainArticlesModule.class)
public interface MainArticlesComponent {

    void inject(MainArticlesFragment fragment);
}