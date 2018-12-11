package com.example.home.newsapp.repository.injection;

import android.content.Context;

import com.example.home.newsapp.baseline.BaseContract;
import com.example.home.newsapp.repository.LocalData;
import com.example.home.newsapp.repository.RemoteData;
import com.example.home.newsapp.repository.RepositoryImpl;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class DataModule {


    @Singleton
    @Provides
    public RemoteData provideRemoteData() {
        return new RemoteData();

    }

    @Singleton
    @Provides
    public LocalData provideLocalData(Context context) {
        return new LocalData(context);

    }



    @Singleton
    @Provides
    public BaseContract.Repository provideMainRepository(RepositoryImpl repository) {
        return repository;
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}