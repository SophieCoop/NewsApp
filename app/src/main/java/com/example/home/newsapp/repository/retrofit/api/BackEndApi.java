package com.example.home.newsapp.repository.retrofit.api;

import android.util.Log;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class BackEndApi {

    private static String BASE_URL = "https://newsapi.org/v2/";
//
    private static RetrofitApi instance;


    public static RetrofitApi getApi() {
        if (instance == null) {

            final HttpLoggingInterceptor logging =
                    new HttpLoggingInterceptor(BackEndApi::logHttpMessage)
                            .setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            httpClient.addInterceptor(logging);

            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory
                                    .createWithScheduler(Schedulers.io()))

                    .client(httpClient.build())
                    .build();
            instance = retrofit.create(RetrofitApi.class);
        }
        return instance;
    }




    private static final String TAG = "BackEndApi";

    private static void logHttpMessage(String message) {
        if (message.length() < 10000) {
            Log.d(TAG, message);
        } else {
            Log.d(TAG, message.substring(0, 10000) +
                    "[... + " +
                    (message.length() - 10000) +
                    " chars]");
        }
    }


}
