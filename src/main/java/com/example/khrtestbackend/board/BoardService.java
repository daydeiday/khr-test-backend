package com.example.khrtestbackend.board;

import com.example.khrtestbackend.board.model.Board;
import com.example.khrtestbackend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.Register dto) {
        boardRepository.save(dto.toEntity());
    }

    public List<BoardDto.ListResponse> list() {
        List<Board> boardList = boardRepository.findAll();

        return boardList.stream()
                .map(BoardDto.ListResponse::from)
                .collect(Collectors.toList());
    }

    public BoardDto.Response read(Long idx) {
        Optional<Board> result = boardRepository.findById(idx);

        if(result.isPresent()) {
            Board board = result.get();

            return BoardDto.Response.from(board);
        }

        return null;
    }

//    public BoardDto.Response searchByName(String name) {
//        Board board = boardRepository.findByName(name).orElseThrow();
//
//        return BoardDto.Response.from(board);
//    }
}
