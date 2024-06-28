package dev.gusmaomatheus.listify.infra.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import dev.gusmaomatheus.listify.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${api.security.token.secret}")
    private String secretKey;

    @Override
    public String generateToken(User user) {
        try {
            return JWT.create()
                    .withIssuer("listify-api")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateExpirationDate())
                    .sign(Algorithm.HMAC256(secretKey));
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating.");
        }
    }

    @Override
    public String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(secretKey))
                    .withIssuer("listify-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }
}
