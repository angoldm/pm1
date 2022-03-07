package ru.angoldm.pm1.exception;

public class TaskIdNotFoundException extends AppException{
    public TaskIdNotFoundException(Long id) {
        super("Task with id: " + id + " not found.");
    }
}
