package com.endless.study.controller;

import com.endless.study.entity.Board;
import com.endless.study.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public List<Board> getBoardList() {
        return boardService.getBoardList();
    }

    @PostMapping("/board")
    public Board addBoard() {
        Board board = Board.builder()
                .title("안녕하세요.")
                .content("반갑습니다.")
                .writer("testUser")
                .build();
        return boardService.addBoard(board);
    }

    @PutMapping("/board")
    public Board editBoard() {
        Board board = Board.builder()
                .boardNo(1L)
                .title("안녕하세요2.")
                .content("반갑습니다2.")
                .writer("testUser")
                .build();

        return boardService.editBoard(board);
    }

    @PatchMapping("/board")
    public Board editBoardDetail() {
        return boardService.editBoardDetail(1L, "반갑습니다3");
    }

    @DeleteMapping("/board")
    public void deleteBoard() {
        boardService.deleteBoard(1L);
    }
}


