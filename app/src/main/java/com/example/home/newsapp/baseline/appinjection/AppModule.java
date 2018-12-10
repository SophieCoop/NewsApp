package com.example.home.newsapp.baseline.appinjection;

import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }


    @Provides
    @Singleton
    public Context provideContext() {
        return mApplication;
    }

}