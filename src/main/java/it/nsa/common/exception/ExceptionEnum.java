package it.nsa.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

    USER_NOT_FOUND("User not found"),
    AUDIT_NOT_FOUND("Audit not found"),
    INVALID_TOKEN("Invalid token"),
    USER_ALREADY_EXISTS("User already exists"),
    INVALID_CREDENTIALS("Invalid credentials");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public static ExceptionEnum valueOfMessage(String message) {
        for (ExceptionEnum e : ExceptionEnum.values()) {
            if (e.getMessage().equals(message)) {
                return e;
            }
        }
        return null;
    }

}
