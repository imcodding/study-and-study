package com.endless.study.dto;

import com.endless.study.entity.Member;
import com.endless.study.entity.Target;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
public class MemberDto {

    private Long memberNo;
    private String memberId;
    private String name;
    private String dept;
    private List<TargetDto> targetList;

    public static MemberDto fromEntity(Member member) {
        return MemberDto.builder()
                .memberNo(member.getMemberNo())
                .memberId(member.getMemberId())
                .name(member.getName())
                .dept(member.getDept())
                .build();
    }
}
