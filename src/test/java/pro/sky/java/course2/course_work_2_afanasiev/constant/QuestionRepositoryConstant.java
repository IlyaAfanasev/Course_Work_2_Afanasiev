package pro.sky.java.course2.course_work_2_afanasiev.constant;

import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

import java.util.*;

public class QuestionRepositoryConstant {

    public static final Question QUESTION_1 = new Question("Что такое массив"
            , "Массив это хранилище упорядоченных элементов");

    public static final String QUESTION_1_QUESTION = "Что такое массив";
    public static final String QUESTION_1_ANSWER = "Массив это хранилище упорядоченных элементов";

    public static final Question QUESTION_2 = new Question("Какие бывают условные операторы",
            "If, Switch");

    public static final String QUESTION_2_QUESTION = "Какие бывают условные операторы";
    public static final String QUESTION_2_ANSWER = "If, Switch";


    public static final String QUESTION_3_QUESTION = "Зависимая переменная величина?";
    public static final String QUESTION_3_ANSWER = "Функция";

    public static final Question QUESTION_3 = new Question(QUESTION_3_QUESTION, QUESTION_3_ANSWER);
    public static final String QUESTION_4_QUESTION = "Вторая степень числа?";
    public static final String QUESTION_4_ANSWER = "Квадрат";
    public static final Question QUESTION_4 = new Question(QUESTION_4_QUESTION, QUESTION_4_ANSWER);




    public static final Collection<Question> COLLECTION_QUESTIONS
            = new ArrayList<>(List.of(QUESTION_1, QUESTION_2));

    public static final Collection<Question> COLLECTION_QUESTIONS_2
            = new ArrayList<>(List.of(QUESTION_3, QUESTION_4));
    public static final Collection<Question> COLLECTION_ALL_QUESTIONS
            = new ArrayList<>(List.of(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4));



    public static final Set<Question> RANDOM_QUESTIONS
            = new HashSet<>(COLLECTION_QUESTIONS);

}
