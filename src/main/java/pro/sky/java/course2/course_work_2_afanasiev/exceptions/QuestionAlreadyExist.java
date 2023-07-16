package pro.sky.java.course2.course_work_2_afanasiev.exceptions;

public class QuestionAlreadyExist extends RuntimeException {
    public QuestionAlreadyExist() {
    }

    public QuestionAlreadyExist(String message) {
        super(message);
    }

    public QuestionAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyExist(Throwable cause) {
        super(cause);
    }

    public QuestionAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
