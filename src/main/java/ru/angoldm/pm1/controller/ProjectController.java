package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            summary = "Удаление проекта",
            description = "Позволяет удалить запись о проекте по его идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор проекта") Long id) {
        projectService.delete(id);
        return ResponseEntity.ok(format("Проект с идентификатором %d удален", id));
    }
}
