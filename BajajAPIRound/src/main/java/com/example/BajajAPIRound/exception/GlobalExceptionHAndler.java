package com.example.BajajAPIRound.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHAndler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleException(Exception ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("is_success", false);
        response.put("message", ex.getMessage());

        return response;
    }
}