package pro.sky.java.course2.course_work_2_afanasiev.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExist;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionNotFound;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Repository("javaQuestionRepository")
public class JavaQuestionRepository implements QuestionRepository {
    private final Map<String, Question> questions;

    public JavaQuestionRepository() {

        this.questions = new HashMap<>();
    }
    @Override
    public Question add(String question, String answer) {
        checkParam(question);
        question = reformatParam(question);
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


    private void checkParam(String param) {
        if (param == null) {
            throw new ParamIsNullException();
        }
    }

    private String reformatParam(String param) {
        strip(param);
        lowerCase(param);
        capitalize(param);

        return param;
    }

    private void equalsQuestion(String question) {
        Question q = new Question(question);
        for (Question o: questions.values()) {
            if(o.equals(q))
                throw new QuestionAlreadyExist();

        }

    }
}
