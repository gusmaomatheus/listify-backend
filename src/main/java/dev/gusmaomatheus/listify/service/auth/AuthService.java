package dev.gusmaomatheus.listify.service.auth;

import dev.gusmaomatheus.listify.dto.auth.LoginRequestDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    String login(LoginRequestDTO request);
}
