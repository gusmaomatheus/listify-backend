package dev.gusmaomatheus.listify.service.auth;

import dev.gusmaomatheus.listify.domain.user.User;
import dev.gusmaomatheus.listify.dto.auth.LoginRequestDTO;
import dev.gusmaomatheus.listify.infra.exception.custom.InvalidPasswordException;
import dev.gusmaomatheus.listify.infra.security.SecurityConfig;
import dev.gusmaomatheus.listify.infra.token.TokenServiceImpl;
import dev.gusmaomatheus.listify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final TokenServiceImpl token;
    private final SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("No records found for username %s.", username));
        }

        return new org.springframework.security.core.userdetails.User(username, user.get().getPassword(), new ArrayList<>());
    }

    @Override
    public String login(LoginRequestDTO request) throws Exception {
        Optional<User> user = userRepository.findByUsername(request.username());

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No user with that username was found.");
        }

        if (!securityConfig.passwordEncoder().matches(request.password(), user.get().getPassword())) {
            throw new InvalidPasswordException("Wrong password for this username.");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication authentication = securityConfig.authenticationManager(new AuthenticationConfiguration()).authenticate(usernamePasswordAuthenticationToken);


        return token.generateToken((User) authentication.getPrincipal());
    }
}
