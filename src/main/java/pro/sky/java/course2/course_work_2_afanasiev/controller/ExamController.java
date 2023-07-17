package pro.sky.java.course2.course_work_2_afanasiev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.service.ExaminerService;

import java.util.Collection;

@RestController

public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;

    }
    @GetMapping("/exam/get/{amount}")
    public Collection <Question> getRandomQuestions(@PathVariable("amount")  int amount){
        return examinerService.getQuestions(amount);
    }


}
