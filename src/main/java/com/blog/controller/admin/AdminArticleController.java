package com.blog.controller.admin;

import com.blog.entity.Article;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @PostMapping("/add")
    public ResponseResult addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @PostMapping("/update")
    public ResponseResult updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }

    @PostMapping("/delete")
    public ResponseResult deleteArticle(@RequestBody Article article){
        return articleService.deleteArticle(article);
    }

}