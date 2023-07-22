package pro.sky.java.course2.course_work_2_afanasiev.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.MethodNotExistException;
import pro.sky.java.course2.course_work_2_afanasiev.exceptions.RequestMoreContentExceptions;
import pro.sky.java.course2.course_work_2_afanasiev.model.Question;
import pro.sky.java.course2.course_work_2_afanasiev.repository.QuestionRepository;

import java.util.*;
@Service("mathQuestionService")
public class MathQuestionService implements QuestionService {





        public MathQuestionService() {

        }
        @Override
        public Question add(String question, String answer) {
            throw new MethodNotExistException();
        }

        @Override
        public Question add(String question) {
            throw new MethodNotExistException();
        }

        @Override
        public Question remove(String question) {
            throw new MethodNotExistException();
        }

        @Override
        public Collection<Question> getAll() {

            throw new MethodNotExistException();
        }

        @Override
        public Set <Question> getRandomQuestion(int quantity) {
            List <Question> questionsCopy = List.of(questionRepository.getAll().toArray(new Question[0]));

            if (quantity > questionsCopy.size()) {
                throw new RequestMoreContentExceptions();
            }
            if (quantity == questionsCopy.size()) {
                return  new HashSet<>(questionsCopy);
            }

            Random random = new Random();
            Set <Question> returnQuestions = new HashSet<>();
            while (returnQuestions.size()< quantity) {
                int i = random.nextInt(questionsCopy.size());
                returnQuestions.add(questionsCopy.get(i));
            }

            return returnQuestions;
        }



}
