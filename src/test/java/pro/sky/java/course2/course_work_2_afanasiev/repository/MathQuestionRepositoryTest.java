package pro.sky.java.course2.course_work_2_afanasiev.repository;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExist;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionNotFound;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.COLLECTION_JAVA_QUESTIONS;

public class MathQuestionRepositoryTest {

    private final MathQuestionRepository out = new MathQuestionRepository();

    @Test
    public void shouldReturnCorrectResultFromMethodAdd() {
        assertEquals(JAVA_QUESTION_1, out.add(" что такое масСив ",
                "массив это хранилище Упорядоченных элементов"));

    }

    @Test
    public void shouldThrowParamIsNullExceptionFromMethodAdd() {
        assertThrows(ParamIsNullException.class, ()->out.add(null, JAVA_QUESTION_1_ANSWER));
    }

    @Test
    public void shouldThrowQuestionAlreadyExistFromMethodAddWhenElementIsExist() {
        out.add(JAVA_QUESTION_1_QUESTION, JAVA_QUESTION_1_ANSWER);
        assertThrows(QuestionAlreadyExist.class, () -> out.add(" что такое масСив ", JAVA_QUESTION_1_ANSWER));
        assertThrows(QuestionAlreadyExist.class, () -> out.add(" что такое масСив "));
    }



    @Test
    public void shouldReturnCorrectResultFromMethodAddWithoutParamAnswer() {
        assertEquals(JAVA_QUESTION_1, out.add(" что такое масСив "));

    }

    @Test
    public void shouldThrowParamIsNullExceptionFromMethodAddWithoutParamAnswer() {
        assertThrows(ParamIsNullException.class, ()->out.add(null));
    }

    @Test
    public void shouldThrowQuestionAlreadyExistFromMethodAddWithoutParamAnswerWhenElementIsExist() {
        out.add(JAVA_QUESTION_1_QUESTION);
        assertThrows(QuestionAlreadyExist.class, () -> out.add(" что такое масСив "));
        assertThrows(QuestionAlreadyExist.class, () -> out.add(" что такое масСив ", JAVA_QUESTION_1_ANSWER));
    }

    @Test
    public void shouldReturnCorrectResultFromMethodRemove() {
        out.add(JAVA_QUESTION_1_QUESTION, JAVA_QUESTION_1_ANSWER);
        out.add(JAVA_QUESTION_2_QUESTION);
        assertEquals(JAVA_QUESTION_1, out.remove(" что такое масСив "));
        assertEquals(JAVA_QUESTION_2, out.remove(" какие бывают условные операторы "));

    }

    @Test

    public void shouldTrowQuestionNotFoundFromMethodRemove() {
        assertThrows(QuestionNotFound.class, ()-> out.remove(JAVA_QUESTION_2_QUESTION));
    }

    @Test

    public void shouldTrowParamIsNullExceptionFromMethodRemove() {
        assertThrows(ParamIsNullException.class, ()-> out.remove(null));
    }

    @Test

    public void shouldReturnCorrectResultFromMethodGetAll() {
        out.add(JAVA_QUESTION_1_QUESTION, JAVA_QUESTION_1_ANSWER);
        out.add(JAVA_QUESTION_2_QUESTION, JAVA_QUESTION_2_ANSWER);
        assertEquals(COLLECTION_JAVA_QUESTIONS, out.getAll());
    }
}


