package ru.angoldm.pm1.controller.advice;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.angoldm.pm1.exception.AppException;

import java.net.ConnectException;

import static java.lang.String.format;

@RestControllerAdvice
public class AbstractRestController {

    @ExceptionHandler({AppException.class})
    public ResponseEntity<String> handleAppException(AppException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> handleConnectException(ConnectException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);//503
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintException(ConstraintViolationException e) {
        return new ResponseEntity<>(format("%s \n%s", e.getCause(), e.getMessage()), HttpStatus.CONFLICT);//409
    }

    /*@ExceptionHandler(DataIntegrityViolationException.class) //менее информативное, чем ConstraintViolationException
    public ResponseEntity<String> handleDataIntegrityException(DataIntegrityViolationException e) {
        return new ResponseEntity<>(format("%s \n%s", e.getCause(), e.getMessage()), HttpStatus.CONFLICT);//409
    }*/
}