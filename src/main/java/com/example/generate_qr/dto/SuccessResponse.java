package com.example.generate_qr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResponse {

    private Integer status;
    private String contentType;
    private Boolean isBinary;
    private String dataSize;

}