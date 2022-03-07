package ru.angoldm.pm1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность доски задач")
public class BoardDto {

    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Название доски")
    private String name;
    @Schema(description = "Идентификатор проекта")
    private Long projectId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getProjectId() { return projectId; }

    public void setProjectId(Long projectId) { this.projectId = projectId; }
}
