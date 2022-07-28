package com.blog.controller.admin;

import com.blog.entity.Tag;
import com.blog.service.impl.TagServiceImpl;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/tag")
public class AdminTagController {

    @Autowired
    private TagServiceImpl tagService;

    @PostMapping("/add")
    public ResponseResult AddTag(@RequestBody Tag tag){
        return tagService.addTag(tag);
    }

    @PostMapping("update")
    public ResponseResult updateTag(@RequestBody Tag tag){
        return tagService.updateTag(tag);
    }

    @PostMapping("/delete")
    public ResponseResult deleteTag(@RequestBody Map<String, Integer> map){
//        System.out.println(map.get("tid"));
        return tagService.deleteTag(map.get("tid"));
    }
}
