package com.example.khrtestbackend.board;

import com.example.khrtestbackend.board.model.Board;
import com.example.khrtestbackend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.Response> read(@PathVariable Long idx) {
        // 댓글목록도 같이 가져와야 함
        BoardDto.Response response = boardService.read(idx);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.ListResponse>> list() {
        // 각각의 board객체마다 달린 댓글의 수를 계산해서 보여줌
        List<BoardDto.ListResponse> boardResList = boardService.list();

        return ResponseEntity.ok(boardResList);
    }

    @GetMapping("/search")
    public ResponseEntity<BoardDto.Response> search(String name) {
        BoardDto.Response response = boardService.searchByName(name);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BoardDto.Register dto ) {
        boardService.register(dto);
        return ResponseEntity.ok("성공");
    }


}
