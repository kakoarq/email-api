package com.kakoarq.emailapi.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RequestHeaders {
    AUTHORIZATION("Authorization"),
    CONTENT_TYPE("Content-Type"),
    ACCEPT("Accept");

    private final String headerName;


}
