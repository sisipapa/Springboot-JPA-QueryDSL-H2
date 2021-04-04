package com.sisipapa.toy1.service;

import com.sisipapa.toy1.domain.Posts;
import com.sisipapa.toy1.dto.PostsDTO;
import com.sisipapa.toy1.repository.PostsQeuryDslRepository;
import com.sisipapa.toy1.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostsService {

    private final PostsRepository repository;
    private final PostsQeuryDslRepository qeuryDslRepository;

    public PostsDTO getPost(Long id){
        PostsDTO dto = qeuryDslRepository.findById(id);
        return dto;
    }

}
