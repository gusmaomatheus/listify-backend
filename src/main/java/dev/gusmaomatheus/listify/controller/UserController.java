package dev.gusmaomatheus.listify.controller;

import dev.gusmaomatheus.listify.dto.auth.AuthResponseDTO;
import dev.gusmaomatheus.listify.dto.auth.RegisterRequestDTO;
import dev.gusmaomatheus.listify.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        service.register(request);

        return ResponseEntity.status(201).body(new AuthResponseDTO(request.username(), ""));
    }
}
