package sky.pro.cw2_30082022.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.cw2_30082022.exception.QuestionAlreadyExistException;
import sky.pro.cw2_30082022.exception.QuestionNotFoundException;
import sky.pro.cw2_30082022.model.Question;
import sky.pro.cw2_30082022.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.random = new Random();
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }


    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
