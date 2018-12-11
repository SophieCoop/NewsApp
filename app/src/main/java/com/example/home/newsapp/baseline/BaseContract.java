package com.example.home.newsapp.baseline;

import com.example.home.newsapp.repository.retrofit.model.ArticlesListResponse;
import io.reactivex.Single;



public interface BaseContract {

    interface View {

    }
    interface Presenter {

    }

    interface Repository {

        Single<ArticlesListResponse> downloadArticles();
    }
}
