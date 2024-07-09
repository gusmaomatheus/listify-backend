package dev.gusmaomatheus.listify.infra.exception.custom;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
