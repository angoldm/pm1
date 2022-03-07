package ru.angoldm.pm1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Board {

    @Id
    @SequenceGenerator(name = "boardIdSeq", sequenceName = "board_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boardIdSeq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "project_id", columnDefinition = "bigint", nullable = false)
    private Long projectId;

    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false)
    private String name;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getProjectId() { return projectId; }

    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }
}
