package dev.gusmaomatheus.listify.service.user;

import dev.gusmaomatheus.listify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
}
