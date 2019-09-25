package com.efg.clientbackend.controllers.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value= NOT_FOUND, reason="No such User")  // 404
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (final String id) {
        super(format("User with id: %s could not be found", id));
    }
}
