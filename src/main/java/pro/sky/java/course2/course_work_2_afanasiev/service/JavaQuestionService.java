package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.apache.commons.lang3.StringUtils;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExist;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionNotFound;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;

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
    public List<Question> getRandomQuestion(int quantity) {
        Question [] questions1 = getAll().toArray(new Question[0]);
        Random random = new Random();
        List <Question> returnQuestions = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            int j = random.nextInt(questions1.length);
            returnQuestions.add(questions1[j]);
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

