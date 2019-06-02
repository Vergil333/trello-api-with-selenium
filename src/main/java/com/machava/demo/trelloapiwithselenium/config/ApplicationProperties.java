package com.machava.demo.trelloapiwithselenium.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@EnableConfigurationProperties
public class ApplicationProperties {

    @Value("${spring.security.client.client-id}")
    public String user;

    @Value("${spring.security.client.client-secret}")
    public String password;

    @Value("${trello.api-key}")
    public String trelloKey;

    @Value("${trello.secret}")
    public String secret;

    @Value("${trello.token}")
    public String token;

    @Value("${trello.demo-board-id}")
    public String demoBoard;

}
