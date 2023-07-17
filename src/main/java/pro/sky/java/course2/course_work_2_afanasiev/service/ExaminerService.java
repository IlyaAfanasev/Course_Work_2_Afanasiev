package pro.sky.java.course2.course_work_2_afanasiev.service;

import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
