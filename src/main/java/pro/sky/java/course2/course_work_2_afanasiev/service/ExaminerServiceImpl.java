package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;
    private final Random random;


    @Autowired
    public ExaminerServiceImpl(List<QuestionService> questionServices) {


        this.questionServices = questionServices;

        this.random = new Random();
    }

    public ExaminerServiceImpl(List<QuestionService> questionServices, Random random) {

        this.questionServices = questionServices;

        this.random = random;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> randomQuestions = new HashSet<>();

        while (randomQuestions.size() < amount) {

            int questionServiceId = random.nextInt(questionServices.size());

            QuestionService questionService = questionServices.get(questionServiceId);

            randomQuestions.add(questionService.getRandomQuestion());

        }

        return randomQuestions;
    }
}
