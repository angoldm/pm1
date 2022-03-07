package ru.angoldm.pm1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.angoldm.pm1.entity.Board;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByName(String name);
}
