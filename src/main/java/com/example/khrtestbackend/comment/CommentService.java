package com.example.khrtestbackend.comment;

import com.example.khrtestbackend.board.BoardRepository;
import com.example.khrtestbackend.board.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    // 특정 게시글을 조회할 때 댓글 목록 불러오기 위해 Board 정보 필요함
    private final BoardRepository boardRepository;

    public void register(CommentDto.Register dto) throws IllegalAccessException {
        Optional<Board> boardOptional = boardRepository.findById(dto.getBoardIdx());

        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            Comment comment = dto.toEntity(board);
            commentRepository.save(comment);
        } else {
            throw new IllegalAccessException("게시글이 존재하지 않습니다. CommentService register 실패");
        }
    }

}
