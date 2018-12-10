package com.example.home.newsapp.screens.article;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.newsapp.model.Article;
import com.example.home.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticleHolder>{

    private List<Article> articlesList = new ArrayList<>();


    public ArticlesAdapter(List<Article> albumList){
        this.articlesList.addAll(albumList);
    }


    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
//        context = parent.getContext();
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {
        holder.setData(articlesList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }
}
