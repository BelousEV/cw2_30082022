package sky.pro.cw2_30082022.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.cw2_30082022.exception.IncorrectAmountOfQuestionsException;
import sky.pro.cw2_30082022.model.Question;
import sky.pro.cw2_30082022.service.ExaminerService;
import sky.pro.cw2_30082022.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new  IncorrectAmountOfQuestionsException();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
