package pro.sky.java.course2.course_work_2_afanasiev.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExistException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionNotFoundException;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {

        this.questions = new HashSet<>();
    }
    @Override
    public Question add(String question, String answer) {
        checkParam(question);
        question = reformatParam(question);
        equalsQuestion(question);
        checkParam(answer);
        answer = reformatParam(answer);
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(String question) {
        checkParam(question);
        question = reformatParam(question);
        equalsQuestion(question);
        Question q = new Question(question);
        questions.add(q);
        return q;
    }

    @Override
    public Question remove(String question) {
        checkParam(question);
        question = reformatParam(question);
        Question q = new Question(question);
        if (questions.remove(q)) {
            return new Question(question);
        }

        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {

        return questions;
    }


    private void checkParam(String param) {
        if (param == null) {
            throw new ParamIsNullException();
        }
    }

    private String reformatParam(String param) {
       return capitalize(lowerCase(strip(param)));

    }

    private void equalsQuestion(String question) {
        Question q = new Question(question);
        for (Question o: getAll()) {
            if(o.equals(q))
                throw new QuestionAlreadyExistException();

        }

    }
}
