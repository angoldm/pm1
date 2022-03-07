package ru.angoldm.pm1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.angoldm.pm1.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
