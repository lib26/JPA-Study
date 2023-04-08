package week5.backend.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.domain.Question;

import java.util.List;

@Getter
@NoArgsConstructor
public class RegisterSurveyRequestDto {

    private String title;
    private List<Question> content;

    public RegisterSurveyRequestDto(String title, List<Question> content) {
        this.title = title;
        this.content = content;
    }
}
