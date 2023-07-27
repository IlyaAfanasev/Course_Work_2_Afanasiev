package pro.sky.java.course2.course_work_2_afanasiev.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


import com.sun.source.doctree.SeeTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import org.w3c.dom.stylesheets.LinkStyle;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {


    private ExaminerService out;

    @BeforeEach
    public void setUp() {
        QuestionService javaQuestionServiceMock = mock(JavaQuestionService.class);

        QuestionService mathQuestionServiceMock = mock(MathQuestionService.class);

        List<QuestionService> questionServicesList =
                new ArrayList<>(List.of(javaQuestionServiceMock, mathQuestionServiceMock));



        out = new ExaminerServiceImpl(questionServicesList);

        when(javaQuestionServiceMock.getAll()).thenReturn(COLLECTION_QUESTIONS);


    }







}
