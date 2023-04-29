package week5.backend.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week5.backend.application.SurveyService;
import week5.backend.application.dto.설문등록.RegisterSurveyResponseDto;
import week5.backend.application.dto.설문개별조회.SurveyDetailResponseDto;
import week5.backend.application.dto.설문리스트조회.SurveyListResponseDto;
import week5.backend.presentation.dto.RegisterSurveyRequest;

@RestController
@RequestMapping("/surveys")
@RequiredArgsConstructor
public class SurveyController {

    public final SurveyService surveyService;

    /**
     * 설문 등록 Controller
     */
    @PostMapping("/survey-write")
    public ResponseEntity registerSurvey(@RequestBody RegisterSurveyRequest request){
        RegisterSurveyResponseDto response = surveyService.registerSurvey(request.toServiceDto());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * 설문 목록 조회 Controller
     */
    @GetMapping("/getAll")
    public ResponseEntity surveyList(){
        SurveyListResponseDto response = surveyService.getAllSurveys();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * 특정 설문 보기 Controller
     */
    @GetMapping("/{surveyId}")
    public ResponseEntity surveyDetail(@PathVariable Long surveyId){
        SurveyDetailResponseDto response = surveyService.getSurvey(surveyId);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
