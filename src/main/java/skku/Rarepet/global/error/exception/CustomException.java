package skku.Rarepet.global.error.exception;

import org.springframework.http.HttpStatus;
import skku.Rarepet.global.error.enums.ErrorCode;

public class CustomException extends RuntimeException{

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.valueOf(errorCode.getStatus());
    }

    public String getCode() {
        return errorCode.toString();
    }
}
