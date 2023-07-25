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

    private Collection <QuestionService> questionServices;



    public ExaminerServiceImpl() {


        this.questionServices = new HashSet<>();

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        QuestionService javaQuestionService = new JavaQuestionService();
        List<Question> questions;

        int javaQuestionsSize = javaQuestionService.getAll().size();




        Random random = new Random();
        int num = random.nextInt(amount + 1);
        int quantityJavaQuestions = amount - num;
        int quantityMathQuestions = amount - quantityJavaQuestions;
        if (quantityJavaQuestions > javaQuestionsSize) {
            quantityMathQuestions = amount - javaQuestionsSize;

        }

        Iterable<Question> combinedIterables = Iterables.unmodifiableIterable(
                Iterables.concat(javaQuestionService.getRandomQuestion(quantityJavaQuestions),
                        mathQuestionService.getRandomQuestion(quantityMathQuestions)));

        return Lists.newArrayList(combinedIterables);
    }
}
