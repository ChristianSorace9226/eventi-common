package it.nsa.common.util;

import lombok.Getter;

@Getter
public enum StatoEnum {
    SUCCESS("success"),
    FAILED("failed"),
    UTENTE_AUTENTICATO("already authenticated"),
    NO_AUTENTCAZIONE("missing authentication");

    final String message;

    StatoEnum(String message) {
        this.message = message;
    }
}
