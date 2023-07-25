package pro.sky.java.course2.course_work_2_afanasiev.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.*;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.COLLECTION_QUESTIONS;


public class MathQuestionServiceTest {

    private final MathQuestionService out = new MathQuestionService();

    @Test
    public void shouldTrowMethodNotExistExceptionFromMethodAdd() {
        assertThrows(MethodNotExistException.class, () -> out.add(QUESTION_1_QUESTION, QUESTION_1_ANSWER));
    }
    @Test
    public void shouldTrowMethodNotExistExceptionFromMethodAddWithoutParamAnswer() {
        assertThrows(MethodNotExistException.class, () -> out.add(QUESTION_1_QUESTION));
    }
    @Test
    public void shouldTrowMethodNotExistExceptionFromMethodRemove() {
        assertThrows(MethodNotExistException.class, () -> out.remove(QUESTION_1_QUESTION));
    }
    @Test
    public void shouldTrowMethodNotExistExceptionFromMethodGetAll() {
        assertThrows(MethodNotExistException.class, () -> out.getAll());
    }
    @Test
    public void shouldReturnCorrectResultFromMethodGerRandomQuestion() {
        assertEquals(2, out.getRandomQuestion(2).size());
    }










}
