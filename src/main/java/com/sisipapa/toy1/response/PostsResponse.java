package com.sisipapa.toy1.response;

import com.sisipapa.toy1.dto.PostsDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Post Response")
public class PostsResponse extends CommonResponse<PostsDTO> {

	public PostsResponse(PostsDTO data) {
		super(data);
	}
	
}
