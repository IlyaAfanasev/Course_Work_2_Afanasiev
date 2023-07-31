package pro.sky.java.course2.course_work_2_afanasiev.repository;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExistException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;

public class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    public void shouldReturnCorrectResultFromMethodAdd() {
        assertEquals(QUESTION_1, out.add(" что такое масСив ",
                "массив это хранилище Упорядоченных элементов"));

    }

    @Test
    public void shouldThrowParamIsNullExceptionFromMethodAdd() {
        assertThrows(ParamIsNullException.class, () -> out.add(null, QUESTION_1_ANSWER));
    }

    @Test
    public void shouldThrowQuestionAlreadyExistFromMethodAddWhenElementIsExist() {
        out.add(QUESTION_1_QUESTION, QUESTION_1_ANSWER);
        assertThrows(QuestionAlreadyExistException.class, () -> out.add(" что такое масСив ", QUESTION_1_ANSWER));
        assertThrows(QuestionAlreadyExistException.class, () -> out.add(" что такое масСив "));
    }


    @Test
    public void shouldReturnCorrectResultFromMethodAddWithoutParamAnswer() {
        assertEquals(QUESTION_1, out.add(" что такое масСив "));

    }

    @Test
    public void shouldThrowParamIsNullExceptionFromMethodAddWithoutParamAnswer() {
        assertThrows(ParamIsNullException.class, () -> out.add(null));
    }

    @Test
    public void shouldThrowQuestionAlreadyExistFromMethodAddWithoutParamAnswerWhenElementIsExist() {
        out.add(QUESTION_1_QUESTION);
        assertThrows(QuestionAlreadyExistException.class, () -> out.add(" что такое масСив "));
        assertThrows(QuestionAlreadyExistException.class, () -> out.add(" что такое масСив ", QUESTION_1_ANSWER));
    }

    @Test
    public void shouldReturnCorrectResultFromMethodRemove() {
        out.add(QUESTION_1_QUESTION, QUESTION_1_ANSWER);
        out.add(QUESTION_2_QUESTION);
        assertEquals(QUESTION_1, out.remove(" что такое масСив "));
        assertEquals(QUESTION_2, out.remove(" какие бывают условные операторы "));

    }

    @Test

    public void shouldTrowQuestionNotFoundFromMethodRemove() {
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_2_QUESTION));
    }

    @Test

    public void shouldTrowParamIsNullExceptionFromMethodRemove() {
        assertThrows(ParamIsNullException.class, () -> out.remove(null));
    }

    @Test

    public void shouldReturnCorrectResultFromMethodGetAll() {
        out.add(QUESTION_1_QUESTION, QUESTION_1_ANSWER);
        out.add(QUESTION_2_QUESTION, QUESTION_2_ANSWER);
        assertEquals(COLLECTION_QUESTIONS, out.getAll());
    }


}
