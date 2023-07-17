package pro.sky.java.course2.course_work_2_afanasiev.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;



public class Question {

    private final String question;

    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(String question) {
        this.question = question;

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










