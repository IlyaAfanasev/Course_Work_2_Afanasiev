package pro.sky.java.course2.course_work_2_afanasiev.service;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;


    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questions;

        int javaQuestionsSize = javaQuestionService.getAll().size();
        int mathQuestionsSize = mathQuestionService.getAll().size();
        if (amount > javaQuestionsSize + mathQuestionsSize) {
            throw new RequestMoreContentExceptions();
        }
        if (amount == javaQuestionsSize + mathQuestionsSize) {
            Iterable<Question> combinedIterables = Iterables.unmodifiableIterable(
                    Iterables.concat(javaQuestionService.getAll(), mathQuestionService.getAll()));

            return Lists.newArrayList(combinedIterables);
        }

        Random random = new Random();
        int num = random.nextInt(amount + 1);
        int quantityJavaQuestions = amount - num;
        int quantityMathQuestions = amount - quantityJavaQuestions;
        if (quantityJavaQuestions > javaQuestionsSize || quantityMathQuestions > mathQuestionsSize) {
            return getQuestions(amount);
        }
        Iterable<Question> combinedIterables = Iterables.unmodifiableIterable(
                Iterables.concat(javaQuestionService.getRandomQuestion(quantityJavaQuestions),
                        mathQuestionService.getRandomQuestion(quantityMathQuestions)));

        return Lists.newArrayList(combinedIterables);
    }
}
