package com.endless.study.controller;

import com.endless.study.dto.MemberDto;
import com.endless.study.entity.Target;
import com.endless.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberDto addMember(@RequestBody MemberDto memberDto) {
        return memberService.saveMember(memberDto);
    }

    @GetMapping("/{memberNo}")
    public MemberDto getMemberById(@PathVariable Long memberNo) {
        return memberService.getMemberByNo(memberNo);
    }

    @PostMapping("{memberNo}/target")
    public Target addTarget(@PathVariable Long memberNo) {
        return memberService.addTarget(memberNo);
    }
}
