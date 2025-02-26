package com.example.khrtestbackend.comment;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "Create Comment", description = "댓글 목록 모두 불러오기")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CommentDto.Register dto) throws IllegalAccessException {
        commentService.register(dto);
        return ResponseEntity.ok("성공");
    }

}
