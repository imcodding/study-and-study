package com.endless.study.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardErrorCode {

    NO_BOARD("해당되는 게시글이 없습니다."),

    INVALID_REQUEST("잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR("서버 내부 오류가 발생했습니다.")

    ;

    private final String message;
}
