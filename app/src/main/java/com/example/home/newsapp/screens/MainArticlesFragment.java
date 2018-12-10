package com.example.home.newsapp.screens;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.newsapp.R;
import com.example.home.newsapp.model.Article;
import com.example.home.newsapp.screens.article.ArticlesAdapter;
import com.example.home.newsapp.events.UpdateActionBarTitleEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;




public class MainArticlesFragment extends Fragment {
    public static final String ACTIONBAR = "ACTIONBAR";


    @BindView(R.id.articles_list)
    RecyclerView articlesRecyclerView;

    private ActionBar actionBar;

    public static MainArticlesFragment newInstance() {

        Bundle args = new Bundle();
//        args.putParcelable(ACTIONBAR, (Parcelable) actionBar);
        MainArticlesFragment fragment = new MainArticlesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        Article article1 = new Article("", "title", "Gonzaga fell from No. 1 to No. 6 after it lost to Tennessee", "https://www.cbssports.com/college-basketball/news/college-basketball-rankings-kansas-back-at-no-1-while-duke-and-virginia-give-acc-two-in-top-three-of-coaches-poll/",
                "https://sportshub.cbsistatic.com/i/r/2018/12/10/7e3ced50-7664-4384-ae54-12a69aa18891/thumbnail/770x433/7706f99d5287edb08766b488212d2228/usatsi-11814162.jpg",
                "2018-12-10T18:20:00Z",
                "The Kansas Jayhawks are once again the No. 1 team in the USA Today Coaches Poll after going 2-0 this week");
        List<Article> list = new ArrayList<>();
        list.add(article1);
        list.add(article1);
        list.add(article1);
        list.add(article1);
        initAlbumAdapter(list);

        return view;
    }


    public void initAlbumAdapter(List<Article> albumslList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        articlesRecyclerView.setLayoutManager(linearLayoutManager);
        ArticlesAdapter adapter = new ArticlesAdapter(albumslList);
        articlesRecyclerView.setAdapter(adapter);
    }

    private void updateActionBarTitle(String title){
        EventBus.getDefault().post(new UpdateActionBarTitleEvent(title));
    }
}
