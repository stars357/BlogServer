package com.blog.mapper;

import com.blog.entity.Article;
import com.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleMapper {

    List getArticleAll();

    Article findArticleById(@Param("id") int id);

    List getArticlePage(@Param("pageIndex")int pageIndex, @Param("number")int number);

    List getArticleTag(@Param("id")int id);

    int addArticle(Article article);

    Boolean addArticleTag(@Param("aid")int aid, @Param("tid")int tid);

    Boolean deleteArticleById(@Param("id")int id);

    Boolean deleteArticleTag(@Param("aid")int aid, @Param("tid")int tid);

    Boolean updateArticle(Article article);

    List<Integer> getArticleIdByTagId(@Param("tid")int tid, @Param("pageIndex")int pageIndex, @Param("number")int number);

    int getArticleNumber();

}
