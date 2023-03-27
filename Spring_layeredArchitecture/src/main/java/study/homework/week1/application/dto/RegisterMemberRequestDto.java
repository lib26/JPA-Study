package study.homework.week1.application.dto;

import lombok.Getter;
import study.homework.week1.domain.Member;

@Getter
public class RegisterMemberRequestDto {

    private String nickName;
    private Integer age;

    public RegisterMemberRequestDto(String nickName, Integer age) {
        this.nickName = nickName;
        this.age = age;
    }

    public Member toEntity(){
        return new Member(nickName, age);
    }
}
