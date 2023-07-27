package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import java.util.*;

@Service("javaQuestionService")
public class JavaQuestionService implements QuestionService {


    private final QuestionRepository questionRepository;


    public JavaQuestionService( QuestionRepository questionRepository) {

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
    public Question getRandomQuestion() {
        List <Question> questionsCopy = List.of(questionRepository.getAll().toArray(new Question[0]));

        Random random = new Random();

        int i = random.nextInt(questionsCopy.size());

        return questionsCopy.get(i);
    }

}




