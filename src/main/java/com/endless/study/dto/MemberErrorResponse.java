package com.endless.study.dto;

import com.endless.study.code.MemberErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberErrorResponse {

    private MemberErrorCode memberErrorCode;
    private String message;
}
