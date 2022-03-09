package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.angoldm.pm1.dto.TaskDto;
import ru.angoldm.pm1.service.TaskService;

import java.util.List;

import static java.lang.String.format;

@Tag(name = "Task controller", description = "Task management / Управление задачами")
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
        summary = "Создание новой/редактирование существующей задачи",
        description = "Позволяет: создать запись о новой задаче или изменить данные о задаче с ид. = id (добввить строку:   \"id\": {id}, ) "
    )
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @Operation(
            summary = "Список задач",
            description = "Выводит в формате JSON массив всех задач с доп. информацией"
    )
    @GetMapping
    public ResponseEntity<List<TaskDto>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @Operation(
            summary = "Редактирование существующей задачи",
            description = "Позволяет изменить данные о задаче с идентификатором id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto, @PathVariable @Parameter(description = "Идентификатор задачи") Long id) {
        return ResponseEntity.ok(taskService.updateTask(taskDto, id));
    }

    @Operation(
            summary = "Удаление задачи",
            description = "Позволяет удалить запись о задаче по ее идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор задачи") Long id) {
        taskService.delete(id);
        return ResponseEntity.ok(format("Задача с идентификатором %d удалена", id));
    }
}
