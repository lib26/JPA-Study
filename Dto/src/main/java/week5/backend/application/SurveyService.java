package week5.backend.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week5.backend.application.dto.*;
import week5.backend.domain.Survey;
import week5.backend.domain.SurveyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Transactional
    public RegisterSurveyResponseDto registerSurvey(RegisterSurveyRequestDto dto) {
        Survey newSurvey = new Survey(dto.getTitle(), dto.getContent());
        surveyRepository.save(newSurvey);
        return new RegisterSurveyResponseDto(newSurvey.getId());
    }

    public SurveyListResponseDto getAllSurveys() {
        List<Survey> findAllSurveys = surveyRepository.findAll();
        SurveyListResponseDto response = new SurveyListResponseDto(findAllSurveys);
        return response;
    }

    public SurveyDetailResponseDto getSurvey(Long id) {
        Survey findSurvey = surveyRepository.findById(id).get();
        SurveyDetailResponseDto response = new SurveyDetailResponseDto(findSurvey.getId(),findSurvey.getTitle(), findSurvey.getQuestions());
        return response;
    }
}
