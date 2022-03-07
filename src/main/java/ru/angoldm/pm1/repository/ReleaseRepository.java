package ru.angoldm.pm1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.angoldm.pm1.entity.Release;

import java.util.Optional;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
    Optional<Release> findById(String id);
}
