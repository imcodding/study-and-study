package com.endless.study.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardErrorCode {

    NO_BOARD("해당되는 게시글이 없습니다.");

    private final String message;
}
