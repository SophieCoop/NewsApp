package com.example.home.newsapp.screens.articleview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.home.newsapp.MainActivity;
import com.example.home.newsapp.R;
import com.example.home.newsapp.baseline.BasicFragment;
import com.example.home.newsapp.events.UpdateActionBarTitleEvent;


import butterknife.BindView;
import butterknife.ButterKnife;


public class ArticleFragment extends BasicFragment{

    @BindView(R.id.web_view)
    WebView webView;

    public static final String URL = "URL";
    public static final String TITLE = "TITLE";
    private String urlWebPage;
    private String articleTitle;


    public static ArticleFragment newInstance(String urlWebPage, String articleTitle) {

        Bundle args = new Bundle();
        args.putString(URL, urlWebPage);
        args.putString(TITLE, articleTitle);
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        if(args != null){
            urlWebPage = args.getString(URL);
            articleTitle = args.getString(TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, view);

        updateActionBarTitle(articleTitle);
        setWebPage(urlWebPage);

        return view;
    }

    private void setWebPage(String urlWebPage){
        webView.setWebViewClient(new MainActivity.MyWebViewClient());
//        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(urlWebPage);
        webView.requestFocus();
    }



}
