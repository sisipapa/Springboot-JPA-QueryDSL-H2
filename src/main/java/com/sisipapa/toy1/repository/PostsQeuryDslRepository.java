package com.sisipapa.toy1.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sisipapa.toy1.domain.Posts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.sisipapa.toy1.domain.QPosts.posts;

@Repository
@AllArgsConstructor
public class PostsQeuryDslRepository {

    private final JPAQueryFactory queryFactory;

    public Posts findByAuthor(String author){
        return queryFactory.selectFrom(posts)
                .where(posts.author.eq(author))
                .fetchOne();
    }
}
