package com.example.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        Posts posts = Posts.builder().title(title).content(content).author("D_min3").build();
        postsRepository.save(posts);
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts findPost = postsList.get(0);
        assertThat(findPost.getTitle()).isEqualTo(title);
        assertThat(findPost.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());
        //when
        List<Posts> all = postsRepository.findAll();
        Posts posts = all.get(0);
        //then
        System.out.println(">>>>>>>>>>CreatedDate" + posts.getCreatedDate() + "modifedDate" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}