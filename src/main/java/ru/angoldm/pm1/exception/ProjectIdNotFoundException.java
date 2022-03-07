package ru.angoldm.pm1.exception;

public class ProjectIdNotFoundException extends AppException{
    public ProjectIdNotFoundException(Long id) {
        super("Project with id: " + id + " not found.");
    }
}
