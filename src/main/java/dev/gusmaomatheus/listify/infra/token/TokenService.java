package dev.gusmaomatheus.listify.infra.token;

import dev.gusmaomatheus.listify.domain.user.User;

public interface TokenService {
    String generateToken(User user);
    String validateToken(String token);
}
