package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ru.angoldm.pm1.dto.ProjectDto;
import ru.angoldm.pm1.service.ProjectService;

import java.util.List;

import static java.lang.String.format;

@Tag(name = "Project controller", description = "Project management / Управление проектом")
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(
            summary = "Создание нового/редактирование существующего проекта",
            description = "Позволяет: создать запись о новом проекте или изменить данные о проекте с ид. = id (добввить строку:   \"id\": {id}, )"
    )
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.createProject(projectDto));
    }

    @Operation(
            summary = "Список проектов",
            description = "Выводит в формате JSON массив всех проектов с доп. информацией"
    )
    @GetMapping
    public ResponseEntity<List<ProjectDto>> findAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @Operation(
            summary = "Редактирование существующего проекта",
            description = "Позволяет изменить данные о проекте с идентификатором id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto, @PathVariable @Parameter(description = "Идентификатор проекта") Long id) {
        return ResponseEntity.ok(projectService.updateProject(projectDto, id));
    }

    @Operation(
            summary = "Удаление проекта",
            description = "Позволяет удалить запись о проекте по его идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор проекта") Long id) {
        projectService.delete(id);
        return ResponseEntity.ok(format("Проект с идентификатором %d удален", id));
    }
}
