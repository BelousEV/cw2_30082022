package sky.pro.cw2_30082022.service;

import sky.pro.cw2_30082022.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
