package com.endless.study.dto;

import com.endless.study.entity.Target;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TargetDto {

    private Long targetNo;
    private MemberDto member;

    public static TargetDto fromEntity(Target target) {
        return TargetDto.builder()
                .targetNo(target.getTargetNo())
                .member(MemberDto.fromEntity(target.getMember()))
                .build();

    }
}
