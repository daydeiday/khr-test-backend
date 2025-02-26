package com.example.khrtestbackend.comment;

import com.example.khrtestbackend.board.model.Board;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter @NoArgsConstructor @AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String content;
    private String writer;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx")
    private Board board;
}
