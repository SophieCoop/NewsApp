package com.example.home.newsapp.baseline;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.home.newsapp.baseline.appinjection.AppComponent;
import com.example.home.newsapp.baseline.appinjection.AppModule;
import com.example.sophec.mymusicapplication.baseline.appinjection.AppModule;
import com.example.sophec.mymusicapplication.baseline.appinjection.DaggerAppComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by SophieC on 22/02/2018
 */

public class NewsApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger();

//        Realm.init(this);
//
        final RealmConfiguration configuration = new RealmConfiguration.Builder().name("myMusic.realm").
                schemaVersion(1)
                .migration(new RealmMigrations())
                .build();
        Realm.deleteRealm(configuration);
        Realm.setDefaultConfiguration(configuration);
        Realm.getInstance(configuration);

//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Reef.otf")
//                .setFontAttrId(R.attr.fontPath)
//                .build());
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
//                .pictarModule(new PictarModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}