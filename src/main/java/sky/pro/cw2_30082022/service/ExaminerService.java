package sky.pro.cw2_30082022.service;

import sky.pro.cw2_30082022.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
