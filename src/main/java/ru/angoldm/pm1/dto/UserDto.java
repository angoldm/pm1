package ru.angoldm.pm1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность пользователя")
public class UserDto {

    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Логин пользователя")
    private String login;
    @Schema(description = "Имя пользователя")
    private String name;
    @Schema(description = "Фамилия пользователя")
    private String surname;
    @Schema(description = "Эл. почта пользователя")
    private String email;
    @Schema(description = "Пароль для входа в приложение")
    private String password;

    public  Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
