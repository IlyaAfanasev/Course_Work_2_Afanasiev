package pro.sky.java.course2.course_work_2_afanasiev.constant;

import pro.sky.java.course2.course_work_2_afanasiev.model.Question;

public class QuestionRepositoryConstant {

    public static final Question JAVA_QUESTION_1 = new Question("Что такое массив"
            , "Массив это хранилище упорядоченных элементов");

    public static final String JAVA_QUESTION_1_QUESTION = "Что такое массив";
    public static final String JAVA_QUESTION_1_ANSWER = "Массив это хранилище упорядоченных элементов";

    public static final Question JAVA_QUESTION_2 = new Question("Какие бывают условные операторы",
            "If, Switch");
    public static final Question JAVA_QUESTION_3 = new Question("Где хранятся переменные",
            "Примитивы хранятся в стеке, ссылки на ссылочные переменные так же хранятся в стеке, " +
                    "сами ссылочные  переменные хранятся в куче");
    public static final Question JAVA_QUESTION_4 = new Question(null);

}
