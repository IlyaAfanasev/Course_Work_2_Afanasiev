package pro.sky.java.course2.course_work_2_afanasiev.service;

import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(String question);

    Question remove(String question);

    Collection<Question> getAll();

    List<Question> getRandomQuestion(int quantity);


}
