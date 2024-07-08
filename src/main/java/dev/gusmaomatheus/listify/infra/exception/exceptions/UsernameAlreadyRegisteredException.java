package dev.gusmaomatheus.listify.infra.exception.exceptions;

public class UsernameAlreadyRegisteredException extends RuntimeException {

    public UsernameAlreadyRegisteredException(String message) {
        super(message);
    }
}
