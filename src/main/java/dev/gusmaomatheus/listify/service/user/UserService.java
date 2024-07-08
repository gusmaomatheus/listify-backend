package dev.gusmaomatheus.listify.service.user;

import dev.gusmaomatheus.listify.dto.auth.RegisterRequestDTO;

public interface UserService {
    void register(RegisterRequestDTO request);
}
