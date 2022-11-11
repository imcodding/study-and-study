package com.endless.study.dto;

import com.endless.study.code.BoardErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardErrorResponse {

    private BoardErrorCode boardErrorCode;
    private String message;
}
