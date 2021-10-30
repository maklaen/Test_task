package com.test.test_project.config.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public String validConstraintViolationExceptionMessage(ConstraintViolationException exception) {
        return exception.getConstraintViolations()
                .stream().map(exc -> String.format("%s : %s", exc.getPropertyPath().toString(), exc.getMessage()))
                .collect(Collectors.joining("\n"));
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String validNullPointerExceptionMessage(NullPointerException exception) {
        return "The first and last name should not be empty!";
    }

    @ExceptionHandler(value = Exception.class)
    public String validExceptionMessage(Exception exception) {
        return exception.getMessage();
    }


}
