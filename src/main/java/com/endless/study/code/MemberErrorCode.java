package com.endless.study.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MemberErrorCode {

    NO_MEMBER("해당 사용자가 없습니다.");

    private final String message;
}
