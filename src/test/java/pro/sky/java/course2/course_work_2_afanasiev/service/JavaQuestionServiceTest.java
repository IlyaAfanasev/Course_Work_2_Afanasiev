package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import pro.sky.java.course2.course_work_2_afanasiev.exceptions.ParamIsNullException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionAlreadyExistException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.QuestionNotFoundException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import java.util.Random;

import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {


    private QuestionRepository questionRepositoryMock;

    private JavaQuestionService out;

    private Random random;

    @BeforeEach

    public void init() {
        questionRepositoryMock = mock(QuestionRepository.class);
        random = mock(Random.class);
        out = new JavaQuestionService(questionRepositoryMock, random);
    }


    @Test
    public void shouldReturnCorrectResultFromMethodAdd() {
        when(questionRepositoryMock.add(QUESTION_1_QUESTION, QUESTION_1_ANSWER)).thenReturn(QUESTION_1);
        assertEquals(QUESTION_1, out.add(QUESTION_1_QUESTION, QUESTION_1_ANSWER));

        verify(questionRepositoryMock, times(1))
                .add(QUESTION_1_QUESTION, QUESTION_1_ANSWER);
    }

    @Test
    public void shouldThrowParamIsNullExceptionFromMethodAdd() {
        when(questionRepositoryMock.add(isNull(), anyString())).thenThrow(ParamIsNullException.class);
        assertThrows(ParamIsNullException.class, () -> out.add(null, QUESTION_1_ANSWER));
        verify(questionRepositoryMock, times(1))
                .add(null, QUESTION_1_ANSWER);

    }

    @Test
    public void shouldThrowQuestionAlreadyExistFromMethodAddWhenElementIsExist() {

        when(questionRepositoryMock.add(anyString(), anyString())).thenThrow(QuestionAlreadyExistException.class);
        assertThrows(QuestionAlreadyExistException.class, () -> out.add(QUESTION_1_QUESTION, QUESTION_1_ANSWER));
        verify(questionRepositoryMock, times(1))
                .add(QUESTION_1_QUESTION, QUESTION_1_ANSWER);
    }

    @Test
    public void shouldReturnCorrectResultFromMethodAddWithoutParamAnswer() {
        when(questionRepositoryMock.add(QUESTION_1_QUESTION)).thenReturn(QUESTION_1);

        assertEquals(QUESTION_1, out.add(QUESTION_1_QUESTION));

        verify(questionRepositoryMock, times(1))
                .add(QUESTION_1_QUESTION);

    }

    @Test
    public void shouldThrowParamIsNullExceptionFromMethodAddWithoutParamAnswer() {
        when(questionRepositoryMock.add(isNull())).thenThrow(ParamIsNullException.class);
        assertThrows(ParamIsNullException.class, () -> out.add(null));
        verify(questionRepositoryMock, times(1))
                .add(null);
    }

    @Test
    public void shouldThrowQuestionAlreadyExistFromMethodAddWithoutParamAnswerWhenElementIsExist() {
        when(questionRepositoryMock.add(anyString())).thenThrow(QuestionAlreadyExistException.class);

        assertThrows(QuestionAlreadyExistException.class, () -> out.add(QUESTION_1_QUESTION));
        verify(questionRepositoryMock, times(1))
                .add(QUESTION_1_QUESTION);
    }

    @Test
    public void shouldReturnCorrectResultFromMethodRemove() {

        when(questionRepositoryMock.remove(QUESTION_1_QUESTION)).thenReturn(QUESTION_1);
        assertEquals(QUESTION_1, out.remove(QUESTION_1_QUESTION));
        verify(questionRepositoryMock, times(1))
                .remove(QUESTION_1_QUESTION);

    }

    @Test

    public void shouldTrowParamIsNullExceptionFromMethodRemove() {
        when(questionRepositoryMock.remove(isNull())).thenThrow(ParamIsNullException.class);
        assertThrows(ParamIsNullException.class, () -> out.remove(null));
        verify(questionRepositoryMock, times(1))
                .remove(null);
    }

    @Test

    public void shouldTrowQuestionNotFoundFromMethodRemove() {
        when(questionRepositoryMock.remove(QUESTION_1_QUESTION)).thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_1_QUESTION));
        verify(questionRepositoryMock, times(1))
                .remove(QUESTION_1_QUESTION);
    }

    @Test
    public void shouldReturnCorrectResultFromMethodGetAll() {
        when(questionRepositoryMock.getAll()).thenReturn(COLLECTION_QUESTIONS);
        assertEquals(COLLECTION_QUESTIONS, out.getAll());
        verify(questionRepositoryMock, times(1))
                .getAll();
    }

    @Test
    public void shouldReturnCorrectResultFromMethodGetRandomQuestion() {
        when(questionRepositoryMock.getAll()).thenReturn(COLLECTION_ALL_QUESTIONS);
        when(random.nextInt(anyInt())).thenReturn(1);


        assertEquals(QUESTION_2, out.getRandomQuestion());
        verify(questionRepositoryMock, times(1)).getAll();
    }
}
