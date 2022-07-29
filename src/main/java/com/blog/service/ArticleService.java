package com.blog.service;

import com.blog.entity.Article;
import com.blog.utils.ResponseResult;

public interface ArticleService {
    ResponseResult getArticleAll();

    ResponseResult getArticlePage(int pageIndex, int number);

    ResponseResult findArticleById(int id);

    ResponseResult addArticle(Article article);

    ResponseResult updateArticle(Article article);

    ResponseResult deleteArticle(Article article);

    ResponseResult getArticlePageByTagId(int tid, int page, int number);

    ResponseResult getArticleNumber();
}
