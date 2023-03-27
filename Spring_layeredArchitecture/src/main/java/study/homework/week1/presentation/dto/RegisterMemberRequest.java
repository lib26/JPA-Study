package study.homework.week1.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import study.homework.week1.application.dto.RegisterMemberRequestDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class RegisterMemberRequest {

    @NotEmpty
    private String nickName;

    @Min(20)
    private Integer age;

    public RegisterMemberRequest(String nickName, Integer age) {
        this.nickName = nickName;
        this.age = age;
    }

    public RegisterMemberRequestDto toServiceEntity(){
        return new RegisterMemberRequestDto(nickName, age);
    }
}
