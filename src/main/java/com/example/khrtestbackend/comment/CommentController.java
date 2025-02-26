package com.example.khrtestbackend.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CommentDto.Register dto) throws IllegalAccessException {
        commentService.register(dto);
        return ResponseEntity.ok("성공");
    }

}
