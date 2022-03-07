package ru.angoldm.pm1.exception;

public class BoardIdNotFoundException extends AppException{
    public BoardIdNotFoundException(Long id) {
        super("Board with id: " + id + " not found.");
    }
}
