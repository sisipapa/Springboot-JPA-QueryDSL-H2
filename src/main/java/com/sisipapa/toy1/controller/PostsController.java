package com.sisipapa.toy1.controller;


import com.sisipapa.toy1.dto.PostsDTO;
import com.sisipapa.toy1.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("/v1")
@RestController
public class PostsController {

    private final PostsService service;

    @GetMapping("/post/{id}")
    public @ResponseBody Map<String, Object> getPost(@PathVariable Long id) {

        Map<String, Object> result = new HashMap<String, Object>();
        PostsDTO dto = service.getPost(id);
        result.put("result", dto);

        return result;
    }

}
