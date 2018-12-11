package com.example.home.newsapp.screens.articleslist;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.home.newsapp.R;
import com.example.home.newsapp.baseline.BasicFragment;
import com.example.home.newsapp.baseline.NewsApplication;
import com.example.home.newsapp.repository.retrofit.model.ArticleModel;
import com.example.home.newsapp.screens.articleitem.ArticlesAdapter;
import com.example.home.newsapp.events.UpdateActionBarTitleEvent;
import com.example.home.newsapp.screens.articleslist.injection.MainArticlesModule;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;




public class MainArticlesFragment extends BasicFragment implements MainArticlesContract.View {

    @Inject
    MainArticlesContract.Presenter presenter;


    @BindView(R.id.articles_list)
    RecyclerView articlesRecyclerView;

    public static MainArticlesFragment newInstance() {

        Bundle args = new Bundle();
        MainArticlesFragment fragment = new MainArticlesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NewsApplication.getAppComponent()
                .plus(new MainArticlesModule(this))
                .inject(this);
//        Bundle args = getArguments();
//
//        if(args != null){
//            actionBar = args.getParcelable(ACTIONBAR);
//        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_articles, container, false);
        ButterKnife.bind(this, view);

        updateActionBarTitle("NewsApp Candidate Assignment");

        presenter.init();

        return view;
    }


    public void initAlbumAdapter(List<ArticleModel> albumslList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        articlesRecyclerView.setLayoutManager(linearLayoutManager);
        ArticlesAdapter adapter = new ArticlesAdapter(albumslList);
        articlesRecyclerView.setAdapter(adapter);
    }


}
