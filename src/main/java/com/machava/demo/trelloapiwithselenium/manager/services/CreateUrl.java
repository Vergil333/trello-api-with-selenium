package com.machava.demo.trelloapiwithselenium.manager.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machava.demo.trelloapiwithselenium.config.ApplicationProperties;

@Service
public class CreateUrl {

    @Autowired
    private ApplicationProperties applicationProperties;

    private String trelloApiUrl = "https://api.trello.com/1/boards/";
    private String credentials;

    @PostConstruct
    public void init() {
        credentials = "?key=" + applicationProperties.trelloKey + "&token=" + applicationProperties.token;
    }

    public String lists() {
        return trelloApiUrl + applicationProperties.demoBoard + "/lists" + credentials;
    }

    public String cards() {
        return trelloApiUrl + applicationProperties.demoBoard + "/cards" + credentials;
    }

}
