package pro.sky.java.course2.course_work_2_afanasiev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestMoreContentExceptions extends RuntimeException {
    public RequestMoreContentExceptions() {
    }

    public RequestMoreContentExceptions(String message) {
        super(message);
    }

    public RequestMoreContentExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestMoreContentExceptions(Throwable cause) {
        super(cause);
    }

    public RequestMoreContentExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
