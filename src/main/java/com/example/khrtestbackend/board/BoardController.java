package com.example.khrtestbackend.board;

import com.example.khrtestbackend.board.model.Board;
import com.example.khrtestbackend.board.model.BoardDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "Retrieve Board", description = "게시글 1개의 데이터 불러오기")
    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.Response> read(@PathVariable Long idx) {
        // 댓글목록도 같이 가져와야 함
        BoardDto.Response response = boardService.read(idx);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "List Board", description = "게시글 전체목록 데이터 불러오기")
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.ListResponse>> list() {
        // 각각의 board객체마다 달린 댓글의 수를 계산해서 보여줌
        List<BoardDto.ListResponse> boardResList = boardService.list();

        return ResponseEntity.ok(boardResList);
    }

//    @GetMapping("/search")
//    public ResponseEntity<BoardDto.Response> search(String name) {
//        BoardDto.Response response = boardService.searchByName(name);
//
//        return ResponseEntity.ok(response);
//    }

    @Operation(summary = "Create Board", description = "게시글 작성하기")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BoardDto.Register dto ) {
        boardService.register(dto);
        return ResponseEntity.ok("성공");
    }


}
