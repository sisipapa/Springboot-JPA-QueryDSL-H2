package com.sisipapa.toy1.controller;


import com.sisipapa.toy1.dto.PostsDTO;
import com.sisipapa.toy1.response.BasicResponse;
import com.sisipapa.toy1.response.ErrorResponse;
import com.sisipapa.toy1.response.PostsResponse;
import com.sisipapa.toy1.service.PostsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/v1")
@RestController
public class PostsController {

    private final PostsService service;

    /**
     * 등록(Create)4
     * @param dto
     * @return
     */
    @PostMapping("/post")
    @Operation(summary = "Post등록",
            description = "Post 레코드를 등록한다.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "post 등록 성공", content = @Content(schema = @Schema(implementation = PostsDTO.class))),
                    @ApiResponse(responseCode = "500", description = "서버오류", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<? extends BasicResponse> insertPost(@RequestBody PostsDTO dto) {

        PostsDTO rDto = service.savePost(dto);
        if(rDto == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("등록 실패", "500"));
        }

        return ResponseEntity.noContent().build();
    }

    /**
     * 조회(Read)
     * @param id
     * @return
     */
    @GetMapping("/post/{id}")
    @Operation(summary = "Post조회",
                description = "id를 이용하여 post 레코드를 조회한다.",
                responses = {
                    @ApiResponse(responseCode = "200", description = "post 조회 성공", content = @Content(schema = @Schema(implementation = PostsDTO.class))),
                    @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
                })
    public ResponseEntity<? extends BasicResponse> getPost(@Parameter(name = "id", description = "post 의 id", in = ParameterIn.PATH) @PathVariable Long id) {

        PostsDTO dto = service.getPost(id);
        if(dto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("일치하는 정보가 없습니다. id를 확인해주세요."));
        }
        return ResponseEntity.ok().body(new PostsResponse(dto));
    }

    /**
     * 수정(Update)
     * @param dto
     * @return
     */
    @PatchMapping("/post/{id}")
    @Operation(summary = "Post수정",
            description = "id의 post 레코드를 수정한다.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "컨텐츠 없음", content = @Content(schema = @Schema(implementation = PostsDTO.class))),
                    @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<? extends BasicResponse> patchPost(@Parameter(name = "id", description = "post 의 id", in = ParameterIn.PATH) @PathVariable Long id,
                                                        @RequestBody PostsDTO dto) {
        dto.setId(id);
        PostsDTO rDto = service.savePost(dto);
        if(rDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("일치하는 정보가 없습니다. id를 확인해주세요."));
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * 삭제(Delete)
     * @param id
     * @return
     */
    @DeleteMapping("/post/{id}")
    @Operation(summary = "Post삭제",
            description = "id의 post 레코드를 삭제한다.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "컨텐츠 없음", content = @Content(schema = @Schema(implementation = PostsDTO.class))),
                    @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<? extends BasicResponse> deletePost(@Parameter(name = "id", description = "post 의 id", in = ParameterIn.PATH) @PathVariable Long id) {

        if(!service.deletePost(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("일치하는 정보가 없습니다. id를 확인해주세요."));
        }
        return ResponseEntity.noContent().build();
    }

}
