package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.angoldm.pm1.dto.ReleaseDto;
import ru.angoldm.pm1.service.ReleaseService;

import java.util.List;

import static java.lang.String.format;

@Tag(name = "Release controller", description = "Release management / Управление релизами задач")
@RestController
@RequestMapping("/release")
public class ReleaseController {

    private final ReleaseService releaseService;

    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @Operation(
        summary = "Создание нового/редактирование существующего релиза задачи",
        description = "Позволяет создать новый релиз задачи или изменить данные о релизе с ид.= id (добввить строку:   \"id\": {id}, )"
    )
    @PostMapping
    public ResponseEntity<ReleaseDto> createRelease(@RequestBody ReleaseDto releaseDto) {
        return ResponseEntity.ok(releaseService.createRelease(releaseDto));
    }

    @Operation(
            summary = "Список релизов задач",
            description = "Выводит в формате JSON массив всех релизов задач"
    )
    @GetMapping
    public ResponseEntity<List<ReleaseDto>> findAll() {
        return ResponseEntity.ok(releaseService.findAll());
    }

    @Operation(
            summary = "Редактирование существующего релиза задачи",
            description = "Позволяет изменить данные о релизе задачи с идентификатором id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ReleaseDto> updateRelease(@RequestBody ReleaseDto releaseDto, @PathVariable @Parameter(description = "Идентификатор релиза") Long id) {
        return ResponseEntity.ok(releaseService.updateRelease(releaseDto, id));
    }

    @Operation(
            summary = "Удаление релиза",
            description = "Позволяет удалить запись о релизе задачи по его идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор релиза") Long id) {
        releaseService.delete(id);
        return ResponseEntity.ok(format("Релмз с идентификатором %d удален", id));
    }
}
