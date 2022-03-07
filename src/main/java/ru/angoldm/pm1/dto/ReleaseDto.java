package ru.angoldm.pm1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.sql.Timestamp;

@Schema(description = "Сущность релиза задачи")
public class ReleaseDto {

    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Идентификатор задачи")
    private Long taskId;
    @Schema(description = "Время начала выполнения")
    private Timestamp startDt;
    @Schema(description = "Время завершения работ")
    private Timestamp endDt;
    @Schema(description = "Версия релиза задачи")
    private String version;

    public  Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getTaskId() { return taskId; }

    public void setTaskId(Long taskId) { this.taskId = taskId; }

    public Timestamp getStartDt() { return startDt; }

    public void setStartDt(Timestamp startDt) { this.startDt = startDt; }

    public Timestamp getEndDt() { return endDt; }

    public void setEndDt(Timestamp endDt) { this.endDt = endDt; }

    public String getVersion() { return version; }

    public void setVersion(String version) { this.version = version; }
}
