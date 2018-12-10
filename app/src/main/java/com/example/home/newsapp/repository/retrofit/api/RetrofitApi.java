package com.example.home.newsapp.repository.retrofit.api;

import com.example.home.newsapp.repository.retrofit.model.ArticlesListResponse;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface RetrofitApi {

    @GET("top-headlines?country=us&apiKey=4a0e9e38a7a04fc9afdcb190357dcf8b")
    Single<ArticlesListResponse> getArticlesList(

    );

//    @POST("UpdateSongLyrics")
//    Completable sendLyrics(
//            @Body SongModel song
//    );
}
