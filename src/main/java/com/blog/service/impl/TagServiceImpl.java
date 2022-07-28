package com.blog.service.impl;

import com.blog.entity.Tag;
import com.blog.mapper.TagMapper;
import com.blog.service.TagService;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;


    @Override
    public ResponseResult getTagAll() {
        return new ResponseResult(200, "标签获取成功", tagMapper.getTagAll());
    }

    @Override
    public ResponseResult addTag(Tag tag) {
        tagMapper.addTag(tag);
        return new ResponseResult(200, "添加标签成功");
    }

    @Override
    public ResponseResult deleteTag(int tid) {
        tagMapper.deleteTag(tid);
        tagMapper.deleteTagLinkArticle(tid);
        return new ResponseResult(200, "删除标签成功");
    }

    @Override
    public ResponseResult updateTag(Tag tag) {
        tagMapper.updateTag(tag);
        return new ResponseResult(200, "更新标签成功");
    }
}
