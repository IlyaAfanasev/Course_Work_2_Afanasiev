package pro.sky.java.course2.course_work_2_afanasiev.repository;

import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);

    Question add(String question);

    Question remove(String question);

    Collection<Question> getAll();

}
