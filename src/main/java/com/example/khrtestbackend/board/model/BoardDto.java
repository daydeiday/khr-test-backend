package com.example.khrtestbackend.board.model;

import com.example.khrtestbackend.comment.CommentDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {
    @Getter
    public static class Register {
        @Schema(description = "게시글 제목")
        private String title;
        @Schema(description = "게시글 내용")
        private String content;
        @Schema(description = "게시글 작성자")
        private String writer;

        public Board toEntity() {
            return new Board(null, title, content, writer, null);
        }
    }

    @Getter
    public static class Response {
        @Schema(description = "게시글 번호")
        private Long idx;
        @Schema(description = "게시글 제목")
        private String title;
        @Schema(description = "게시글 내용")
        private String content;
        @Schema(description = "게시글 작성자")
        private String writer;
        @Schema(description = "게시글의 댓글목록")
        private List<CommentDto.Response> commentList;

        public static Response from(Board board) {
            Response res = new Response();
            res.idx = board.getIdx();
            res.title = board.getTitle();
            res.content = board.getContent();
            res.writer = board.getWriter();
            res.commentList = board.getCommentList()
                    .stream()
                    .map(CommentDto.Response::from)
                    .collect(Collectors.toList());
            return res;
        }
    }

    @Getter
    public static class ListResponse {
        @Schema(description = "게시글 번호")
        private Long idx;
        @Schema(description = "게시글 제목")
        private String title;
        @Schema(description = "게시글 내용")
        private String content;
        @Schema(description = "게시글 작성자")
        private String writer;
        @Schema(description = "총 댓글 수")
        private int commentCount; // 각각의 board객체마다 달린 댓글의 수를 계산해서 보여줌
        public static ListResponse from(Board board) {
            ListResponse res = new ListResponse();
            res.idx = board.getIdx();
            res.title = board.getTitle();
            res.content = board.getContent();
            res.writer = board.getWriter();
            res.commentCount = board.getCommentList().size();
            return res;
        }
    }
}
