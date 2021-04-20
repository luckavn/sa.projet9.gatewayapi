package com.axa.softwareacademy.apigateway.configuration;

import feign.Request;
import org.springframework.context.annotation.Bean;

public class ClientConfiguration {

    private static final int CONNECT_TIMEOUT_MILLIS = 5000;
    private static final int READ_TIMEOUT_MILLIS = 5000;

    @Bean
    public ClientErrorDecoder recaptchaApiClientErrorDecoder() {
        return new ClientErrorDecoder();
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECT_TIMEOUT_MILLIS, READ_TIMEOUT_MILLIS);
    }
}
