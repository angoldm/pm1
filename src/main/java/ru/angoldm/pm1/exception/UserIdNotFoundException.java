package ru.angoldm.pm1.exception;

public class UserIdNotFoundException extends AppException{
    public UserIdNotFoundException(Long id) {
        super("User with id: " + id + " not found.");
    }
}
