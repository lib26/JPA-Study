package week5.backend.application.dto.설문등록;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterSurveyResponseDto {

    private Long id;

    public RegisterSurveyResponseDto(Long id) {
        this.id = id;
    }
}
