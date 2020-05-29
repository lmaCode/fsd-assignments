package com.lipengwei.fsd.config;

import com.lipengwei.fsd.exception.FSDException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ActionAdvice {
    @ExceptionHandler(FSDException.class)
    public String bindFSDExceptionHandler(FSDException ex) {
        return ex.getMessage();
    }
}
