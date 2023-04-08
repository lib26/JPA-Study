package week5.backend.application.dto;

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
