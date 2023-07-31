package pro.sky.java.course2.course_work_2_afanasiev.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.*;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.COLLECTION_QUESTIONS;


public class MathQuestionServiceTest {

    private Random random;

    private MathQuestionService out;

    @BeforeEach
    public void init() {
        random = mock(Random.class);
        out = new MathQuestionService(random);
    }

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
    public void shouldReturnCorrectResultFromMethodGetRandomQuestion() {
        when(random.nextInt(anyInt())).thenReturn(50)
        .thenReturn(35)
        .thenReturn(0);
        Question expected = new Question("50 + 35", "85.0");
        assertEquals(expected, out.getRandomQuestion());

    }


}
