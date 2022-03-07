package ru.angoldm.pm1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность статуса проекта")
public class ProjectStatusDto {

    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Код статуса")
    private String code;
    @Schema(description = "Описание статуса")
    private String name;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
