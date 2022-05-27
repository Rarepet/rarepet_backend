package skku.Rarepet.global.error;

import lombok.Getter;
import skku.Rarepet.global.error.enums.ErrorCode;

@Getter
public class ErrorResponse<T> {

    private final String message;
    private final String error;
    private final T data;

    public ErrorResponse(String message, String error, T data) {
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public ErrorResponse(String message, String error) {
        this.message = message;
        this.error = error;
        this.data = null;
    }

    // custom exception response
    public ErrorResponse(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.error = errorCode.toString();
        this.data = null;
    }
}
