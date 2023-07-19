package pro.sky.java.course2.course_work_2_afanasiev.constant;

import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionRepositoryConstant {

    public static final Question JAVA_QUESTION_1 = new Question("Что такое массив"
            , "Массив это хранилище упорядоченных элементов");

    public static final String JAVA_QUESTION_1_QUESTION = "Что такое массив";
    public static final String JAVA_QUESTION_1_ANSWER = "Массив это хранилище упорядоченных элементов";

    public static final Question JAVA_QUESTION_2 = new Question("Какие бывают условные операторы",
            "If, Switch");

    public static final String JAVA_QUESTION_2_QUESTION = "Какие бывают условные операторы";
    public static final String JAVA_QUESTION_2_ANSWER = "If, Switch";


    public static final Collection<Question> COLLECTION_JAVA_QUESTIONS = new ArrayList<>(List.of(JAVA_QUESTION_1, JAVA_QUESTION_2));



}
