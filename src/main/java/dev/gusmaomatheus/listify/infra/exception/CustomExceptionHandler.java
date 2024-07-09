package dev.gusmaomatheus.listify.infra.exception;

import dev.gusmaomatheus.listify.infra.exception.custom.UsernameAlreadyRegisteredException;
import dev.gusmaomatheus.listify.infra.exception.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameAlreadyRegisteredException.class)
    private ResponseEntity<ExceptionResponse> usernameAlreadyRegistered(UsernameAlreadyRegisteredException exception) {
        return ResponseEntity.status(400).body(
                new ExceptionResponse(
                        400,
                        exception.getMessage(),
                        "The username you tried to register is already in use by someone else in our system.",
                        LocalDateTime.now()
                )
        );
    }
}
