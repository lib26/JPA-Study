package week5.backend.application.dto.설문개별조회;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionDetailResponseDto {

    private String question;

    public QuestionDetailResponseDto(String question) {
        this.question = question;
    }
}
