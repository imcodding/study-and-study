package com.endless.study.exception;


import com.endless.study.code.MemberErrorCode;
import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {

    private final MemberErrorCode memberErrorCode;
    private final String detailMessage;

    public MemberException(MemberErrorCode memberErrorCode, String detailMessage) {
        super(detailMessage);
        this.memberErrorCode = memberErrorCode;
        this.detailMessage = detailMessage;
    }

    public MemberException(MemberErrorCode memberErrorCode) {
        super(memberErrorCode.getMessage());
        this.memberErrorCode = memberErrorCode;
        this.detailMessage = memberErrorCode.getMessage();
    }
}
