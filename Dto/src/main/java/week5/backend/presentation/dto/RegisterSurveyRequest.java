package week5.backend.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.application.dto.설문등록.RegisterSurveyRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class RegisterSurveyRequest {

    private String title;
    private List<RegisterQuestionRequest> questions;

    public RegisterSurveyRequest(String title, List<RegisterQuestionRequest> questions) {
        this.title = title;
        this.questions = questions;
    }

    public RegisterSurveyRequestDto toServiceDto() {
        return new RegisterSurveyRequestDto(
                title,
                questions.stream()
                        .map(RegisterQuestionRequest::toServiceDto)
                        .collect(Collectors.toList()));
    }
    /**
     * RegisterQuestionRequest::toServiceDto
     * 메서드 참조 : 람다를 줄여서 쓴 것
     * 즉, question -> question.toServiceDto 랑 같은 의미
     */
}
