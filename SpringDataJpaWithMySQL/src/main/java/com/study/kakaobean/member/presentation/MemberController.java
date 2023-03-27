package com.study.kakaobean.member.presentation;

import com.study.kakaobean.member.application.MemberService;
import com.study.kakaobean.member.application.dto.RegisterMemberResponseDto;
import com.study.kakaobean.member.presentation.dto.RegisterMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ResponseBody
    @PostMapping("/members")
    public RegisterMemberResponseDto registerMember(@RequestBody @Validated RegisterMemberRequest request){
        RegisterMemberResponseDto response = memberService.registerMember(request.toServiceEntity());
        return response;
    }
}
