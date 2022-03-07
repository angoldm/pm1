package ru.angoldm.pm1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Task {

    @Id
    @SequenceGenerator(name = "taskIdSeq", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskIdSeq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "board_id", columnDefinition = "bigint", nullable = true)
    private Long boardId;

    @Column(name = "status_id", columnDefinition = "smallint default 1", nullable = false, insertable = false)  //по умолчанию вставляется = 1
    private Short statusId;

    @Column(name = "author_id", columnDefinition = "bigint", nullable = false)
    private Long authorId;

    @Column(name = "executor_id", columnDefinition = "bigint", nullable = true)
    private Long executorId;

    @Column(name = "descr", columnDefinition = "varchar(255)", nullable = false)
    private String descr;

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }

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
