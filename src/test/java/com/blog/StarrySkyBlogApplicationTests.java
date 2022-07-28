package com.blog;

import com.blog.entity.Article;
import com.blog.entity.Tag;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.TagMapper;
import com.blog.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class StarrySkyBlogApplicationTests {


    @Test
    void contextLoads() {
    }

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private TagMapper tagMapper;

    @Test
    void demo(){
//        Article article = new Article();
//        article.setTitle("dem11");
//        article.setText("demo11");
//        articleMapper.addArticle(article);
//        System.out.println(article.getId());
//        Tag tag = new Tag(3, "abc", "");
//
//        List<Tag> tags = new ArrayList<Tag>();
//        tags.add(tag);
//        article.setTags(tags);
//        articleService.addArticle(article);
////        System.out.println(articleMapper.deleteArticleById(7));
//        System.out.println(articleMapper.updateArticle(article));
//        Map tag = new HashMap();
//        tag.put("aid", 6);
//        tag.put("tid", 2);
//        System.out.println(articleMapper.deleteArticleTag(6, 3));
    }

    @Test
    void demo2(){
//        List<Tag> tags = tagMapper.getTagAll();
//        System.out.println(tags);
//        Tag tag = new Tag();
//        tag.setId(5);
//        tag.setName("tag7");
//        tag.setBgColor("#qazxsw");
//        System.out.println(tagMapper.updateTag(tag));
//        System.out.println(tagMapper.deleteTag(5));
        System.out.println(tagMapper.deleteTagLinkArticle(3));
    }

}
