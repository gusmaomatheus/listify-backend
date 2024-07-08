package dev.gusmaomatheus.listify.infra.exception.response;

import java.time.LocalDateTime;

public record ExceptionResponse(int status, String message, String details, LocalDateTime timestamp) {}
