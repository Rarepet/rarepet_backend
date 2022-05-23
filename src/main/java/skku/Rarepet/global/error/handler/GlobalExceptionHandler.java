package skku.Rarepet.global.error.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import skku.Rarepet.global.error.ErrorResponse;
import skku.Rarepet.global.error.exception.CustomException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorResponse<Object> response = new ErrorResponse<>(e.getMessage(), e.getCode());
        return new ResponseEntity<>(response, e.getHttpStatus());
    }
}
