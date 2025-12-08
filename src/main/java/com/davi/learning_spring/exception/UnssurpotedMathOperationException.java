package com.davi.learning_spring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnssurpotedMathOperationException extends RuntimeException {
    public UnssurpotedMathOperationException (String exception){
        super(exception);
    }
    
}
