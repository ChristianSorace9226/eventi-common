package it.nsa.common.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventException extends RuntimeException {

    private final ExceptionEnum exceptionEnum;

    public EventException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }
}
