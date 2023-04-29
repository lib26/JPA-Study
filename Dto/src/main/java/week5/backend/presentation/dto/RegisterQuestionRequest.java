package week5.backend.presentation.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.application.dto.설문등록.RegisterQuestionRequestDto;

@Getter
@NoArgsConstructor
public class RegisterQuestionRequest {

    private String question;

    public RegisterQuestionRequest(String question) {
        this.question = question;
    }

    public RegisterQuestionRequestDto toServiceDto(){
        return new RegisterQuestionRequestDto(question);
    }
}
