package com.example.home.newsapp.repository;


import com.example.home.newsapp.repository.retrofit.api.BackEndApi;
import com.example.home.newsapp.repository.retrofit.model.ArticlesListResponse;

import io.reactivex.Single;

public class RemoteData {
    public Single<ArticlesListResponse> getArticlesList() {
        return BackEndApi.getApi().getArticlesList();
    }

}
