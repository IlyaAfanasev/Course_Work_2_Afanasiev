package pro.sky.java.course2.course_work_2_afanasiev.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant;
import pro.sky.java.course2.course_work_2_afanasiev.repository.JavaQuestionRepository;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.course_work_2_afanasiev.constant.QuestionRepositoryConstant.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock

    private JavaQuestionRepository javaQuestionRepositoryMock;

    @InjectMocks

    private JavaQuestionService out;

    @BeforeEach
    public void setUp() {
        Mockito.when(javaQuestionRepositoryMock.add((JAVA_QUESTION_1_QUESTION).(JAVA_QUESTION_1);
    }


}
