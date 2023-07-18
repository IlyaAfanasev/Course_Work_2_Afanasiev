package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;


    private List <Question> questions;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        this.questions = new ArrayList<>();
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        Random random = new Random();
        int num = random.nextInt(amount+1);
        int quantityJavaQuestions = amount-num;
        int quantityMathQuestions = amount - quantityJavaQuestions;
        questions=List.of((Question) javaQuestionService.getRandomQuestion(quantityJavaQuestions).stream().collect(Collectors.toList()),
                (Question) mathQuestionService.getRandomQuestion(quantityMathQuestions).stream().collect(Collectors.toList()));

        return questions;
    }
}
