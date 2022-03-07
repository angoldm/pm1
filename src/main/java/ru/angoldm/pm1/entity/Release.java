package ru.angoldm.pm1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.sql.Timestamp;

@Entity
public class Release {

    @Id
    @SequenceGenerator(name = "releaseIdSeq", sequenceName = "release_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "releaseIdSeq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task_id", columnDefinition = "bigint", nullable = false)
    private Long taskId;

    @Column(name = "start_dt", columnDefinition = "timestamptz default now()", nullable = false)
    private Timestamp startDt;

    @Column(name = "end_dt", columnDefinition = "timestamptz", nullable = true)
    private Timestamp endDt;

    @Column(name = "version", columnDefinition = "varchar(20) default '0.0.1'", nullable = false, unique = true)
    private String version;

    public Long getId() { return id; }

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
