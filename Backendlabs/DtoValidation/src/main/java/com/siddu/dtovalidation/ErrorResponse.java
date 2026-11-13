package com.siddu.dtovalidation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    String url;
    LocalDateTime timestamp;
    String status;
    String message;
}
