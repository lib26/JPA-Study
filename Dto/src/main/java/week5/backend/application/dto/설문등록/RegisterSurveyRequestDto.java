package week5.backend.application.dto.설문등록;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.domain.Survey;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class RegisterSurveyRequestDto {

    private String title;
    private List<RegisterQuestionRequestDto> questions;

    public RegisterSurveyRequestDto(String title, List<RegisterQuestionRequestDto> questions) {
        this.title = title;
        this.questions = questions;
    }

    public Survey toEntity() {
        return new Survey(
                title,
                questions.stream()
                        .map(question -> question.toEntity())
                        .collect(Collectors.toList()));
    }
}
