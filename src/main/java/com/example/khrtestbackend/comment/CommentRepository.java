package com.example.khrtestbackend.comment;

import com.example.khrtestbackend.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정 게시글을 조회할 때 댓글 목록 불러오기
    List<Comment> findByBoard(Board board);
}
