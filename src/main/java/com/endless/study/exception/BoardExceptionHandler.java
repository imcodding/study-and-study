package com.endless.study.exception;

import com.endless.study.code.BoardErrorCode;
import com.endless.study.dto.BoardErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(BoardException.class)
    @ResponseBody
    public BoardErrorResponse handlerBoardException(BoardException e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getDetailMessage());
        return BoardErrorResponse.builder()
                .boardErrorCode(e.getBoardErrorCode())
                .message(e.getDetailMessage())
                .build();
    }

}
