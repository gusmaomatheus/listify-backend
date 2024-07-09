package dev.gusmaomatheus.listify.infra.exception.custom;

public class UsernameAlreadyRegisteredException extends RuntimeException {

    public UsernameAlreadyRegisteredException(String message) {
        super(message);
    }
}
