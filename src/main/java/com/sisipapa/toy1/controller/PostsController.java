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

    /**
     * 등록(Create)
     * @param dto
     * @return
     */
    @PostMapping("/post")
    public @ResponseBody Map<String, Object> insertPost(@RequestBody PostsDTO dto) {

        Map<String, Object> result = new HashMap<String, Object>();
        PostsDTO rDto = service.savePost(dto);
        result.put("result", rDto);

        return result;
    }

    /**
     * 조회(Read)
     * @param id
     * @return
     */
    @GetMapping("/post/{id}")
    public @ResponseBody Map<String, Object> getPost(@PathVariable Long id) {

        Map<String, Object> result = new HashMap<String, Object>();
        PostsDTO dto = service.getPost(id);
        result.put("result", dto);

        return result;
    }

    /**
     * 수정(Update)
     * @param dto
     * @return
     */
    @PutMapping("/post/{id}")
    public @ResponseBody Map<String, Object> updatePost(@PathVariable Long id,
                                                        @RequestBody PostsDTO dto) {

        dto.setId(id);
        Map<String, Object> result = new HashMap<String, Object>();
        PostsDTO rDto = service.savePost(dto);
        result.put("result", rDto);

        return result;
    }

    /**
     * 삭제(Delete)
     * @param id
     * @return
     */
    @DeleteMapping("/post/{id}")
    public @ResponseBody Map<String, Object> deletePost(@PathVariable Long id) {

        Map<String, Object> result = new HashMap<String, Object>();
        service.deletePost(id);
        result.put("result", "delete success");

        return result;
    }

}
