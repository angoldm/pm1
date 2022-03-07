package ru.angoldm.pm1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность проекта")
public class ProjectDto {

    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Название")
    private String name;
    @Schema(description = "Идентификатор статуса (при создании устанавливается = 1)")
    private Short statusId;

    public  Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Short getStatusId() { return statusId; }

    public void setStatusId(Short statusId) { this.statusId = statusId; }
}
