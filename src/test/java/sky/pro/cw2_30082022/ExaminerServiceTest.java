package sky.pro.cw2_30082022;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.cw2_30082022.exception.IncorrectAmountOfQuestionsException;
import sky.pro.cw2_30082022.model.Question;
import sky.pro.cw2_30082022.service.impl.ExaminerServiceImpl;
import sky.pro.cw2_30082022.service.impl.JavaQuestionService;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static java.util.Set.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock

    private JavaQuestionService javaQuestionService;

    @InjectMocks

    private ExaminerServiceImpl examinerService;

    @Test
    public void getQuestionNegativeTest() {
        when(javaQuestionService.getAll()).thenReturn(Collections.emptyList());

      assertThatExceptionOfType(IncorrectAmountOfQuestionsException.class)
            .isThrownBy(() -> examinerService.getQuestions(1));

        assertThatExceptionOfType(IncorrectAmountOfQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));



    }


    @Test
    public void getQuestionPositiveTest() {
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Question question3 = new Question("question3", "answer3");
        Question question4 = new Question("question4", "answer4");
        Question question5 = new Question("question5", "answer5");


        Set<Question> allQuestions = Set.of(question1, question2, question3, question4, question5);


        when(javaQuestionService.getAll()).thenReturn(allQuestions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(question5, question4, question1);
        assertThat(examinerService.getQuestions(3)).containsExactlyInAnyOrder(question5, question4, question1);

        when(javaQuestionService.getRandomQuestion()).thenReturn(question5, question4, question1, question5, question2, question4, question3);
        assertThat(examinerService.getQuestions(5)).containsExactlyInAnyOrder(question5, question4, question1, question2, question3);
    }


}
