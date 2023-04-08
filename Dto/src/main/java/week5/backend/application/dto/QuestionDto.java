package week5.backend.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionDto {

    private String question;

    public QuestionDto(String question) {
        this.question = question;
    }
}
