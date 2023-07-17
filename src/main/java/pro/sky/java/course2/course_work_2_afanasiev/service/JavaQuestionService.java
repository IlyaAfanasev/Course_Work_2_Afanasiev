package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExist;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionNotFound;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;
@Repository
public class JavaQuestionService implements QuestionService {

    private final Map<String, Question> questions;

    public JavaQuestionService() {

        this.questions = new HashMap<>();
    }
    @Override
    public Question add(String question, String answer) {
        checkParam(question);
        reformatParam(question);
        equalsQuestion(question);
        checkParam(answer);
        reformatParam(answer);
        Question q = new Question(question, answer);
        questions.put(question,q);
        return q;
    }

    @Override
    public Question add(String question) {
        checkParam(question);
        equalsQuestion(question);
        reformatParam(question);
        Question q = new Question(question);
        questions.put(question, q);
        return q;
    }

    @Override
    public Question remove(String question) {
        checkParam(question);
        reformatParam(question);
        if (!questions.containsKey(question)) {
            throw new QuestionNotFound();
        }

        return questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {

        return new ArrayList<>(questions.values());
    }

    @Override
    public Set <Question> getRandomQuestion(int quantity) {
        if (quantity > questions.size()) {
            throw new RequestMoreContentExceptions();
        }
        Question [] questionsCopy = getAll().toArray(new Question[0]);
        Random random = new Random();
        Set <Question> returnQuestions = new HashSet<>();
        while (returnQuestions.size()< quantity) {
            int i = random.nextInt(questionsCopy.length);
            returnQuestions.add(questionsCopy[i]);
        }

        return returnQuestions;
    }

    private void checkParam(String param) {
        if (param == null) {
            throw new ParamIsNullException();
        }
    }

    private void reformatParam(String param) {
        StringUtils.strip(param);
        StringUtils.lowerCase(param);
        StringUtils.capitalize(param);

    }

    private void equalsQuestion(String question) {
        Question q = new Question(question);
        for (Question o: questions.values()) {
            if(o.equals(q))
                throw new QuestionAlreadyExist();

        }

        }
}




