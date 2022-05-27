package skku.Rarepet.global.error.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import skku.Rarepet.global.error.ErrorResponse;
import skku.Rarepet.global.error.enums.ErrorCode;
import skku.Rarepet.global.error.exception.CustomException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    //custom exception handler
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorResponse<Object> response = new ErrorResponse<>(e.getMessage(), e.getCode());
        return new ResponseEntity<>(response, e.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse<Object> handleException(Exception e) {
        log.error("Message: {}\nCause: {}\nStackTrace: {}",
                e.getMessage(),
                e.getCause(),
                e.getStackTrace());
        return new ErrorResponse<>(ErrorCode.CONFLICT.getMessage(), null, null);
    }
}
