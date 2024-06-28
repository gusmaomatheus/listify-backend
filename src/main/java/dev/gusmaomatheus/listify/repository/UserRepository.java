package dev.gusmaomatheus.listify.repository;

import dev.gusmaomatheus.listify.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
