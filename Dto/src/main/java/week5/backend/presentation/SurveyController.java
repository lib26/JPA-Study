package week5.backend.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import week5.backend.application.SurveyService;
import week5.backend.application.dto.RegisterSurveyResponseDto;
import week5.backend.application.dto.SurveyDetailResponseDto;
import week5.backend.application.dto.SurveyListResponseDto;
import week5.backend.application.dto.SurveyResponseDto;
import week5.backend.presentation.dto.RegisterSurveyRequest;

@RestController
@RequiredArgsConstructor
public class SurveyController {

    public final SurveyService surveyService;

    @PostMapping("/surveys/survey-write")
    public RegisterSurveyResponseDto registerSurvey(@RequestBody RegisterSurveyRequest request){
        RegisterSurveyResponseDto response = surveyService.registerSurvey(request.toServiceEntity());
        return response;
    }

    @GetMapping("/surveys/getAll")
    public SurveyListResponseDto surveyList(){
        SurveyListResponseDto response = surveyService.getAllSurveys();
        return response;
    }

    @GetMapping("/surveys/{surveyId}")
    public SurveyDetailResponseDto surveyDetail(@PathVariable Long surveyId){
        SurveyDetailResponseDto response = surveyService.getSurvey(surveyId);
        return response;
    }
}
