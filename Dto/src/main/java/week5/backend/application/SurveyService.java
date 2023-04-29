package week5.backend.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week5.backend.application.dto.설문등록.RegisterSurveyResponseDto;
import week5.backend.application.dto.설문개별조회.SurveyDetailResponseDto;
import week5.backend.application.dto.설문등록.RegisterSurveyRequestDto;
import week5.backend.application.dto.설문리스트조회.SurveyListResponseDto;
import week5.backend.domain.Survey;
import week5.backend.domain.SurveyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;

    /**
     * 설문 등록 Service
     */
    @Transactional
    public RegisterSurveyResponseDto registerSurvey(RegisterSurveyRequestDto dto) {
        Survey newSurvey = dto.toEntity();
        surveyRepository.save(newSurvey);
        return new RegisterSurveyResponseDto(newSurvey.getId());
    }

    /**
     * 설문 목록 조회 Service
     */
    public SurveyListResponseDto getAllSurveys() {
        List<Survey> findAllSurveys = surveyRepository.findAll();
        return new SurveyListResponseDto(findAllSurveys);
    }

    /**
     * 특정 설문 보기 Service
     */
    public SurveyDetailResponseDto getSurvey(Long id) {
        Survey findSurvey = surveyRepository.findById(id).get();
        return new SurveyDetailResponseDto(findSurvey.getId(),findSurvey.getTitle(), findSurvey.getQuestions());
        // lazy 로딩이기 때문에 findSurvey.getQuestions()이 호출되는 순간 question 테이블에 접근하여 select 쿼리를 날림
    }
}
