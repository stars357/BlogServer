package com.blog.service;

import com.blog.entity.Tag;
import com.blog.utils.ResponseResult;

import java.util.List;

public interface TagService {

    ResponseResult getTagAll();

    ResponseResult addTag(Tag tag);

    ResponseResult deleteTag(int tid);

    ResponseResult updateTag(Tag tag);

}
