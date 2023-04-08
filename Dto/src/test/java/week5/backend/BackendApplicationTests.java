package week5.backend;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import week5.backend.domain.Question;
import week5.backend.domain.Survey;
import week5.backend.domain.SurveyRepository;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	SurveyRepository surveyRepository;

	@Test
	@Commit
	@Transactional
	void test() {

		//given
		Survey survey = new Survey(
				"survey",
				List.of(
						new Question("firstContent"),
						new Question("secondContent")
				)
		);
		//survey.addQuestion(new Question("firstTitle", "firstContent"));
		//survey.addQuestion(new Question("secondTitle", "secondContent"));
		surveyRepository.save(survey);

		//when
		Survey result = surveyRepository.findById(survey.getId()).get();

		//then
		Assertions.assertThat(result.getQuestions().size()).isEqualTo(2);
	}

}
