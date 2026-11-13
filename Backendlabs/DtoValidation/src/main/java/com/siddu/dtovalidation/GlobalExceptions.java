package com.siddu.dtovalidation;



import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(ProductExistException.class)
    public ResponseEntity<ErrorResponse> handlexistexception(ProductExistException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ErrorResponse(request.getRequestURI(),
                        LocalDateTime.now(),
                HttpStatus.CONFLICT.name(),
                        ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponse(
                        request.getRequestURI(),
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.name(),
                        errors
                ));
    }
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<ErrorResponse> handleException(
            HttpMessageNotWritableException ex,
            HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse(
                request.getRequestURI(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                "Unable to serialize the response"
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
