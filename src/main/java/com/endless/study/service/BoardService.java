package com.endless.study.service;

import com.endless.study.code.BoardErrorCode;
import com.endless.study.dto.BoardDto;
import com.endless.study.entity.Board;
import com.endless.study.exception.BoardException;
import com.endless.study.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.endless.study.code.BoardErrorCode.*;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public BoardDto addBoard(BoardDto boardDto) {
        Board board = Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .writer(boardDto.getWriter())
                .build();
        boardRepository.save(board);
        return BoardDto.fromEntity(board);
    }

    public BoardDto editBoard(BoardDto boardDto) {
        Board findBoard = boardRepository.findById(boardDto.getBoardNo())
                .orElseThrow(() -> new BoardException(NO_BOARD));

        findBoard.setTitle(boardDto.getTitle());
        findBoard.setContent(boardDto.getContent());

        boardRepository.save(findBoard);

        return BoardDto.fromEntity(findBoard);
    }

    public BoardDto editBoardDetail(Long boardNo, String content) {
        Board findBoard = boardRepository.findById(boardNo).orElseThrow();

        findBoard.setContent(content);

        boardRepository.save(findBoard);

        return BoardDto.fromEntity(findBoard);
    }

    public void deleteBoard(Long boardNo) {
        boardRepository.deleteById(boardNo);
    }
}
