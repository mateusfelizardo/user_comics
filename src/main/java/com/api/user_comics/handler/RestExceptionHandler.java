package com.api.user_comics.handler;

import com.api.user_comics.error.ResourceNotFoundDetails;
import com.api.user_comics.error.ResourceNotFoundException;
import com.api.user_comics.error.SaveObjectException;
import com.api.user_comics.error.SaveObjectExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.ResourceNotFoundDetailsBuilder
                .newBuilder()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resouce not found")
                .details(rnfException.getMessage())
                .developerMessage(rnfException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SaveObjectException.class)
    public ResponseEntity<?> handleSaveObjectException(SaveObjectException soException){
        SaveObjectExceptionDetails soExceptionDetails = SaveObjectExceptionDetails.SaveObjectExceptionDetailsBuilder
                .newBuilder()
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .title("Object Not Acceptable")
                .details(soException.getMessage())
                .developerMessage(soException.getClass().getName())
                .build();
        return new ResponseEntity<>(soExceptionDetails,HttpStatus.NOT_ACCEPTABLE);
    }
}
