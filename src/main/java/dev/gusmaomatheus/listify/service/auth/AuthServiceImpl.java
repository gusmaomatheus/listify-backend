package dev.gusmaomatheus.listify.service.auth;

import dev.gusmaomatheus.listify.domain.user.User;
import dev.gusmaomatheus.listify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("No records found for username %s.", username));
        }

        return new org.springframework.security.core.userdetails.User(username, user.get().getPassword(), new ArrayList<>());
    }
}
