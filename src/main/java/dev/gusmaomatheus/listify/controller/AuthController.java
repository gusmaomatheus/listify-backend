package dev.gusmaomatheus.listify.controller;

import dev.gusmaomatheus.listify.dto.auth.AuthResponseDTO;
import dev.gusmaomatheus.listify.dto.auth.LoginRequestDTO;
import dev.gusmaomatheus.listify.service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl service;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) throws Exception {
        String token = service.login(request);

        return ResponseEntity.status(200).body(
                new AuthResponseDTO(
                        request.username(),
                        token
                )
        );
    }
}
