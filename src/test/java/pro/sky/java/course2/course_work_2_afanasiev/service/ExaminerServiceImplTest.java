package pro.sky.java.course2.course_work_2_afanasiev.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;

import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {


    private ExaminerService out;

    @BeforeEach
    public void setUp() {
        QuestionService javaQuestionServiceMock = mock(JavaQuestionService.class);

        QuestionService mathQuestionServiceMock = mock(MathQuestionService.class);

        out = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);

        when(javaQuestionServiceMock.getAll()).thenReturn(COLLECTION_QUESTIONS);

        when(mathQuestionServiceMock.getAll()).thenReturn(COLLECTION_QUESTIONS_2);
    }


    @Test
    public void shouldCorrectResultFromMethodGetQuestion() {


        assertEquals(COLLECTION_ALL_QUESTIONS, out.getQuestions(4));


    }

    @Test
    public void shouldThrowRequestMoreContentExceptionsFromMethodGetQuestion() {
        assertThrows(RequestMoreContentExceptions.class, () -> out.getQuestions(5));
    }


}
