package com.sisipapa.toy1.repository;

import com.sisipapa.toy1.domain.Posts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }
    @Test
    public void test1() {
        String title = "TITLE1";
        String content = "CONTENT1";
        String author = "AUTHOR1";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);
    }
}