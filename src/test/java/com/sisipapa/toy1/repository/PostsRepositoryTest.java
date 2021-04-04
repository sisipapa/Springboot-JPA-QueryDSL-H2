package com.sisipapa.toy1.repository;

import com.sisipapa.toy1.domain.Posts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostsQeuryDslRepository postsQueryDslRepository;

//    @AfterEach
//    public void cleanup() {
//        postsRepository.deleteAll();
//    }

    @Test
    public void save() {
        String title = "TITLE1";
        String content = "CONTENT1";
        String author = "AUTHOR1";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
    }

    @Test
    public void findByAuthor() {
        Posts posts = postsQueryDslRepository.findByAuthor("AUTHOR1");
        Assert.notNull(posts, "posts is not null");
        Assertions.assertEquals(posts.getTitle(),"TITLE1");
    }

}