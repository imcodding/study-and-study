package com.endless.study.service;

import com.endless.study.entity.Board;
import com.endless.study.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public Board addBoard(Board board) {
        boardRepository.save(board);
        return board;
    }

    public Board editBoard(Board board) {
        Board findBoard = boardRepository.findById(board.getBoardNo()).orElseThrow();
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());

        boardRepository.save(findBoard);

        return findBoard;
    }

    public Board editBoardDetail(Long boardNo, String content) {
        Board findBoard = boardRepository.findById(boardNo).orElseThrow();
        findBoard.setContent(content);

        boardRepository.save(findBoard);

        return findBoard;
    }

    public void deleteBoard(Long boardNo) {
        boardRepository.deleteById(boardNo);
    }
}
