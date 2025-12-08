package com.davi.learning_spring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsurppotedMathOperationException extends RuntimeException {
    public UnsurppotedMathOperationException (String exception){
        super(exception);
    }
    
}
