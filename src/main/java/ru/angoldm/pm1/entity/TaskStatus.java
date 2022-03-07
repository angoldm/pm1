package ru.angoldm.pm1.entity;

import javax.persistence.*;

@Entity
public class TaskStatus {

    @Id
    @SequenceGenerator(name = "task_statusIdSeq", sequenceName = "task_status_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_statusIdSeq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", columnDefinition = "varchar(20)", nullable = false, unique = true)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false, unique = true)
    private String name;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
