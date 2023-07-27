package pro.sky.java.course2.course_work_2_afanasiev.service;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List <QuestionService> questionServices;



    public ExaminerServiceImpl(List <QuestionService> questionServices) {


        this.questionServices = questionServices;

    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> randomQuestions = new HashSet<>();

        Random random = new Random();

        while (randomQuestions.size() < amount) {

            int questionServiceId = random.nextInt(questionServices.size());

            QuestionService questionService = questionServices.get(questionServiceId);

            randomQuestions.add(questionService.getRandomQuestion());

        }

        return randomQuestions;
    }
}
