package com.example.home.newsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.home.newsapp.baseline.NewsApplication;
import com.example.home.newsapp.events.AddFragmentEvent;
import com.example.home.newsapp.screens.articleslist.MainArticlesFragment;
import com.example.home.newsapp.events.UpdateActionBarTitleEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Fragment currentFragment;
    ActionBar actionBar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsApplication.getAppComponent().inject(this);

        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        actionBar = getSupportActionBar();
        replaceFragment(MainArticlesFragment.newInstance(), "MainArticlesFragment");

    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    @Subscribe
    public void addFragment(AddFragmentEvent event){
        replaceFragment(event.getFragment(), event.getFragment().getClass().getName());
    }

    private void addFragment(Fragment fragment, String fragmentName){
        getSupportFragmentManager()
                .beginTransaction()
                .add(fragment, fragmentName)
//                .addToBackStack(fragmentName)
                .commit();
    }

    private void replaceFragment(Fragment newFragment, String fragmentName){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(fragmentName)
                .commit();

        currentFragment = newFragment;

    }

    @Subscribe
    public void updateActionBarTitle(UpdateActionBarTitleEvent event){
        actionBar.setTitle(event.getTitle());
    }

    public static class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
