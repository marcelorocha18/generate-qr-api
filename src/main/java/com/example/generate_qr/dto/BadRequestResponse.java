package com.example.generate_qr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequestResponse {

    private Integer status;
    private String message;

}