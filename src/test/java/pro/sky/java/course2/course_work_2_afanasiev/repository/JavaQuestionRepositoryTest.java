package pro.sky.java.course2.course_work_2_afanasiev.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExist;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;

public class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    public void shouldReturnCorrectResultFromMethodAdd() {
        assertEquals(JAVA_QUESTION_1, out.add(" что такое масСив ", JAVA_QUESTION_1_ANSWER));

    }

    @Test
    public void shouldThrowParamIsNullExceptionFromMethodAdd() {
        assertThrows(ParamIsNullException.class, ()->out.add(null, JAVA_QUESTION_1_ANSWER));
    }

    @Test
    public void shouldThrowQuestionAlreadyExistFromMethodAddWhenElementIsExist() {
        out.add(JAVA_QUESTION_1_QUESTION, JAVA_QUESTION_1_ANSWER);
        assertThrows(QuestionAlreadyExist.class, () -> out.add(JAVA_QUESTION_1_QUESTION, JAVA_QUESTION_1_ANSWER));
        assertThrows(QuestionAlreadyExist.class, () -> out.add(JAVA_QUESTION_1_QUESTION));
    }








}
