package ru.angoldm.pm1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.angoldm.pm1.dto.UserDto;
import ru.angoldm.pm1.service.UserService;

import java.util.List;

import static java.lang.String.format;

@Tag(name = "User controller", description = "User management / Управление пользователями")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Создание нового/редактирование существующего пользователя",
            description = "Позволяет: создать запись о новом пользователе или изменить данные о пользователе с ид. = id (добввить строку:   \"id\": {id}, ) "
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @Operation(
            summary = "Список пользователей",
            description = "Выводит в формате JSON массив всех пользователей с доп. информацией"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Operation(
            summary = "Редактирование существующего пользователя",
            description = "Позволяет изменить данные о пользователе с идентификатором id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable @Parameter(description = "Идентификатор пользователя") Long id) {
        return ResponseEntity.ok(userService.updateUser(userDto, id));
    }

    @Operation(
            summary = "Удаление пользователя",
            description = "Позволяет удалить запись о пользователе по его идентификатору"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Идентификатор пользователя") Long id) {
        userService.delete(id);
        return ResponseEntity.ok(format("Пользователь с идентификатором %d удален", id));
    }
}
