package com.example.generate_qr.controller;

import com.example.generate_qr.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/generateqr")
    public Object payment(
            @RequestHeader("traceId") String traceId,
            @RequestHeader("x-http-answer") Integer httpAnswer,
            @RequestBody PaymentRequest request
    ) {

        log.info("traceId={} request={}", traceId, request);

        if (!isValidUUID(traceId)) {
            return new BadRequestResponse(400, "traceId must be uuid");
        }

        switch (httpAnswer) {

            case 200:
                return new SuccessResponse(
                        200,
                        "image/jpeg",
                        true,
                        "text/json"
                );

            case 400:
                return new BadRequestResponse(
                        400,
                        "bad request"
                );

            case 500:
                return new ErrorResponse(
                        500,
                        "image/jpeg",
                        true
                );

            default:
                return new BadRequestResponse(
                        400,
                        "invalid x-http-answer"
                );
        }
    }

    private boolean isValidUUID(String value) {
        try {
            UUID.fromString(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}