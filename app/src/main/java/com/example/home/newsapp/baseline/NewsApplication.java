package com.example.home.newsapp.baseline;

import android.app.Application;
import android.support.annotation.NonNull;
import com.example.home.newsapp.baseline.appinjection.AppComponent;
import com.example.home.newsapp.baseline.appinjection.AppModule;
import com.example.home.newsapp.baseline.appinjection.DaggerAppComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class NewsApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger();

        Realm.init(this);

        final RealmConfiguration configuration = new RealmConfiguration.Builder().name("myMusic.realm").
                schemaVersion(1)
                .migration(new RealmMigrations())
                .build();
        Realm.deleteRealm(configuration);
        Realm.setDefaultConfiguration(configuration);
        Realm.getInstance(configuration);

    }

    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }

    @NonNull
    private AppComponent initDagger() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}