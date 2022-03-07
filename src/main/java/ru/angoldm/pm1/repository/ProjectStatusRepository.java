package ru.angoldm.pm1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.angoldm.pm1.entity.ProjectStatus;

import java.util.Optional;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long> {
    Optional<ProjectStatus> findByName(String name);
}
