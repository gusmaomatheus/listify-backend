package dev.gusmaomatheus.listify.service.user;

import dev.gusmaomatheus.listify.domain.user.User;
import dev.gusmaomatheus.listify.dto.auth.RegisterRequestDTO;
import dev.gusmaomatheus.listify.infra.exception.exceptions.UsernameAlreadyRegisteredException;
import dev.gusmaomatheus.listify.infra.security.SecurityConfig;
import dev.gusmaomatheus.listify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final SecurityConfig securityConfig;

    @Override
    public void register(RegisterRequestDTO request) {
        if (repository.findByUsername(request.username()).isPresent()) {
            throw new UsernameAlreadyRegisteredException("There is already a registered user using this username.");
        }

        User user = new User(request.firstName(), request.lastName(), request.username(), securityConfig.passwordEncoder().encode(request.password()));

        repository.save(user);
    }
}
