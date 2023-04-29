package week5.backend.application.dto.설문리스트조회;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week5.backend.domain.Survey;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SurveyListResponseDto {

    List<SurveyResponseDto> surveyList;

    public SurveyListResponseDto(List<Survey> Surveys) {
        this.surveyList = Surveys.stream()
                .map(survey -> new SurveyResponseDto(survey.getId(), survey.getTitle()))
                .collect(Collectors.toList());
    }
}
