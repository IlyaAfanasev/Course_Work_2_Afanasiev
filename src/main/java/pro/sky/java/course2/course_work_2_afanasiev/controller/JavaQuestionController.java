package pro.sky.java.course2.course_work_2_afanasiev.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;

    }

    @GetMapping(value = "/add", params = {"answer"})
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer ) {
        return  questionService.add(question, answer);
    }

    @GetMapping( "/add")
    public Question add(@RequestParam("question") String question) {
        return questionService.add(question);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }






}
