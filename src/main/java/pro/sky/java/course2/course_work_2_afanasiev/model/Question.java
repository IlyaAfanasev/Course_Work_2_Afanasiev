package pro.sky.java.course2.course_work_2_afanasiev.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Question {

    private final String question;

    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(String question) {
        this.question = question;
        this.answer=null;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||getClass() != o.getClass()) return false;
        Question q = (Question) o;

        return StringUtils.containsIgnoreCase(question, q.getQuestion());
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
