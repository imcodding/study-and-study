package com.endless.study.service;

import com.endless.study.code.MemberErrorCode;
import com.endless.study.dto.MemberDto;
import com.endless.study.dto.TargetDto;
import com.endless.study.entity.Member;
import com.endless.study.entity.Target;
import com.endless.study.exception.MemberException;
import com.endless.study.repository.MemberRepository;
import com.endless.study.repository.TargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TargetRepository targetRepository;

    public MemberDto saveMember(MemberDto memberDto) {
        Member member = Member.builder()
                .memberId(memberDto.getMemberId())
                .name(memberDto.getName())
                .dept(memberDto.getDept())
                .build();

        memberRepository.save(member);

        return MemberDto.fromEntity(member);
    }

    public MemberDto getMemberByNo(Long memberNo) {
        Member member = memberRepository.findById(memberNo).orElseThrow(
                () -> new MemberException(MemberErrorCode.NO_MEMBER)
        );

        List<TargetDto> targetList = targetRepository.findTargetByMemberMemberNo(memberNo)
                        .stream()
                        .map(TargetDto::fromEntity)
                        .collect(Collectors.toList());
        MemberDto memberDto = MemberDto.fromEntity(member);
        memberDto.setTargetList(targetList);

        return memberDto;
    }

    public Target addTarget(Long memberNo) {

        Member member = memberRepository.findById(memberNo).orElseThrow(
                ()-> new MemberException(MemberErrorCode.NO_MEMBER));

        Target target = Target.builder()
                .member(member)
                .build();

        member.addTarget(target);

        Target target2 = Target.builder()
                .member(member)
                .build();

        member.addTarget(target2);

        memberRepository.save(member);
        return target;
    }
}
