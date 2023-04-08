package week5.backend.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.domain.Survey;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SurveyListResponseDto {

    List<SurveyResponseDto> surveyList;

    public SurveyListResponseDto(List<Survey> allSurvey) {
        this.surveyList = allSurvey.stream()
                .map(survey -> new SurveyResponseDto(survey.getId(), survey.getTitle()))
                .collect(Collectors.toList());
    }
}
