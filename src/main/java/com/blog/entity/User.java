package com.blog.entity;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
public class User {

    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String pwd;

}
