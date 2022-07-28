package com.blog.mapper;

import com.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {

    List<Tag> getTagAll();

    Boolean addTag(Tag tag);

    Boolean deleteTag(@Param("tid")int id);

    Boolean updateTag(Tag tag);

    Boolean deleteTagLinkArticle(@Param("tid")int id);

}
