package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.angoldm.pm1.dto.BoardDto;
import ru.angoldm.pm1.service.BoardService;

import java.util.List;

import static java.lang.String.format;

@Tag(name = "Board of tasks controller", description = "Board of tasks management / Управление доской задач")
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @Operation(
            summary = "Создание новой/редактирование существующей доски задач",
            description = "Позволяет: создать запись о новой доске задач или изменить данные о доске задач с ид. = id (добввить строку:   \"id\": {id}, ) "
    )
    @PostMapping
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(boardService.createBoard(boardDto));
    }

    @Operation(
            summary = "Список досок задач",
            description = "Выводит в формате JSON массив всех досок задач с доп. информацией"
    )
    @GetMapping
    public ResponseEntity<List<BoardDto>> findAll() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @Operation(
            summary = "Редактирование существующей доски задач",
            description = "Позволяет изменить данные о доске задач с идентификатором id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<BoardDto> updateBoard(@RequestBody BoardDto boardDto, @PathVariable @Parameter(description = "Идентификатор доски задач") Long id) {
        return ResponseEntity.ok(boardService.updateBoard(boardDto, id));
    }

    @Operation(
            summary = "Удаление доски задач",
            description = "Позволяет удалить запись о доске задач по ее идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор доски задач") Long id) {
        boardService.delete(id);
        return ResponseEntity.ok(format("Доска с идентификатором %d удалена", id));
    }
}
