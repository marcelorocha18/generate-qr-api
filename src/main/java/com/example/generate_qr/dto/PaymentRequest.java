package com.example.generate_qr.dto;

import lombok.Data;

@Data
public class PaymentRequest {

    private Integer amount;
    private String period;
    private String description;
    private Boolean isSingleUse;
    private Integer expirationDays;
    private String tradeId;
    private String invoiceId;
    private String externalId;
    private String customerId;
    private String extra1;
    private String extra2;
    private String extra3;
    private String extra4;

}