package ru.angoldm.pm1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.angoldm.pm1.entity.Task;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByStatusId(String statusId);
}
