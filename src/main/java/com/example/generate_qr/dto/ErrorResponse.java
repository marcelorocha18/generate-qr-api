package com.example.generate_qr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private Integer status;
    private String contentType;
    private Boolean isBinary;

}