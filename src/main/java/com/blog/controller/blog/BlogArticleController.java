package com.blog.controller.blog;

import com.blog.service.impl.ArticleServiceImpl;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/blog/article")
public class BlogArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping("/demo")
    public String demo(){
        return "请求成功";
    }

    @GetMapping("/getall")
    public ResponseResult getArticleAll(){
        return articleService.getArticleAll();
    }

    @GetMapping("/getpage")
    public ResponseResult getArticlePage(@RequestParam("page")int page, @RequestParam("number")int number){
        return articleService.getArticlePage(page, number);
    }

    @PostMapping("/find")
    public ResponseResult findArticleById(@RequestParam("id")int id){
        return articleService.findArticleById(id);
    }

    @PostMapping("/getbytag")
    public ResponseResult getArticlePageByTagId(@RequestBody Map<String, Integer> map){
        return articleService.getArticlePageByTagId(map.get("tid"), map.get("page"), map.get("number"));
    }
}
