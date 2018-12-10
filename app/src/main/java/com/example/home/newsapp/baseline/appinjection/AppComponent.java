package com.example.home.newsapp.baseline.appinjection;

import com.example.home.newsapp.MainActivity;
import com.example.home.newsapp.baseline.BasicFragment;
import com.example.home.newsapp.repository.injection.DataModule;

import javax.inject.Singleton;
import dagger.Component;



@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    void inject(MainActivity target);

    void inject(BasicFragment target);

//    MusicListComponent plus(MusicListModule musicListModule);
//
//    SongViewComponent plus(SongViewModule songViewModule);
}
