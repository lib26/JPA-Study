package com.study.kakaobean.member.presentation.dto;

import com.study.kakaobean.member.application.dto.RegisterMemberRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class RegisterMemberRequest {

    private String username;
    private String password;

    public RegisterMemberRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RegisterMemberRequestDto toServiceEntity(){
        return new RegisterMemberRequestDto(username, password);
    }
}
