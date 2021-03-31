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
    public void cleanup() { // 데이터 섞임 방지
        postsRepository.deleteAll();
    }
    @Test
    public void test1() {
        // given
        String title = "Test title";
        String content = "Test content";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("kim")
                .build());
        // when
        List<Posts> postsList = postsRepository.findAll();
        // then
        Posts posts = postsList.get(0);
    }
}