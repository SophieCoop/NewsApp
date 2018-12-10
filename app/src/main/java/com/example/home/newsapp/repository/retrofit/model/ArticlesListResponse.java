package com.example.home.newsapp.repository.retrofit.model;

import java.util.List;



public class ArticlesListResponse {

    private String status;
    private int totalResults;
    private List<ArticleModel> articles;

    public ArticlesListResponse(String status, int totalResults, List<ArticleModel> articles) {

        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }


    public List<ArticleModel> getArticles() {
        return articles;
    }
}
