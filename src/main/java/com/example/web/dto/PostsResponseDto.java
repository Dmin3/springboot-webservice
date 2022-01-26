package com.example.web.dto;

import com.example.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    // 엔티티를 인자 값으로 받아 생성자 생성 -> 원하는 데이터만 가져올 수 있다.
    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }






}
