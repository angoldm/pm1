package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.angoldm.pm1.dto.ProjectStatusDto;
import ru.angoldm.pm1.service.ProjectStatusService;

import java.util.List;

import static java.lang.String.format;

@Tag(name = "ProjectStatus controller", description = "ProjectStatus management / Управление статусом проектом")
@RestController
@RequestMapping("/projectstatus")
public class ProjectStatusController {

    private final ProjectStatusService projectStatusService;

    @Autowired
    public ProjectStatusController(ProjectStatusService projectStatusService) {
        this.projectStatusService = projectStatusService;
    }

    @Operation(
            summary = "Создание нового/редактирование существующего статуса проекта",
            description = "Позволяет: создать запись о новом статусе или изменить данные о статусе с ид. = id (добввить строку:   \"id\": {id}, ) "
    )
    @PostMapping
    public ResponseEntity<ProjectStatusDto> createProjectStatus(@RequestBody ProjectStatusDto projectStatusDto) {
        return ResponseEntity.ok(projectStatusService.createProjectStatus(projectStatusDto));
    }

    @Operation(
            summary = "Список статусов проекта",
            description = "Выводит в формате JSON массив всех статусов проекта с доп. информацией"
    )
    @GetMapping
    public ResponseEntity<List<ProjectStatusDto>> findAll() {
        return ResponseEntity.ok(projectStatusService.findAll());
    }

    @Operation(
            summary = "Удаление статуса проекта",
            description = "Позволяет удалить запись о статусе по его идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор статуса") Long id) {
        projectStatusService.delete(id);
        return ResponseEntity.ok(format("Статус проекта с идентификатором %d удален", id));
    }
}
