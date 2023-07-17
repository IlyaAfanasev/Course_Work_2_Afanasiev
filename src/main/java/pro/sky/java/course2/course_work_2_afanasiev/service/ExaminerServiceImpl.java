package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    private List <Question> questions;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.questions = new ArrayList<>();
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        questions=List.copyOf(questionService.getRandomQuestion(amount));

        return questions;
    }
}
