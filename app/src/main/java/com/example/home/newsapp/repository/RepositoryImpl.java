package com.example.home.newsapp.repository;

import com.example.home.newsapp.baseline.BaseContract;
import com.example.home.newsapp.repository.retrofit.model.ArticlesListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class RepositoryImpl implements BaseContract.Repository {

    private RemoteData remoteRepo;
    private LocalData localData;

    @Inject
    public RepositoryImpl(RemoteData remoteRepo, LocalData localData) {
        this.remoteRepo = remoteRepo;
        this.localData = localData;
    }

    @Override
    public Single<ArticlesListResponse> downloadArticles() {
        return remoteRepo.getArticlesList()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
