package week5.backend.application.dto.설문개별조회;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SurveyDetailResponseDto {

    private Long id;
    private String title;
    private List<QuestionDetailResponseDto> questionList;

    public SurveyDetailResponseDto(Long id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questionList = questions.stream()
                .map(question -> new QuestionDetailResponseDto(question.getQuestion()))
                .collect(Collectors.toList());
    }
}
