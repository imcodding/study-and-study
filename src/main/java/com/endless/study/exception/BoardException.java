package com.endless.study.exception;

import com.endless.study.code.BoardErrorCode;
import lombok.Getter;

@Getter
public class BoardException extends RuntimeException {

    private final BoardErrorCode boardErrorCode;
    private final String detailMessage;

    public BoardException(BoardErrorCode boardErrorCode) {
        super(boardErrorCode.getMessage());
        this.boardErrorCode = boardErrorCode;
        this.detailMessage = boardErrorCode.getMessage();
    }

    public BoardException(BoardErrorCode boardErrorCode, String detailMessage) {
        super(detailMessage);
        this.boardErrorCode = boardErrorCode;
        this.detailMessage = detailMessage;
    }
}
