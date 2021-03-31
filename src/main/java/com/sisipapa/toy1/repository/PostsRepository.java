package com.sisipapa.toy1.repository;

import com.sisipapa.toy1.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
