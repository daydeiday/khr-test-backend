package com.example.khrtestbackend.comment;

import com.example.khrtestbackend.board.model.Board;
import lombok.Getter;

public class CommentDto {
    @Getter
    public static class Register {
        private String content;
        private String writer;
        private Long boardIdx;
        public Comment toEntity(Board board) {
            return new Comment(null, content, writer, board);
        }
    }

    @Getter
    public static class Response {
        // BoardDto에서 응답을 보내줄 때 함께 보여줘야 하므로,
        // Response 이너클래스를 작성해준다.
        private Long idx;
        private String content;
        private String writer;

        // 엔티티를 DTO 객체로 변환하는 메서드 작성
        public static Response from(Comment comment) {
            Response response = new Response();
            response.idx = comment.getIdx();
            response.content = comment.getContent();
            response.writer = comment.getWriter();
            return response;
        }
    }
}
