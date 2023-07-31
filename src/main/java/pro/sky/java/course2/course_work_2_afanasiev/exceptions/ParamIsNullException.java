package pro.sky.java.course2.course_work_2_afanasiev.exceptions;

public class ParamIsNullException extends RuntimeException {
    public ParamIsNullException() {
    }

    public ParamIsNullException(String message) {
        super(message);
    }

    public ParamIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamIsNullException(Throwable cause) {
        super(cause);
    }

    public ParamIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
