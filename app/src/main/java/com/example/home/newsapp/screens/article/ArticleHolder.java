package com.example.home.newsapp.screens.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.newsapp.model.Article;
import com.example.home.newsapp.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.article_img)
    ImageView articleImg;

    @BindView(R.id.article_title)
    TextView articleTitle;

    @BindView(R.id.article_date)
    TextView articleDate;

    private Context context;


    public ArticleHolder(@NonNull View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    public void setData(Article article, int position){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        String date = "";
        try {
            Date newDate = format.parse(article.getPublishedAt());
            format = new SimpleDateFormat("EEE, dd MMM yyyy, hh:mm", Locale.ENGLISH);
            date = format.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Picasso.get()
                .load(article.getUrlToImage())
//                .placeholder(R.drawable.record)
                .into(articleImg);
        articleTitle.setText(article.getTitle());
        articleDate.setText(date);


    }

}
