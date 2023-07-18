package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import java.util.*;

@Service("javaQuestionService")
public class JavaQuestionService implements QuestionService {


    private final QuestionRepository questionRepository;


    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {

        this.questionRepository = questionRepository;

    }
    @Override
    public Question add(String question, String answer) {
        return questionRepository.add(question, answer);
    }

    @Override
    public Question add(String question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(String question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {

        return questionRepository.getAll();
    }

    @Override
    public Set <Question> getRandomQuestion(int quantity) {
        List <Question> questionsCopy = List.of(questionRepository.getAll().toArray(new Question[0]));

        if (quantity > questionsCopy.size()) {
            throw new RequestMoreContentExceptions();
        }
        if (quantity == questionsCopy.size()) {
            return  new HashSet<>(questionsCopy);
        }

        Random random = new Random();
        Set <Question> returnQuestions = new HashSet<>();
        while (returnQuestions.size()< quantity) {
            int i = random.nextInt(questionsCopy.size());
            returnQuestions.add(questionsCopy.get(i));
        }

        return returnQuestions;
    }

}




