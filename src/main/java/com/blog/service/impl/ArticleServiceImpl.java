package com.blog.service.impl;

import com.blog.entity.Article;
import com.blog.entity.Tag;
import com.blog.mapper.ArticleMapper;
import com.blog.service.ArticleService;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResponseResult getArticleAll() {
//        try {
//            List<Article> articles = articleMapper.getArticleAll();
//            return new ResponseResult(200, "文章获取成功", articles);
//        }catch (Exception e){
//            return new ResponseResult(500, "文章获取失败", e.getMessage());
//        }
        return new ResponseResult(200, "文章获取成功", articleMapper.getArticleAll());
    }

    @Override
    public ResponseResult getArticlePage(int pageIndex, int number) {
        return new ResponseResult(200, "分页获取文章成功", articleMapper.getArticlePage(pageIndex, number));
    }

    @Override
    public ResponseResult findArticleById(int id) {
        return new ResponseResult(200, "查找文章成功", articleMapper.findArticleById(id));
    }

    @Override
    public ResponseResult addArticle(Article article) {
        articleMapper.addArticle(article);
        int aid = article.getId();

        List<Tag>  tags = article.getTags();
        tags.stream().forEach(tag -> {
            articleMapper.addArticleTag(aid, tag.getId());
        });

        return new ResponseResult(200, "文章添加成功");
    }

    @Override
    public ResponseResult updateArticle(Article article) {
//        System.out.println(article);
        articleMapper.updateArticle(article);
        return new ResponseResult(200, "文章修改成功");
    }

    @Override
    public ResponseResult deleteArticle(Article article) {
        int aid = article.getId();
//        System.out.println(aid);
        articleMapper.deleteArticleById(aid);
        List<Tag> tags = article.getTags();
        tags.stream().forEach(tag -> {
            articleMapper.deleteArticleTag(aid, tag.getId());
        });
        return new ResponseResult(200, "删除文章成功");
    }

    @Override
    public ResponseResult getArticlePageByTagId(int tid, int page, int number) {
        List<Integer> articleIds = articleMapper.getArticleIdByTagId(tid, page, number);
        List<Article> articles = new ArrayList<Article>();
        articleIds.stream().forEach(articleId -> {
            articles.add(articleMapper.findArticleById(articleId));
        });
        return new ResponseResult(200, "标签文章查询成功", articles);
    }

    @Override
    public ResponseResult getArticleNumber() {
        return new ResponseResult(200, "获取文章数量成功", articleMapper.getArticleNumber());
    }
}
