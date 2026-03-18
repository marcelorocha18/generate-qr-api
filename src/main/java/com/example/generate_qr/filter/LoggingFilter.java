package com.example.generate_qr.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        long startTime = System.currentTimeMillis();

        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(response);

        filterChain.doFilter(request, wrappedResponse);

        long duration = System.currentTimeMillis() - startTime;

        String responseBody = new String(
                wrappedResponse.getContentAsByteArray(),
                StandardCharsets.UTF_8
        );

        String traceId = request.getHeader("traceId");

        System.out.println(
                "{"
                        + "\"traceId\":\"" + traceId + "\","
                        + "\"method\":\"" + request.getMethod() + "\","
                        + "\"path\":\"" + request.getRequestURI() + "\","
                        + "\"status\":" + wrappedResponse.getStatus() + ","
                        + "\"durationMs\":" + duration + ","
                        + "\"responseBody\":" + responseBody
                        + "}"
        );

        wrappedResponse.copyBodyToResponse();
    }
}