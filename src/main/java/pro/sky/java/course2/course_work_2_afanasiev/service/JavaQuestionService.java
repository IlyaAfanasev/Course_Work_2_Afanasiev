package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import java.util.*;

@Service("javaQuestionService")
public class JavaQuestionService implements QuestionService {


    private final QuestionRepository questionRepository;

    private final Random random;


    @Autowired
    public JavaQuestionService( QuestionRepository questionRepository) {

        this.questionRepository = questionRepository;
        this.random = new Random();

    }
    public JavaQuestionService( QuestionRepository questionRepository, Random random ) {

        this.questionRepository = questionRepository;
        this.random = random;

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
        List <Question> questionsCopy = new ArrayList<>(questionRepository.getAll());

        int i = random.nextInt(questionsCopy.size());

        return questionsCopy.get(i);
    }

}




