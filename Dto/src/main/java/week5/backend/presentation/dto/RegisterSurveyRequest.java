package week5.backend.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.application.dto.RegisterSurveyRequestDto;
import week5.backend.domain.Question;

import java.util.List;

@Getter
@NoArgsConstructor
public class RegisterSurveyRequest {

    private String title;
    private List<Question> content;

    public RegisterSurveyRequest(String title, List<Question> content) {
        this.title = title;
        this.content = content;
    }

    public RegisterSurveyRequestDto toServiceDto() {
        return new RegisterSurveyRequestDto(title, content);
    }
}
