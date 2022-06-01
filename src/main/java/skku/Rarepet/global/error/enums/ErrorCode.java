package skku.Rarepet.global.error.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {

    //Common
    NOT_FOUND(404, "요청한 정보가 없습니다."),
    CONFLICT(409, "서버의 정보와 요청이 충돌했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),

    //Auth
    UNAUTHORIZED(401, "인증되지 않은 사용자입니다."),
    FORBIDDEN(403, "권한이 없습니다"),

    //User
    USER_ALREADY_EXIST(409, "유저가 이미 존재합니다."),
    USER_NOT_EXIST(404, "유저가 존재하지 않습니다."),

    //ChatRoom
    CHATROOM_ALREADY_EXIST(409, "채팅방이 이미 존재합니다."),
    CHATROOM_NOT_EXIST(404, "채팅방이 존재하지 않습니다.");


    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
