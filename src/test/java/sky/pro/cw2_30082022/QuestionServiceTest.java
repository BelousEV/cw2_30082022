package sky.pro.cw2_30082022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.cw2_30082022.exception.QuestionAlreadyExistException;
import sky.pro.cw2_30082022.exception.QuestionNotFoundException;
import sky.pro.cw2_30082022.model.Question;
import sky.pro.cw2_30082022.service.QuestionService;
import sky.pro.cw2_30082022.service.impl.JavaQuestionService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class QuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach(){
        questionService.getAll().forEach(questionService::remove); //чистим список перед тестом
    }

    @Test
    public void addRemoveTest(){
        Question question = new Question("question", "answer");
        questionService.add(question);
        assertThat(questionService.getAll().contains(question)); //позитивный add? добавили вопрос и проверили

        assertThatExceptionOfType(QuestionAlreadyExistException.class)
                .isThrownBy(() -> questionService.add("question", "answer")); // негативный add

        questionService.remove(question);
        assertThat(questionService.getAll().isEmpty());  // позитивн.remove

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(question)); // негативный remove

    }

    @Test
    public void getRandomQuestionTest(){
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Question question3 = new Question("question3", "answer3");

        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);

        assertThat(questionService.getAll().contains(questionService.getRandomQuestion()));


    }



}
