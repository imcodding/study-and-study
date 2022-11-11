package com.endless.study.controller;

import com.endless.study.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BoardDto {
    private long boardNo;
    private String title;
    private String content;
    private String writer;
    private int views;

    public static BoardDto fromEntity(Board board) {
        return BoardDto.builder()
                .boardNo(board.getBoardNo())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .views(board.getViews())
                .build();
    }
}
