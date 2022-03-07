package ru.angoldm.pm1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность задачи")
public class TaskDto {

    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Идентификатор доски задач")
    private Long boardId;
    @Schema(description = "Идентификатор статуса (при создании устанавливается = 1)")
    private Short statusId;
    @Schema(description = "Идентификатор автора задачи")
    private Long authorId;
    @Schema(description = "Идентификатор исполнителя")
    private Long executorId;
    @Schema(description = "Описание задачи")
    private String descr;

    public  Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Short getStatusId() { return statusId; }

    public void setStatusId(Short statusId) { this.statusId = statusId; }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    public String getDescr() { return descr; }

    public void setDescr(String descr) { this.descr = descr; }
}
