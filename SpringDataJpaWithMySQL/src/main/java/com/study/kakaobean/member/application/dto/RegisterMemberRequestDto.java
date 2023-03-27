package com.study.kakaobean.member.application.dto;

import com.study.kakaobean.member.domain.Member;
import lombok.Getter;

@Getter
public class RegisterMemberRequestDto {

    private String username;
    private String password;

    public RegisterMemberRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
