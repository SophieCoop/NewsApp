package com.example.home.newsapp.screens.articleitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.home.newsapp.R;
import com.example.home.newsapp.events.AddFragmentEvent;
import com.example.home.newsapp.repository.retrofit.model.ArticleModel;
import com.example.home.newsapp.screens.articleview.ArticleFragment;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

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

    @BindView(R.id.sub_text)
    TextView subText;

    private ArticleModel article;


    public ArticleHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new AddFragmentEvent(ArticleFragment.newInstance(article.getUrl(), article.getTitle())));
            }
        });
        ButterKnife.bind(this, itemView);
    }

    public void setData(ArticleModel article, int position){
        this.article = article;
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
//                .placeholder(R.drawable.)
                .fit()
                .centerCrop()
                .into(articleImg);
        articleTitle.setText(article.getTitle());
        articleDate.setText(date);
        subText.setText(article.getContent());


    }

}
