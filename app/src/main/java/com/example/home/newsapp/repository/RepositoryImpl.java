package com.example.home.newsapp.repository;

import com.example.home.newsapp.baseline.BaseContract;
import javax.inject.Inject;


/**
 * Created by SophieC on 22/02/2018
 */

public class RepositoryImpl implements BaseContract.Repository {

    private RemoteData remoteRepo;
    private LocalData localData;

    @Inject
    public RepositoryImpl(RemoteData remoteRepo, LocalData localData) {
        this.remoteRepo = remoteRepo;
        this.localData = localData;
    }

}
