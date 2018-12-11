package com.example.home.newsapp.screens.articleslist;

import com.example.home.newsapp.baseline.BaseContract;
import com.example.home.newsapp.model.Article;
import com.example.home.newsapp.repository.retrofit.model.ArticleModel;
import com.example.home.newsapp.repository.retrofit.model.ArticlesListResponse;
import com.example.home.newsapp.repository.retrofit.model.SorceModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;

public class MainArticlesPresenter implements MainArticlesContract.Presenter {


    private final MainArticlesContract.View view;
    private final BaseContract.Repository repository;

    @Inject
    public MainArticlesPresenter(MainArticlesContract.View view, BaseContract.Repository repository){

        this.view = view;
        this.repository = repository;
    }

    public void init(){
        ArticleModel article1 = new ArticleModel(new SorceModel("1", "name"), "", "title", "Gonzaga fell from No. 1 to No. 6 after it lost to Tennessee", "https://www.cbssports.com/college-basketball/news/college-basketball-rankings-kansas-back-at-no-1-while-duke-and-virginia-give-acc-two-in-top-three-of-coaches-poll/",
                "https://sportshub.cbsistatic.com/i/r/2018/12/10/7e3ced50-7664-4384-ae54-12a69aa18891/thumbnail/770x433/7706f99d5287edb08766b488212d2228/usatsi-11814162.jpg",
                "2018-12-10T18:20:00Z",
                "The Kansas Jayhawks are once again the No. 1 team in the USA Today Coaches Poll after going 2-0 this week");
//        List<ArticleModel> list = new ArrayList<>();
//        list.add(article1);
//        list.add(article1);
//        list.add(article1);
//        list.add(article1);
//
//        view.initAlbumAdapter(list);
        loadData();

    }


    private void loadData(){
        repository.downloadArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ArticlesListResponse>() {
                    @Override
                    public void onSuccess(ArticlesListResponse articlesListResponse) {
                        ArticlesListResponse list = articlesListResponse;
                        view.initAlbumAdapter(list.getArticles());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });



//                .subscribeWith(new DisposableCompletableObserver() {
//                    @Override
//                    public void onComplete() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                })
    }
}
