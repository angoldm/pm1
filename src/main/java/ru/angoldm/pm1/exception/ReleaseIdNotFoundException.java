package ru.angoldm.pm1.exception;

public class ReleaseIdNotFoundException extends AppException{
    public ReleaseIdNotFoundException(Long id) {
        super("Release with id: " + id + " not found.");
    }
}
