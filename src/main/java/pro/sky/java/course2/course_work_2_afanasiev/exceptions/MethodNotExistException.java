package pro.sky.java.course2.course_work_2_afanasiev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotExistException extends RuntimeException {
    public MethodNotExistException() {
    }

    public MethodNotExistException(String message) {
        super(message);
    }

    public MethodNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodNotExistException(Throwable cause) {
        super(cause);
    }

    public MethodNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
