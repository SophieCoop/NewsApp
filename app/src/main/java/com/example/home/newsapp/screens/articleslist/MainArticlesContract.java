package com.example.home.newsapp.screens.articleslist;

import com.example.home.newsapp.baseline.BaseContract;
import com.example.home.newsapp.model.Article;
import com.example.home.newsapp.repository.retrofit.model.ArticleModel;

import java.util.List;

public interface MainArticlesContract {

    interface View extends BaseContract.View {
        void initAlbumAdapter(List<ArticleModel> albumslList);

    }

    interface Presenter extends BaseContract.Presenter {
        void init();
    }
}
