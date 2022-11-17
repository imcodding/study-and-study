package com.endless.study.exception;

import com.endless.study.code.MemberErrorCode;
import com.endless.study.dto.BoardErrorResponse;
import com.endless.study.dto.MemberErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.endless.study.code.BoardErrorCode.INTERNAL_SERVER_ERROR;
import static com.endless.study.code.BoardErrorCode.INVALID_REQUEST;
import static com.endless.study.code.MemberErrorCode.NO_MEMBER;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BoardException.class)
    @ResponseBody
    public BoardErrorResponse handleBoardException(BoardException e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getDetailMessage());
        return BoardErrorResponse.builder()
                .boardErrorCode(e.getBoardErrorCode())
                .message(e.getDetailMessage())
                .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BoardErrorResponse handleNoSuchMethodException(Exception e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());
        return BoardErrorResponse.builder()
                .boardErrorCode(INVALID_REQUEST)
                .message(INVALID_REQUEST.getMessage())
                .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public BoardErrorResponse handleException(Exception e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());
        return BoardErrorResponse.builder()
                .boardErrorCode(INTERNAL_SERVER_ERROR)
                .message(INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MemberException.class)
    @ResponseBody
    public MemberErrorResponse handleMemberException(Exception e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());
        return MemberErrorResponse.builder()
                .memberErrorCode(NO_MEMBER)
                .message(NO_MEMBER.getMessage())
                .build();
    }
}
