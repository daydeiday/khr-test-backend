package com.example.khrtestbackend.board.model;

import com.example.khrtestbackend.comment.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String content;
    private String writer;

    @OneToMany(mappedBy = "board")
    private List<Comment> commentList;
}
