package com.pfm.project.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

public class SuccessResponseBody {
    private HttpStatus status = HttpStatus.OK;
    private String message = "Success";
    private Object data  = null;

    @Builder
    public SuccessResponseBody(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
