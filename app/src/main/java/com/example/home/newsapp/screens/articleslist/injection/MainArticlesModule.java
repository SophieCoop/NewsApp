package com.example.home.newsapp.screens.articleslist.injection;

import com.example.home.newsapp.screens.articleslist.MainArticlesContract;
import com.example.home.newsapp.screens.articleslist.MainArticlesPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainArticlesModule {

    private MainArticlesContract.View view;

    public MainArticlesModule(MainArticlesContract.View view){

        this.view = view;
    }

    @Provides
    public MainArticlesContract.Presenter providesArticlesListPresenter(MainArticlesPresenter presenter){
        return presenter;
    }

    @Provides
    public MainArticlesContract.View providesArticlesListView(){
        return view;
    }
}
