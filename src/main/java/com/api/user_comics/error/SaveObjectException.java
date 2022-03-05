package com.api.user_comics.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class SaveObjectException extends RuntimeException{
    public SaveObjectException(String message) {
        super(message);
    }
}
