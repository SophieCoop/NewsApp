package com.example.home.newsapp.baseline.appinjection;

import com.example.home.newsapp.MainActivity;
import com.example.home.newsapp.baseline.BasicFragment;
import com.example.home.newsapp.repository.injection.DataModule;
import com.example.home.newsapp.screens.articleslist.injection.MainArticlesComponent;
import com.example.home.newsapp.screens.articleslist.injection.MainArticlesModule;

import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    void inject(MainActivity target);

    void inject(BasicFragment target);

    MainArticlesComponent plus(MainArticlesModule mainArticlesModule);

}
