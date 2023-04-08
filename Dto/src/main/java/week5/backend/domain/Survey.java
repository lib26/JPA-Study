package week5.backend.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//test
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Survey {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 설문 이름
     */
    private String title;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "questions", joinColumns = @JoinColumn(name = "survey_id"))
    private List<Question> questions = new ArrayList<>();

    public Survey(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public Survey(String title) {
        this.title = title;
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }
}
