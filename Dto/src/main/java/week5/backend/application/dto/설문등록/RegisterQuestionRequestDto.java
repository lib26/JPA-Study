package week5.backend.application.dto.설문등록;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.domain.Question;

@Getter
@NoArgsConstructor
public class RegisterQuestionRequestDto {

    private String question;

    public RegisterQuestionRequestDto(String question) {
        this.question = question;
    }

    public Question toEntity(){
        return new Question(question);
    }
}
