package com.example.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        Assertions.assertThat(findPost.getTitle()).isEqualTo(title);
        Assertions.assertThat(findPost.getContent()).isEqualTo(content);
    }

}