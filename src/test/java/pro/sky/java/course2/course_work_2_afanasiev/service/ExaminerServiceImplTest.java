package pro.sky.java.course2.course_work_2_afanasiev.service;

import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private QuestionService javaQuestionServiceMock;
    private QuestionService mathQuestionServiceMock;
    private ExaminerService out;
    private Random random;

    @BeforeEach
    public void setUp() {
        javaQuestionServiceMock = mock(JavaQuestionService.class);

        mathQuestionServiceMock = mock(MathQuestionService.class);

        List<QuestionService> questionServicesList =
                new ArrayList<>(List.of(javaQuestionServiceMock, mathQuestionServiceMock));

        random = mock(Random.class);

        out = new ExaminerServiceImpl(questionServicesList, random);


    }

    @Test
    public void shouldReturnCorrectResultFromMethodGetQuestions() {
        when(random.nextInt(anyInt()))
                .thenReturn(0)
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(1);

        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(QUESTION_2)
                .thenReturn(QUESTION_2)
                .thenReturn(QUESTION_1);

        when(mathQuestionServiceMock.getRandomQuestion())
                .thenReturn(QUESTION_4)
                .thenReturn(QUESTION_3);

        Assertions.assertEquals(4, out.getQuestions(4).size());

        verify(javaQuestionServiceMock, times(3)).getRandomQuestion();
        verify(mathQuestionServiceMock, times(2)).getRandomQuestion();



    }









}
