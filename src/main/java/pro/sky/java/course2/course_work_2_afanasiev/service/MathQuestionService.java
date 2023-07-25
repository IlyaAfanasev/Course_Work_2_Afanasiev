package pro.sky.java.course2.course_work_2_afanasiev.service;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.MethodNotExistException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import java.util.*;

@Service("mathQuestionService")
public class MathQuestionService implements QuestionService {


    public MathQuestionService() {

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
    public Set<Question> getRandomQuestion(int quantity) {
        Set<Question> returnQuestions = new HashSet<>();

        Random random = new Random();
        String[] mathFunctions = {"+", "-", "*", "/"};
        while (returnQuestions.size() < quantity) {
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
            Question question = new Question(questionParam, answer);

            returnQuestions.add(question);

        }

        return returnQuestions;
    }


}
