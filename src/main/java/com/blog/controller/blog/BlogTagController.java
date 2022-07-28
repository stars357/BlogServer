package com.blog.controller.blog;

import com.blog.service.impl.TagServiceImpl;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/blog/tag")
public class BlogTagController {

    @Autowired
    private TagServiceImpl tagService;

    @GetMapping("/getall")
    public ResponseResult getTagAll(){
        return tagService.getTagAll();
    }

//    @PostMapping("/getart")
//    public ResponseResult getArticleByTagId(@RequestBody Map<String, Integer> map){
//
//        return null;
//    }
}
