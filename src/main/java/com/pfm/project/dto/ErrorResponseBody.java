package com.pfm.project.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponseBody<T> {
    private LocalDateTime timeStamp = LocalDateTime.now();
    private int status = HttpStatus.BAD_REQUEST.value();
    private String error = null;
    private String code = HttpStatus.BAD_REQUEST.name();
    private String message = "Failed to process request";
}
