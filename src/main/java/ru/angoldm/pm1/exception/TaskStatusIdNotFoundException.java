package ru.angoldm.pm1.exception;

public class TaskStatusIdNotFoundException extends AppException{
    public TaskStatusIdNotFoundException(Long id) {
        super("TaskStatus with id: " + id + " not found.");
    }
}
