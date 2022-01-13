package com.sisipapa.toy1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Posts 결과 DTO2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsDTO {
    private Long id;
    private String title;
    private String author;
    private String content;
}
