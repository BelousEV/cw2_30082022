package sky.pro.cw2_30082022.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.cw2_30082022.model.Question;
import sky.pro.cw2_30082022.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }



@GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
    return examinerService.getQuestions(amount);
}
}



