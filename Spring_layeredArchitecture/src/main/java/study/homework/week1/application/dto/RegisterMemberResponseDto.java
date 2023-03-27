package study.homework.week1.application.dto;

import lombok.Getter;

@Getter
public class RegisterMemberResponseDto {

    private String id;

    public RegisterMemberResponseDto(String id) {
        this.id = id;
    }
}
