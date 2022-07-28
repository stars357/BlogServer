package com.blog.entity;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String title;

    @Setter
    @Getter
    private String text;

    @Setter
    @Getter
    private List<Tag> tags;

}
