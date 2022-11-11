package com.endless.study.controller;

import com.endless.study.dto.BoardDto;
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
    public BoardDto addBoard(@RequestBody BoardDto boardDto) {
        return boardService.addBoard(boardDto);
    }

    @PutMapping("/board/{boardNo}")
    public BoardDto editBoard(@RequestBody BoardDto boardDto) {
        return boardService.editBoard(boardDto);
    }

    @PatchMapping("/board/{boardNo}")
    public BoardDto editBoardDetail(@PathVariable long boardNo, String content) {
        return boardService.editBoardDetail(boardNo, content);
    }

    @DeleteMapping("/board/{boardNo}")
    public void deleteBoard(@PathVariable long boardNo) {
        boardService.deleteBoard(boardNo);
    }
}


