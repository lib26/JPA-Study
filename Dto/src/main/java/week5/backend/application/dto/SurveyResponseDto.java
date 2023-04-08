package week5.backend.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.domain.Question;
import week5.backend.domain.Survey;

import java.util.List;

@Getter
@NoArgsConstructor
public class SurveyResponseDto {

    private Long id;
    private String title;

    public SurveyResponseDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
