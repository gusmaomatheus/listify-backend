package dev.gusmaomatheus.listify.infra.token;

import org.springframework.security.core.userdetails.User;

public interface TokenService {
    String generateToken(User user);
    String validateToken(String token);
}
