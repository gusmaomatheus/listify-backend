package dev.gusmaomatheus.listify.infra.exception.custom;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
