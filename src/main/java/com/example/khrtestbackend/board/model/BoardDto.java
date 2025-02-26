package com.example.khrtestbackend.board.model;

import com.example.khrtestbackend.comment.CommentDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {
    @Getter
    public static class Register {
        private String title;
        private String content;
        private String writer;

        public Board toEntity() {
            return new Board(null, title, content, writer, null);
        }
    }

    @Getter
    public static class Response {
        private Long idx;
        private String title;
        private String content;
        private String writer;
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
        private Long idx;
        private String title;
        private String content;
        private String writer;
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
