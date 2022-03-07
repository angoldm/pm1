package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.angoldm.pm1.dto.TaskStatusDto;
import ru.angoldm.pm1.service.TaskStatusService;

import java.util.List;

import static java.lang.String.format;

@Tag(name = "TaskStatus controller", description = "TaskStatus management / Управление статусом задачи")
@RestController
@RequestMapping("/taskstatus")
public class TaskStatusController {

    private final TaskStatusService taskStatusService;

    @Autowired
    public TaskStatusController(TaskStatusService taskStatusService) {
        this.taskStatusService = taskStatusService;
    }

    @Operation(
            summary = "Создание нового/редактирование существующего статуса задачи",
            description = "Позволяет: создать запись о новом статусе или изменить данные о статусе с ид. = id (добввить строку:   \"id\": {id}, ) "
    )
    @PostMapping
    public ResponseEntity<TaskStatusDto> createTaskStatus(@RequestBody TaskStatusDto taskStatusDto) {
        return ResponseEntity.ok(taskStatusService.createTaskStatus(taskStatusDto));
    }

    @Operation(
            summary = "Список статусов задач",
            description = "Выводит в формате JSON массив всех статусов задач с доп. информацией"
    )
    @GetMapping
    public ResponseEntity<List<TaskStatusDto>> findAll() {
        return ResponseEntity.ok(taskStatusService.findAll());
    }

    @Operation(
            summary = "Удаление статуса задачи",
            description = "Позволяет удалить запись о статусе задачи по ее идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор проекта") Long id) {
        taskStatusService.delete(id);
        return ResponseEntity.ok(format("Статус задачи с идентификатором %d удален", id));
    }
}
