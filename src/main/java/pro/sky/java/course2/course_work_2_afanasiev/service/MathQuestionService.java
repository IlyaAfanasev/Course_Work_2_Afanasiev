package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.MethodNotExistException;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;

@Service("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final Random random;

    @Autowired
    public MathQuestionService() {
        this.random = new Random();

    }
    public MathQuestionService(Random random) {
        this.random = random;

    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotExistException();
    }

    @Override
    public Question add(String question) {
        throw new MethodNotExistException();
    }

    @Override
    public Question remove(String question) {
        throw new MethodNotExistException();
    }

    @Override
    public Collection<Question> getAll() {

        throw new MethodNotExistException();
    }

    @Override
    public Question getRandomQuestion() {


        String[] mathFunctions = {"+", "-", "*", "/"};

        int a = random.nextInt(100_000);
        int b = random.nextInt(100_000);
        int i = random.nextInt(mathFunctions.length);

        String mathFunction = mathFunctions[i];


        double answerDouble = 0;
        switch (mathFunction) {

            case "+":
                answerDouble = a + b;
                break;

            case "-":
                answerDouble = a - b;
                break;

            case "*":
                answerDouble = a * b;
                break;

            case "/":
                answerDouble = a / b;
                break;
        }

        String[] q = {String.valueOf(a), mathFunction, String.valueOf(b)};
        String questionParam = String.join(" ", q);
        String answer = String.valueOf(answerDouble);


        return new Question(questionParam, answer);
    }


}
