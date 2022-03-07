package ru.angoldm.pm1.exception;

public class ProjectStatusIdNotFoundException extends AppException{
    public ProjectStatusIdNotFoundException(Long id) {
        super("ProjectStatus with id: " + id + " not found.");
    }
}
